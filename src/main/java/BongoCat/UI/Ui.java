
package bongocat.ui;

import bongocat.tasks.TaskList;
import bongocat.tasks.Task;
import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        String logo = """
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣶⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣄⣀⡀⣠⣾⡇⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀
⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⡇⠀⠀⠀⠀
⠀⣶⣿⣦⣜⣿⣿⣿⡟⠻⣿⣿⣿⣿⣿⣿⣿⡿⢿⡏⣴⣺⣦⣙⣿⣷⣄⠀⠀⠀
⠀⣯⡇⣻⣿⣿⣿⣿⣷⣾⣿⣬⣥⣭⣽⣿⣿⣧⣼⡇⣯⣇⣹⣿⣿⣿⣿⣧⠀⠀
⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠸⣿⣿⣿⣿⣿⣿⣿⣷
""";

        System.out.println("----------------------------------------------");
        System.out.println("BONGO CAT ACTIVATED! This is DA BONGO CAT.\nHow may I annoy you today?\n" + logo);
        System.out.println("----------------------------------------------");
    }

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showLoadingError() {
        System.out.println("⚠ Error loading file. Starting with an empty belly...");
    }

    public void showGoodbye() {
        System.out.println("GOODBYE.");
    }

    public void showList(TaskList tasks) {
        System.out.println("DA LIST:");
        int index = 1;
        for (Task task : tasks.getAllTasks()) {
            System.out.println(index + ". " + task);
            index++;
        }
    }

    public void showTaskAdded(Task task, int total) {
        System.out.println("OK. I've Added this task:");
        System.out.println(task);
        System.out.println("No. of Tasks in DA LIST: " + total);
    }

    public void showTaskDeleted(Task task, int total) {
        System.out.println("Oki. Removed " + task + ".");
        System.out.println("No. of Tasks in DA LIST: " + total);
    }

    public void showTaskMarked(Task task) {
        System.out.println("NOICE! I've marked this task as DONE:");
        System.out.println("  " + task);
    }

    public void showTaskUnmarked(Task task) {
        System.out.println("Okay! I've UNMARKED this task:");
        System.out.println("  " + task);
    }

    public void showSpaceLeft(int space) {
        System.out.println("Space left: " + space);
    }
}
