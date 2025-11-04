import java.util.Scanner;

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
            else if (input.equals("space left")) {
                System.out.println(
                        "____________________________________________________________\n" +
                                "Space left: " + manager.spaceLeftcheck() + " slots\n" +
                                "____________________________________________________________\n"
                );
            }
            else {manager.addTask(input);} //calls add task feature

            //echo feature
//            System.out.println(input);
        }

        scan.close(); //close scanner
    }
}
