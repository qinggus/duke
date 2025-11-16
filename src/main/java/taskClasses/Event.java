package taskExtentions;

public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getTypeIcon() {
        return "[E]";
    }
    public String toString() { //toString is a actually java thing
        return getTypeIcon()
                + statusBox() + " "
                + name
                + " (from: " + from + " to " + to + ")";
    }
}