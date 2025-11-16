package taskClasses;

public class Deadline extends Task {

    protected String by;

    public Deadline(String name, String by){
        super(name,TaskType.DEADLINE);
        this.by = by;
    }

    @Override
    public String getTypeIcon() {
        return "[D]";
    }

    @Override
    public String toString() {
        return getTypeIcon()
                + statusBox()
                + name
                + " (by: " + by + ")";
    }
    @Override
    public String toSaveFormat() {
        return "T | " + (isDone ? "[X]" : "[ ]") + " | " + name + " | " + by;
    }
}