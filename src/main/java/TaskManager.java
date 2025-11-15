import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> list;
    private final int MAX_TASKS = 100; //Set maximum no. of items in list
    private int count;

    public TaskManager() {
        list = new ArrayList<>(MAX_TASKS);
        count = 0;
    }

    //check space left
    public int spaceLeftcheck() {
        return MAX_TASKS - count;
    }

    // add task feature
    public void addTask(String name) {
        if(count < MAX_TASKS) {
            list.add(new Task(name));
            count++;
            System.out.println(
                    "____________________________________________________________\n" +
                            "Added: " + name + "\n"
                            + "Space left: " + spaceLeftcheck() + "\n" +
                    "____________________________________________________________\n");
        }
        else
        {
            System.out.println(
                    "____________________________________________________________\n"
                    + "MY BELLY IS TOO FULL! Can't add more tasks...\n"
                    + "____________________________________________________________\n");
        }
    }

    //return list feature
    public void returnList(){
        if (count > 0) {
            System.out.println("DA LIST:");
            for (int i = 0; i < count; i++){
                System.out.println((i+1) + "." + list.get(i));
            }
            System.out.println("\n");
        }
        else {
            System.out.println("Nothing in belly... No tasks added.\n");
        }
    }

    //mark tasks
    public void markTask(int i){
        if(i>=1 && i <= MAX_TASKS) {
            Task task = list.get(i - 1);
            task.markDone();
            System.out.println("____________________________________________________________");
            System.out.println("Good Job! I've marked this task as DONE:");
            System.out.println("  " + task);
            System.out.println("____________________________________________________________");
        }
        else {System.out.println("Bruh, no such task exists...");}
    }

    //Unmark tasks
    public void unmarkTask(int i){
        if(i>=1 && i <= MAX_TASKS) {
            Task task = list.get(i - 1);
            task.markNotDone();
            System.out.println("____________________________________________________________");
            System.out.println("Okay! I've UNMARKED this task:");
            System.out.println("  " + task);
            System.out.println("____________________________________________________________");
        }
        else {System.out.println("Bruh, no such task exists...");}
    }
}
