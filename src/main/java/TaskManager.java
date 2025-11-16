import taskClasses.Task;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> list;
    protected final int MAX_TASKS = 100; // Set maximum number of items in list

    public TaskManager() {
        list = new ArrayList<>(MAX_TASKS);
    }
    public int getCurrentSize() {
        return list.size();
    }

    // check space left
    public int spaceLeftcheck() {
        return MAX_TASKS - list.size();
    }

    // add task feature
    public void addTask(Task task) {
        if (list.size() < MAX_TASKS) {
            list.add(task);
            System.out.println(
                    "____________________________________________________________\n" +
                            "OK. I've Added this task:\n" + task + "\n" +
                            "No. of Tasks in DA LIST: " + list.size() + "\n" +
                            "____________________________________________________________\n");
        } else {
            System.out.println("____________________________________________________________\n" +
                    "MY BELLY IS TOO FULL! Can't add more tasks...\n" +
                    "____________________________________________________________\n");
        }
    }

    public void deleteTask(int num) {
        int index = num- 1;
        Task task = list.get(index);
        list.remove(index);
        System.out.println("____________________________________________________________\n"
                        + "Oki. Removed " + task + ".\n"
                        + "No. of Tasks in DA LIST: " + list.size() + "\n"
                        + "____________________________________________________________");
    }

    // return list feature
    public boolean returnList() {
        if (!list.isEmpty()) {
            System.out.println("____________________________________________________________\n");
            System.out.println("DA LIST:");
            int index = 1;
            for (Task task : list) {
                System.out.println(index + "." + task);
                index++;
            }
            System.out.println("____________________________________________________________\n");
            return false;
        } else {return true;}
    }

    // mark task
    public void markTask(int i) {
        Task task = list.get(i - 1);
        task.markDone();
        System.out.println("____________________________________________________________");
        System.out.println("NOICE! I've marked this task as DONE:");
        System.out.println("  " + task);
        System.out.println("____________________________________________________________");
    }

    // unmark task
    public void unmarkTask(int i) {
        Task task = list.get(i - 1);
        task.markNotDone();
        System.out.println("____________________________________________________________");
        System.out.println("Okay! I've UNMARKED this task:");
        System.out.println("  " + task);
        System.out.println("____________________________________________________________");
    }
}
