package taskExtentions;

public class Deadline extends Task {

    protected String by;

    public Deadline(String name, String by){
        super(name);
        this.by = by;
    }

    @Override
    public String getTypeIcon() {
        return "[D]";
    }

    @Override
    public String toString() {
        return getTypeIcon()
                + statusBox() + " "
                + name
                + " (by: " + by + ")";
    }
}