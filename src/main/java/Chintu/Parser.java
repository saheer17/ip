package Chintu;

public class Parser {

    private TaskManager manager;
    private Storage storage;
    private UI ui;

    public Parser(TaskManager manager, Storage storage, UI ui) {
        this.manager = manager;
        this.storage = storage;
        this.ui = ui;
    }

    public boolean handleCommand(String command) {
        if (command == null || command.isEmpty()) {
            ui.printMessage("Empty command!");
            return true;
        }

        String[] parts = command.trim().split(" ", 2);
        String action = parts[0];
        String argument = (parts.length > 1) ? parts[1] : "";

        try {
            switch (action) {
            case "bye":
                ui.printBye();
                storage.saveData(manager.getTasks());
                return false; // stop loop

            case "list":
                manager.listTasks();
                break;

            case "mark":
                int markIndex = Integer.parseInt(argument);
                manager.markTask(markIndex);
                storage.saveData(manager.getTasks());
                break;

            case "unmark":
                int unmarkIndex = Integer.parseInt(argument);
                manager.unmarkTask(unmarkIndex);
                storage.saveData(manager.getTasks());
                break;

            case "delete":
                int deleteIndex = Integer.parseInt(argument);
                manager.deleteTask(deleteIndex);
                storage.saveData(manager.getTasks());
                break;

            default:
                // Everything else is treated as adding a task
                manager.addTask(command);
                manager.printRecentlyAddedTask();
                storage.saveData(manager.getTasks());
                break;
            }
        } catch (NumberFormatException e) {
            ui.printMessage("Invalid number format in command.");
        } catch (InvalidTaskNumberException | InvalidDeleteCommandException |
                 UnknownCommandException | InsufficientInformationException e) {
            ui.printMessage(e.getMessage());
        }

        return true;
    }
}
