package Chintu;

import Chintu.Task.Deadline;
import Chintu.Task.Event;
import Chintu.Task.Task;
import Chintu.Task.ToDo;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;
    private int count;
    private boolean isTaskAdded;

    public TaskManager() {
        tasks = new ArrayList<>();
        this.count = 0;
        this.isTaskAdded = false;
    }

    public int getCount() {
        return count;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    private void addToDo(String[] words) throws InsufficientInformationException {
        if (words.length < 2 || words[1].trim().isEmpty()) {
            throw new InsufficientInformationException("Todo");
        }
        tasks.add(new ToDo(words[1], String.join(" ", words)));
    }

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

    public void printRecentlyAddedTask(){
        System.out.println("Got it. I've added this task:");
        Task recentTask = tasks.get(tasks.size() - 1);
        System.out.println("  " + recentTask.getTaskSymbol() + recentTask.getStatusIcon()
                + " " + recentTask.getTask());
        System.out.println("Now, you have " + getCount() + " tasks in your list");
    }

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

    public void markTask(int index) throws InvalidTaskNumberException {
        if (index < 0 || index > count) {
            throw new InvalidTaskNumberException();
        }
        Task task = tasks.get(index - 1);
        task.markDone();
        System.out.println("Nice! I have marked this task as done:");
        System.out.println(task.getTaskSymbol() + task.getStatusIcon() + " " + task.getTask());
    }

    public void unmarkTask(int index) throws InvalidTaskNumberException {
        if (index < 0 || index > count) {
            throw new InvalidTaskNumberException();
        }
        Task task = tasks.get(index - 1);
        task.markUndone();
        System.out.println("Ok, I have marked this task as not done yet:");
        System.out.println(task.getTaskSymbol() + task.getStatusIcon() + " " + task.getTask());
    }

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
