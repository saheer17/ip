package Chintu.Task;

/**
 * Represents a {@link Task} with a deadline.
 * A {@code Deadline} stores a description and a due date/time.
 */
public class Deadline extends Task {

    private String deadline;
    private final static String TASK_SYMBOL = "[D]";

    /**
     * Constructs a new {@code Deadline} task.
     * @param content  The description of the task.
     * @param deadline The deadline string, prefixed with "by".
     * @param command  The raw command entered by the user.
     */
    public Deadline(String content, String deadline, String command) {
        super(content,command);
        String[] deadlineWords = deadline.split(" ",2);
        this.deadline = deadlineWords[1]; // Ignore 'by' and store only deadline
    }

    /**
     * Returns the symbol representing a {@code Deadline} task.
     *
     * @return "[D]".
     */
    @Override
    public String getTaskSymbol() {
        return TASK_SYMBOL;
    }

    /**
     * Returns the formatted string representation of the deadline task,
     * including the deadline date/time.
     * @return Formatted deadline task string.
     */
    @Override
    public String getTask() {
        return (super.content + " (by: " +  deadline + ")");
    }
}
