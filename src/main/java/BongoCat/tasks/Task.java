
package bongocat.tasks;

public abstract class Task {
    protected String name;
    protected boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public void markDone() {
        this.isDone = true;
    }

    public void markNotDone() {
        this.isDone = false;
    }

    public String statusBox() {
        return isDone ? "[X]" : "[ ]";
    }

    public abstract String getTypeIcon();

    public abstract String toSaveFormat();

    @Override
    public String toString() {
        return getTypeIcon() + statusBox() + " " + name;
    }
}
