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
                System.out.println((i+1) + ". " + tasks[i].getContent());
            }
        }
    }
}
