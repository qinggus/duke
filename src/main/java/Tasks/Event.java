package taskClasses;

public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String name, String from, String to) {
        super(name,TaskType.EVENT);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getTypeIcon() {
        return "[E]";
    }
    @Override
    public String toString() { //toString is a actually java thing
        return getTypeIcon()
                + statusBox() + " "
                + name
                + " (from: " + from + " to " + to + ")";
    }

    @Override
    public String toSaveFormat() {
        return "E | " + (isDone ? "[X]" : "[ ]") + " | " + name + " | " + from + " | " + to;
    }
}