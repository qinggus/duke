import java.util.Scanner;

import taskClasses.ToDo;
import taskClasses.Deadline;
import taskClasses.Event;


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
            String input = scan.nextLine().trim(); //scans input

            if (input.equals("bye")){
                System.out.println("----------------------------------------------");
                System.out.println("GOODBYE."); //Goodbye
                System.out.println("----------------------------------------------");
                break;
            }
            try {
                handleCommand(input,manager);
            } catch (BongoException e) {
                printError(e.getMessage());
            }
//            else {manager.addTask(new Todo (name));} //calls add task feature

            //echo feature
//            System.out.println(input);
        }

        scan.close(); //close scanner
    }
    private static void handleCommand(String input, TaskManager manager) throws BongoException {
        if (input.equals("list")) {
            if (manager.returnList()){
                throw new BongoException("Nothing in belly... No tasks added.");
            }
            manager.returnList();
            return;
        }
        else if (input.startsWith("mark ")) {
            try {
                int i = Integer.parseInt(input.substring(5));
                manager.markTask(i);
            } catch (NumberFormatException e) {
                throw new BongoException("Bruh, no such task exists... Try again with a valid number.");
        }
        return;
        }
        else if (input.startsWith("unmark ")) {
            try {
                int i = Integer.parseInt(input.substring(7));
                manager.unmarkTask(i);}
            catch (NumberFormatException e) {
                throw new BongoException("Bruh, no such task exists... Try again with a valid number.");
            } return;
        }
        else if (input.equals("space left")) {
            System.out.println(
                    "____________________________________________________________\n" +
                            "Space left: " + manager.spaceLeftcheck() + " slots\n" +
                            "____________________________________________________________\n"
            );
            return;
        } else if (input.startsWith("todo ")) {
            String name = input.substring(5);
            if (name.isEmpty()) {
                throw new BongoException("OII!!! You can't leave the description empty.");
            }
            manager.addTask(new ToDo(name));
            return;
        } else if (input.startsWith("deadline")) {
            String[] parts = input.split(" /by ",2);
            if (parts.length < 2 || parts[1].isEmpty()) {
                throw new BongoException("Hello... you dont have deadline meh?\nThe description of a deadline must include /by <time>.");
            }
            String name = parts[0].substring(8);
            if (name.isEmpty()) {
                throw new BongoException("DON'T LEAVE THE DESCRIPTION EMPTY, HOW AM I SUPPOSED TO DO MY JOB?!.");
            }
            String by = parts[1];
            manager.addTask(new Deadline(name, by));
            return;
        } else if (input.startsWith("event")) {
            String[] parts = input.split(" /from | /to ",3);
            if (parts.length < 3) {
                throw new BongoException("WRONG FORMAT! Event format: event <name> /from <start> /to <end>.");
            }
            String name = parts[0].substring(5).trim();
            String from = parts[1].trim();
            String to = parts[2].trim();

            if (name.isEmpty() || from.isEmpty() || to.isEmpty()) {
                throw new BongoException("HARLOW TYPE PROPERLY! Event name, /from, and /to cannot be empty.");
            }

            manager.addTask(new Event(name, from, to));
            return;
        }
        throw new BongoException("Bro what?\n"
                + "To-Do format: todo <name>\n"
                + "Event format: event <name> /from <start> /to <end>\n"
                + "Deadline format: deadline <name> /by <when>");
    }
    private static void printError(String message) {
        System.out.println("____________________________________________________________");
        System.out.println(message);
        System.out.println("____________________________________________________________");
    }
}
