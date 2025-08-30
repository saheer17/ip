import java.util.Scanner;

public class Chintu {
    public static void main(String[] args) {
        final String logo = "  ____  _   _ ___ _   _ _____ _   _ \n"
                + " / ___|| | | |_ _| \\ | |_   _| | | |\n"
                + "| |    | |_| || ||  \\| | | | | | | |\n"
                + "| |___ |  _  || || |\\  | | | | |_| |\n"
                + " \\____||_| |_|___|_| \\_| |_|  \\___/ \n";
        final String GREET_HELLO = "Hello! I'm Chintu!\n" + "What can I do for you?\n";
        final String GREET_BYE = "Bye! Take care and hope to see you again soon!";
        final String INSTRUCTIONS = "Refer to the following instructions to use me!\n"
                + "Enter command 'list' to list out all existing tasks\n"
                + "To add a todo task, enter a command in the following manner:\n"
                + "todo [TASK]\n"
                + "eg: todo homework\n"
                + "To add a deadline task, enter a command in the following manner:\n"
                + "deadline [TASK] /by [DEADLINE TIME]\n"
                + "eg: deadline homework /by 3pm\n"
                + "To add an event task, enter a command in the following manner:\n"
                + "event [TASK] /from [START TIME] /to [END TIME]\n"
                + "eg: event wedding /from august 12pm /to 3pm\n"
                + "To mark or unmark an event as done, enter 'mark' or 'unmark' followed by task number\n"
                + "eg: mark 3\n"
                + "Enter command 'bye' to exit Chintu\n";

        System.out.println("Hello from\n" + logo);
        System.out.println(GREET_HELLO);
        System.out.println(INSTRUCTIONS);

        Scanner sc =  new Scanner(System.in);
        TaskManager manager = new TaskManager(100);

        while(true) {
            String command = sc.nextLine();

            if (command.equals("bye")) {
                System.out.println(GREET_BYE);
                break;
            } else if (command.equals("list")) {
                manager.listTasks();
            } else if (command.startsWith("mark")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                manager.markTask(index);
            } else if (command.startsWith("unmark")){
                int index = Integer.parseInt(command.split(" ")[1]);
                manager.unmarkTask(index);
            }else {
                boolean successfullyAddedTask = manager.addTask(command);
                if (successfullyAddedTask){
                    manager.printRecentlyAddedTask();
                } else {
                    System.out.println("Command unclear, refer to instructions above");
                }
            }
        }
        sc.close();
    }
}
