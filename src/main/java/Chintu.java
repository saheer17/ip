import java.util.Scanner;

public class Chintu {
    public static void main(String[] args) {
        String logo = "  ____  _   _ ___ _   _ _____ _   _ \n"
                + " / ___|| | | |_ _| \\ | |_   _| | | |\n"
                + "| |    | |_| || ||  \\| | | | | | | |\n"
                + "| |___ |  _  || || |\\  | | | | |_| |\n"
                + " \\____||_| |_|___|_| \\_| |_|  \\___/ \n";
        String GREET_HELLO = "Hello! I'm Chintu!\n" + "What can I do for you?\n";
        String GREET_BYE = "Bye! Take care and hope to see you again soon!";

        System.out.println("Hello from\n" + logo);
        System.out.println(GREET_HELLO);

        Scanner sc =  new Scanner(System.in);
        TaskManager manager = new TaskManager(100);

        while(true) {
            String command = sc.nextLine();

            if (command.equals("bye")) {
                System.out.println(GREET_BYE);
                break;
            } else if (command.equals("list")) {
                manager.listMessages();
            } else if (command.startsWith("mark")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                manager.markTask(index);
            } else if ( command.startsWith("unmark")){
                int index = Integer.parseInt(command.split(" ")[1]);
                manager.unmarkTask(index);
            }else {
                System.out.println("added: " + command);
                manager.addMessage(command);
            }
        }
        sc.close();
    }
}
