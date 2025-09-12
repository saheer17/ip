package Chintu;

import Chintu.Task.Deadline;
import Chintu.Task.Event;
import Chintu.Task.Task;
import Chintu.Task.ToDo;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;;
    private int count;
    private boolean isTaskAdded;

    public TaskManager(int capacity) {
        tasks = new ArrayList<>();
        this.count = 0;
        this.isTaskAdded = false;
    }

    public int getCount() {
        return count;
    }

    public boolean getIsTaskAdded() {
        return isTaskAdded;
    }

    public void addTask(String content) throws InsufficientInformationException, UnknownCommandException {
        String[] words = content.split(" ", 2); //Split first word (task type) from rest of content
        String taskType = words[0]; // First word indicates task type

        switch (taskType) {
        case "todo":
            if (words.length < 2 || words[1].trim().isEmpty()) {
                throw new InsufficientInformationException("Todo");
            }
            String toDoDescription = words[1]; // Rest of content is to do task description
            tasks.add(new ToDo(toDoDescription));
            break;

        case "event":
            if (words.length < 2 || words[1].trim().isEmpty()) {
                throw new InsufficientInformationException("Event");
            }
            String[] eventParts =  words[1].split("/",3); // Split rest of content by '/'
            if (eventParts.length < 3) {
                throw new InsufficientInformationException("Event");
            }
            String eventDescription = eventParts[0].trim(); // First part is task description
            String eventStartTime = eventParts[1].trim(); // Second part is start time of event
            String eventEndTime = eventParts[2].trim(); // Third part is end time of event
            if (eventDescription.isEmpty() || eventStartTime.isEmpty() || eventEndTime.isEmpty()) {
                throw new InsufficientInformationException("Event");
            }
            tasks.add(new Event(eventDescription, eventStartTime, eventEndTime));
            break;

        case "deadline":
            if (words.length < 2 || words[1].trim().isEmpty()) {
                throw new InsufficientInformationException("Deadline");
            }
            String[] deadlineParts = words[1].split("/", 2); // Split rest of content to before '/' and after
            if (deadlineParts.length < 2) {
                throw new InsufficientInformationException("Deadline");
            }
            String deadlineDescription = deadlineParts[0].trim(); // First part is task description
            String deadlineTime = deadlineParts[1].trim(); // Second part is task deadline
            if (deadlineDescription.isEmpty() || deadlineTime.isEmpty()) {
                throw new InsufficientInformationException("Deadline");
            }
            tasks.add(new Deadline(deadlineDescription, deadlineTime));
            break;

        default:
            isTaskAdded = false;
            throw new UnknownCommandException();
        }
        count++;
        isTaskAdded = true;
    }

    public void deleteTask(int taskNumber) throws InvalidDeleteCommandException {
        if (taskNumber < 0 || taskNumber > count) {
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
}
