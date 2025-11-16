
package bongocat.tasks;

public class ToDo extends Task {

    public ToDo(String name) {
        super(name);
    }

    @Override
    public String getTypeIcon() {
        return "[T]";
    }

    @Override
    public String toSaveFormat() {
        return "T | " + (isDone ? "[X]" : "[ ]") + " | " + name;
    }
}
