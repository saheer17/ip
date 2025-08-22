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

    public void addMessage(String content) {
        tasks[count] = new Task(content);
        count++;
    }

    public void listMessages() {
        if (count == 0) {
            System.out.println("There are no messages in the system");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println((i+1) + "." + tasks[i].getStatusIcon() + " " + tasks[i].getTask());
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
