package taskClasses;

public abstract class Task {
    protected String name;
    protected boolean isDone;


    public Task(String name) {
        this.name = name;
        this.isDone = false;
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
}
