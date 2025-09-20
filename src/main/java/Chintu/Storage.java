package Chintu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import Chintu.Task.Task;

/**
 * Handles persistent storage of tasks.
 * Provides functionality to save tasks to a file and
 * load tasks from a file into the {@link TaskManager}.
 */
public class Storage {
    private final String filePath;

    /**
     * Constructs a storage handler with the given file path.
     * @param filePath Path of the file used for storage.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves all tasks to the storage file.
     * @param tasks The list of tasks to save.
     */
    public void saveData(ArrayList<Task> tasks) {
        try (FileWriter dataFile = new FileWriter(filePath, false)) {
            for (Task task : tasks) {
                String doneIndicator;
                if (task.isDone()) {
                    doneIndicator = "X";
                } else {
                    doneIndicator = "O";
                }
                dataFile.write(doneIndicator + task.getCommand() + System.lineSeparator());
            }
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }


    /**
     * Loads tasks from the storage file into the manager.
     * If the file does not exist, no tasks are loaded.
     * @param manager The task manager where tasks are loaded.
     */
    public void loadData(TaskManager manager) {
        File dataFile = new File(filePath);
        if (!dataFile.exists()) {
            System.out.println("No saved tasks found.");
            return;
        }

        try (Scanner sc = new Scanner(dataFile)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                char markIndicator = line.charAt(0);
                String commandToAdd = line.substring(1);
                try {
                    manager.addTask(commandToAdd);
                    if (markIndicator == 'X') {
                        int lastIndex = manager.getCount() - 1;
                        manager.getTasks().get(lastIndex).markDone();
                    }
                } catch (Exception e) {
                    System.out.println("Skipping invalid task: " + line);
                }
            }
            System.out.println("Tasks loaded successfully");
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}
