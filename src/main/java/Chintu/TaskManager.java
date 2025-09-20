package Chintu;

import Chintu.Task.Deadline;
import Chintu.Task.Event;
import Chintu.Task.Task;
import Chintu.Task.ToDo;
import java.util.ArrayList;

/**
 * Manages all task-related operations.
 * Supports adding, deleting, marking, unmarking,
 * listing, and finding tasks. Internally stores tasks
 * in a list and provides methods to manipulate them.
 */
public class TaskManager {
    private ArrayList<Task> tasks;
    private int count;
    private boolean isTaskAdded;

    /**
     * Constructs an empty task manager.
     */
    public TaskManager() {
        tasks = new ArrayList<>();
        this.count = 0;
        this.isTaskAdded = false;
    }

    /**
     * Returns the number of tasks.
     * @return The total number of tasks.
     */
    public int getCount() {
        return count;
    }

    /**
     * Returns the list of tasks.
     * @return List of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a new {@link ToDo} task to the task list.
     * <p>
     * This method validates the input to ensure that the task description
     * is not empty before creating a {@link ToDo} object.
     *
     * @param words The array of command words where index 0 is the task type
     *              and index 1 contains the description.
     * @throws InsufficientInformationException If the description is missing or empty.
     */
    private void addToDo(String[] words) throws InsufficientInformationException {
        if (words.length < 2 || words[1].trim().isEmpty()) {
            throw new InsufficientInformationException("Todo");
        }
        tasks.add(new ToDo(words[1], String.join(" ", words)));
    }

    /**
     * Adds a new {@link Event} task to the task list.
     * This method validates the input to ensure that the description, start time,
     * and end time are provided in the correct format separated by slashes.
     * Example: <code>event meeting /Monday 2pm /Monday 4pm</code>
     *
     * @param words The array of command words where index 0 is the task type
     *              and index 1 contains the description and time details.
     * @throws InsufficientInformationException If the description, start time
     *                                          or end time is missing or empty.
     */
    private void addEvent(String[] words) throws InsufficientInformationException {
        if (words.length < 2 || words[1].trim().isEmpty()) {
            throw new InsufficientInformationException("Event");
        }
        String[] parts = words[1].split("/", 3);
        if (parts.length < 3) {
            throw new InsufficientInformationException("Event");
        }

        String description = parts[0].trim();
        String start = parts[1].trim();
        String end = parts[2].trim();

        if (description.isEmpty() || start.isEmpty() || end.isEmpty()) {
            throw new InsufficientInformationException("Event");
        }

        tasks.add(new Event(description, start, end, String.join(" ", words)));
    }

    /**
     * Adds a new {@link Deadline} task to the task list.
     * <p>
     * This method validates the input to ensure that both the description
     * and deadline are provided in the correct format separated by a slash.
     * Example: <code>deadline assignment /Sunday</code>
     *
     * @param words The array of command words where index 0 is the task type
     *              and index 1 contains the description and deadline.
     * @throws InsufficientInformationException If the description or deadline is missing or empty.
     */
    private void addDeadline(String[] words) throws InsufficientInformationException {
        if (words.length < 2 || words[1].trim().isEmpty()) {
            throw new InsufficientInformationException("Deadline");
        }
        String[] parts = words[1].split("/", 2);
        if (parts.length < 2) {
            throw new InsufficientInformationException("Deadline");
        }

        String description = parts[0].trim();
        String deadline = parts[1].trim();

        if (description.isEmpty() || deadline.isEmpty()) {
            throw new InsufficientInformationException("Deadline");
        }

        tasks.add(new Deadline(description, deadline, String.join(" ", words)));
    }

    /**
     * Adds a new task based on the provided command string.
     *
     * @param command Raw user command (e.g., "todo homework").
     * @throws InsufficientInformationException If required details are missing.
     * @throws UnknownCommandException          If task type is not recognised.
     */
    public void addTask(String command) throws InsufficientInformationException, UnknownCommandException {
        String[] words = command.split(" ", 2);
        String taskType = words[0];

        switch (taskType) {
        case "todo":
            addToDo(words);
            break;
        case "event":
            addEvent(words);
            break;
        case "deadline":
            addDeadline(words);
            break;
        default:
            isTaskAdded = false;
            throw new UnknownCommandException();
        }

        count++;
        isTaskAdded = true;
    }

    /**
     * Deletes the task at the given position.
     *
     * @param taskNumber The index of the task to delete (1-based).
     * @throws InvalidDeleteCommandException If the index is invalid.
     */
    public void deleteTask(int taskNumber) throws InvalidDeleteCommandException {
        if (taskNumber <= 0 || taskNumber > count) {
            throw new InvalidDeleteCommandException();
        }
        Task removedTask = tasks.remove(taskNumber - 1);
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removedTask.getTaskSymbol() + removedTask.getStatusIcon()
                + " " + removedTask.getTask());
        count--;
        System.out.println("You now have " + count + " tasks left. Good job on completing it!");
    }

    /**
     * Prints the most recently added task.
     */
    public void printRecentlyAddedTask(){
        System.out.println("Got it. I've added this task:");
        Task recentTask = tasks.get(tasks.size() - 1);
        System.out.println("  " + recentTask.getTaskSymbol() + recentTask.getStatusIcon()
                + " " + recentTask.getTask());
        System.out.println("Now, you have " + getCount() + " tasks in your list");
    }

    /**
     * Prints all tasks or a message if none exist.
     */
    public void listTasks() {
        if (count == 0) {
            System.out.println("There are no tasks in your list");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < count; i++) {
                Task t = tasks.get(i);
                System.out.println((i + 1) + "." + t.getTaskSymbol() + t.getStatusIcon()
                        + " " + t.getTask());
            }
        }
    }

    /**
     * Marks a task as done.
     *
     * @param index Index of the task to mark (1-based).
     * @throws InvalidTaskNumberException If the index is invalid.
     */
    public void markTask(int index) throws InvalidTaskNumberException {
        if (index < 0 || index > count) {
            throw new InvalidTaskNumberException();
        }
        Task task = tasks.get(index - 1);
        task.markDone();
        System.out.println("Nice! I have marked this task as done:");
        System.out.println(task.getTaskSymbol() + task.getStatusIcon() + " " + task.getTask());
    }

    /**
     * Marks a task as not done.
     *
     * @param index Index of the task to unmark (1-based).
     * @throws InvalidTaskNumberException If the index is invalid.
     */
    public void unmarkTask(int index) throws InvalidTaskNumberException {
        if (index < 0 || index > count) {
            throw new InvalidTaskNumberException();
        }
        Task task = tasks.get(index - 1);
        task.markUndone();
        System.out.println("Ok, I have marked this task as not done yet:");
        System.out.println(task.getTaskSymbol() + task.getStatusIcon() + " " + task.getTask());
    }

    /**
     * Finds and prints tasks containing the keyword.
     *
     * @param keyword Keyword to search for (case-insensitive).
     */
    public void findTasks(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            System.out.println("Please provide a keyword to search");
            return;
        }

        ArrayList<Task> matchedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTask().toLowerCase().contains(keyword.toLowerCase())) {
                matchedTasks.add(task);
            }
        }

        if (matchedTasks.isEmpty()) {
            System.out.println("No tasks found containing " + keyword);
        } else {
            System.out.println("Here are the matching tasks:");
            for (int i = 0; i < matchedTasks.size(); i++) {
                Task t = matchedTasks.get(i);
                System.out.println((i + 1) + "." + t.getTaskSymbol() + t.getStatusIcon()
                        + " " + t.getTask());
            }
        }
    }
}
