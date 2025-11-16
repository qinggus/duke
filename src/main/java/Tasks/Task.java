package taskClasses;

public abstract class Task {
    protected String name;
    protected boolean isDone;
    protected TaskType type;

    public Task(String name, TaskType type) {
        this.name = name;
        this.isDone = false;
        this.type = type;
    }
    public String getName() {
        return name;
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

    public abstract String getTypeIcon(); // T, D, or E

    @Override // overrides' Java's Object class
    public String toString() { //toString is a actually java thing
        return getTypeIcon()
                + statusBox() + " "
                + name;
    }

    public String toSaveFormat() {
        return "";
    }
}
