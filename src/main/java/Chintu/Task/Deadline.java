package Chintu.Task;

public class Deadline extends Task {

    private String deadline;
    private final static String TASK_SYMBOL = "[D]";

    public Deadline(String content, String deadline, String command) {
        super(content,command);
        String[] deadlineWords = deadline.split(" ",2);
        this.deadline = deadlineWords[1]; // Ignore 'by' and store only deadline
    }

    @Override
    public String getTaskSymbol() {
        return TASK_SYMBOL;
    }

    @Override
    public String getTask() {
        return (super.content + " (by: " +  deadline + ")");
    }
}
