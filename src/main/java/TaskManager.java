public class TaskManager {
    private Task[] tasks;
    private int count;

    public TaskManager(int capacity) {
        tasks = new Task[capacity];
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public boolean addTask(String content) {
        String taskType = content.split(" ")[0];
        switch (taskType) {
        case "todo":
            String[] toDoWords = content.split(" ",2); //Split first word (task type) from rest of content
            String toDoDescription = toDoWords[1]; // Rest of content is to do task description
            tasks[count] = new ToDo(toDoDescription);
            break;

        case "event":
            String[] eventWords = content.split(" ",2); //Split first word (task type) from rest of content
            String[] eventParts =  eventWords[1].split("/",3); // Split rest of content by '/'
            String eventDescription = eventParts[0].trim(); // First part is task description
            String eventStartTime = eventParts[1].trim(); // Second part is start time of event
            String eventEndTime = eventParts[2].trim(); // Third part is end time of event
            tasks[count] = new Event(eventDescription, eventStartTime, eventEndTime);
            break;

        case "deadline":
            String[] deadlineWords = content.split(" ",2); // Split first word(task type) from rest of content
            String[] deadlineParts = deadlineWords[1].split("/", 2); // Split rest of content to before '/' and after
            String deadlineDescription = deadlineParts[0].trim(); // First part is task description
            String deadlineTime = deadlineParts[1].trim(); // Second part is task deadline
            tasks[count] = new Deadline(deadlineDescription, deadlineTime);
            break;
        default:
            return false;
        }
        count++;
        return true;
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

    public void markTask(int index) {
        tasks[index-1].markDone();
        System.out.println("Nice! I have marked this task as done:");
        System.out.println("  " + tasks[index-1].getStatusIcon() + " " + tasks[index-1].getTask());
    }

    public void unmarkTask(int index) {
        tasks[index-1].markUndone();
        System.out.println("Ok, I have marked this task as not done yet:");
        System.out.println("  " + tasks[index-1].getStatusIcon() + " " + tasks[index-1].getTask());
    }
}
