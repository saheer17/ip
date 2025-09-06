package Chintu;

import Chintu.Task.Deadline;
import Chintu.Task.Event;
import Chintu.Task.Task;
import Chintu.Task.ToDo;

public class TaskManager {
    private Task[] tasks;
    private int count;
    private boolean isTaskAdded;

    public TaskManager(int capacity) {
        tasks = new Task[capacity];
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
            tasks[count] = new ToDo(toDoDescription);
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
            tasks[count] = new Event(eventDescription, eventStartTime, eventEndTime);
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
            tasks[count] = new Deadline(deadlineDescription, deadlineTime);
            break;

        default:
            isTaskAdded = false;
            throw new UnknownCommandException();
        }
        count++;
        isTaskAdded = true;
    }

    public void printRecentlyAddedTask(){
        System.out.println("Got it. I've added this task:");
        int recentTaskIndex = count - 1;
        System.out.println("  " + tasks[recentTaskIndex].getTaskSymbol() + tasks[recentTaskIndex].getStatusIcon()
                + " " + tasks[recentTaskIndex].getTask());
        System.out.println("Now, you have " + getCount() + " tasks in your list");
    }

    public void listTasks() {
        if (count == 0) {
            System.out.println("There are no tasks in your list");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < count; i++) {
                System.out.println((i+1) + "." +tasks[i].getTaskSymbol() + tasks[i].getStatusIcon()
                        + " " + tasks[i].getTask());
            }
        }
    }

    public void markTask(int index) throws InvalidTaskNumberException {
        if (index < 0 || index > count) {
            throw new InvalidTaskNumberException();
        }
        tasks[index - 1].markDone();
        System.out.println("Nice! I have marked this task as done:");
        System.out.println("  " + tasks[index - 1].getStatusIcon() + " " + tasks[index - 1].getTask());
    }

    public void unmarkTask(int index) throws InvalidTaskNumberException {
        if (index < 0 || index > count) {
            throw new InvalidTaskNumberException();
        }
        tasks[index-1].markUndone();
        System.out.println("Ok, I have marked this task as not done yet:");
        System.out.println("  " + tasks[index-1].getStatusIcon() + " " + tasks[index-1].getTask());
    }
}
