
package bongocat.storage;

import bongocat.tasks.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class Storage {
    private final Path filePath;

    public Storage(String filePath) {
        this.filePath = Path.of(filePath);
    }

    public void save(ArrayList<Task> list) throws IOException {
        Files.createDirectories(filePath.getParent());
        BufferedWriter writer = Files.newBufferedWriter(filePath);
        for (Task t : list) {
            writer.write(t.toSaveFormat());
            writer.newLine();
        }
        writer.close();
    }

    public ArrayList<Task> load() {
        ArrayList<Task> list = new ArrayList<>();
        if (!Files.exists(filePath)) {
            return list;
        }
        try {
            BufferedReader reader = Files.newBufferedReader(filePath);
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Task t = parseLine(line);
                    list.add(t);
                } catch (Exception malformed) {
                    System.out.println("⚠ Corrupted line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("⚠ Error reading save file.");
        }
        return list;
    }

    private Task parseLine(String line) {
        String[] parts = line.split("\\s*\\|\\s*");
        String type = parts[0];
        boolean isDone = parts[1].equals("[X]");
        String name = parts[2];

        switch (type) {
        case "T":
            ToDo todo = new ToDo(name);
            if (isDone) todo.markDone();
            return todo;

        case "D":
            String by = parts[3];
            Deadline d = new Deadline(name, by);
            if (isDone) d.markDone();
            return d;

        case "E":
            String from = parts[3];
            String to = parts[4];
            Event e = new Event(name, from, to);
            if (isDone) e.markDone();
            return e;
        }
        throw new IllegalArgumentException("Unknown format");
    }
}
