package Chintu;

import java.util.Scanner;

public class UI {
    private Scanner sc;

    public UI() {
        sc = new Scanner(System.in);
    }

    public void printLogo() {
        final String logo = "  ____  _   _ ___ _   _ _____ _   _ \n"
                + " / ___|| | | |_ _| \\ | |_   _| | | |\n"
                + "| |    | |_| || ||  \\| | | | | | | |\n"
                + "| |___ |  _  || || |\\  | | | | |_| |\n"
                + " \\____||_| |_|___|_| \\_| |_| \\___/ \n";
        System.out.println("Hello from\n" + logo);
    }

    public void printGreeting() {
        final String GREET_HELLO = "Hello! I'm Chintu!\n" + "What can I do for you?\n";
        System.out.println(GREET_HELLO);
    }

    public void printInstructions() {
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
                + "Enter command 'bye' to exit Chintu\n"
                + "To delete command, enter 'delete' followed by task number\n"
                + "eg: delete 3\n"
                + " To find tasks by searching for a keyword, enter 'find' followed by the keyword\n"
                + "eg: find homework\n";
        System.out.println(INSTRUCTIONS);
    }

    public void printBye() {
        final String GREET_BYE = "Bye! Take care and hope to see you soon!";
        System.out.println(GREET_BYE);
    }

    public String getUserInput() {
        return sc.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void closeScanner() {
        sc.close();
    }
}
