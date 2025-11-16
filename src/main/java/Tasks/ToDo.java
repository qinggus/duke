package taskClasses;

public class ToDo extends Task {

    public ToDo(String name){
        super(name,TaskType.TODO);
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

