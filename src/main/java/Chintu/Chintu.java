package Chintu;

public class Chintu {
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
