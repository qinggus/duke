package bongocat.tasks;

import java.util.ArrayList;

/**
 * Represents the list of tasks.
 */
public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> loaded) {
        this.tasks = (loaded == null) ? new ArrayList<>() : loaded;
    }

    /** Returns all tasks */
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    /** Returns all tasks */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /** Adds a task */
    public void addTask(Task t) {
        tasks.add(t);
    }

    /** Returns number of tasks */
    public int size() {
        return tasks.size();
    }

    /** Checks if empty */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /** Deletes task using 1-based index */
    public Task deleteTask(int index) {
        return tasks.remove(index - 1);
    }

    /** Mark done */
    public Task markTask(int index) {
        Task t = tasks.get(index - 1);
        t.markDone();
        return t;
    }

    /** Mark not done */
    public Task unmarkTask(int index) {
        Task t = tasks.get(index - 1);
        t.markNotDone();
        return t;
    }

    /**
     * Duplicate check by TASK NAME (case-insensitive).
     * This is the correct way for Duke-level projects.
     */
    public boolean isDuplicate(Task newTask) {
        for (Task t : tasks) {
            if (t.getName().equalsIgnoreCase(newTask.getName())) {
                return true;
            }
        }
        return false;
    }

    /** If using max 100 tasks */
    public int spaceLeft() {
        return 100 - tasks.size();
    }

    /**
     * Returns tasks whose name contains the keyword (case-insensitive).
     */
    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> matches = new ArrayList<>();

        for (Task t : tasks) {
            if (t.getName().toLowerCase().contains(keyword)) {
                matches.add(t);
            }
        }

        return matches;
    }

}
