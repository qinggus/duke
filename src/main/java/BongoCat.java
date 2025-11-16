import java.util.Scanner;
import taskExtentions.Task;
import taskExtentions.ToDo;
import taskExtentions.Deadline;
import taskExtentions.Event;


public class BongoCat {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); //to scan input text
        TaskManager manager = new TaskManager(); // Refers to taskmanager class

        String logo = """
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣶⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣄⣀⡀⣠⣾⡇⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀
⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⡇⠀⠀⠀⠀
⠀⣶⣿⣦⣜⣿⣿⣿⡟⠻⣿⣿⣿⣿⣿⣿⣿⡿⢿⡏⣴⣺⣦⣙⣿⣷⣄⠀⠀⠀
⠀⣯⡇⣻⣿⣿⣿⣿⣷⣾⣿⣬⣥⣭⣽⣿⣿⣧⣼⡇⣯⣇⣹⣿⣿⣿⣿⣧⠀⠀
⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠸⣿⣿⣿⣿⣿⣿⣿⣷⠀
""";
        System.out.println("----------------------------------------------");
        System.out.println("This is da BONGO CAT.\nHow may I annoy you today?\n" + logo); //Greeting
        System.out.println("----------------------------------------------");

        while(true){ //keeps the program running
            String input = scan.nextLine(); //scans input

            if (input.equals("bye")){
                System.out.println("----------------------------------------------");
                System.out.println("GOODBYE."); //Goodbye
                System.out.println("----------------------------------------------");
                break;
            }
            else if (input.equals("list")) {manager.returnList();} //calls list feature
            else if (input.startsWith("mark ")) {
                int i = Integer.parseInt(input.substring(5));
                manager.markTask(i);
            }
            else if (input.startsWith("unmark ")) {
                int i = Integer.parseInt(input.substring(7));
                manager.unmarkTask(i);
            }
            else if (input.equals("space left")) {
                System.out.println(
                        "____________________________________________________________\n" +
                                "Space left: " + manager.spaceLeftcheck() + " slots\n" +
                                "____________________________________________________________\n"
                );
            }
            else if (input.startsWith("todo ")) {
                String name = input.substring(5);
                manager.addTask(new ToDo(name));
            }
            else if (input.startsWith("deadline")) {
                String[] parts = input.split(" /by ");
                String name =  parts[0].substring(9);
                String by = parts.length > 1 ? parts[1] : ""; // if by exist, then by = part[1] else blank
                manager.addTask(new Deadline(name, by));
            }
            else if (input.startsWith("event")) {
                String[] parts = input.split(" /from | /to ");
                String name = parts[0].substring(6);
                String from = parts.length > 1 ? parts[1] : "";
                String to = parts.length > 2 ? parts[2] : "";
                manager.addTask(new Event(name, from, to));
            }
//            else {manager.addTask(new Todo (name));} //calls add task feature

            //echo feature
//            System.out.println(input);
        }

        scan.close(); //close scanner
    }
}
