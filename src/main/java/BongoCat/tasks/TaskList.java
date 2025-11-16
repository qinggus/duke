
package bongocat.tasks;

import bongocat.BongoException;
import java.util.ArrayList;

/**
 * A Task Manager to execute all commands
 */

public class TaskList {
    private static final int MAX = 100;
    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>(MAX);
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public int size() { return tasks.size(); }
    public boolean isEmpty() { return tasks.isEmpty(); }
    public int spaceLeft() { return MAX - tasks.size(); }
    public ArrayList<Task> getAllTasks() { return tasks; }

    public void addTask(Task t) throws BongoException {
        if (tasks.size() >= MAX) throw new BongoException("Belly full!");
        tasks.add(t);
    }

    public Task deleteTask(int num) throws BongoException {
        int idx = checkIndex(num);
        return tasks.remove(idx);
    }

    public Task markTask(int num) throws BongoException {
        int idx = checkIndex(num);
        tasks.get(idx).markDone();
        return tasks.get(idx);
    }

    public Task unmarkTask(int num) throws BongoException {
        int idx = checkIndex(num);
        tasks.get(idx).markNotDone();
        return tasks.get(idx);
    }

    private int checkIndex(int num) throws BongoException {
        int idx = num - 1;
        if (idx < 0 || idx >= tasks.size()) throw new BongoException("Invalid task number.");
        return idx;
    }
}
