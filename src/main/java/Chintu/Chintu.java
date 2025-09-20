package Chintu;

/**
 * Entry point of the Chintu application.
 * This class sets up the necessary components such as
 * {@link UI}, {@link TaskManager}, {@link Storage}, and {@link Parser}.
 * It runs the main loop to continuously accept user commands until exit.
 */
public class Chintu {
    /**
     * Starts the Chintu program.
     * Initialises storage, parser, UI, and task manager and then begins
     * the interactive loop for user commands.
     * <p>
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {

        final String DATA_FILE = "Task_Data.txt";

        UI ui = new UI();
        TaskManager manager = new TaskManager();
        Storage storage = new Storage(DATA_FILE);
        Parser parser = new Parser(manager, storage, ui);

        ui.printLogo();
        ui.printGreeting();
        ui.printInstructions();

        storage.loadData(manager);

        boolean isProgramRunning = true;
        while (isProgramRunning) {
            String command = ui.getUserInput();
            isProgramRunning = parser.handleCommand(command);
        }

        ui.closeScanner();
    }
}
