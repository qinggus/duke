public class TaskManager {
    private String[] tasks;
    private int count;

    public TaskManager() {
        tasks = new String[100];
        count = 0;
    }

    //check space left
    public int spaceLeftcheck() {
        return tasks.length - count;
    }

    // add task feature
    public void addTask(String task) {
        if(count < task.length()){
            tasks[count] = task;
            count++;
            System.out.println(
                    "____________________________________________________________\n" +
                            "Added: " + task + "\n"
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
            for (int i = 0; i < count; i++){
                System.out.println((i+1) + "." + tasks[i]);
            }
            System.out.println("\n");
        }
        else {
            System.out.println("Nothing in belly... No tasks added.\n");
        }
    }
}
