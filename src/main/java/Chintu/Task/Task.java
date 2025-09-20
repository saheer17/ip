package Chintu.Task;

/**
 * Represents an abstract task in the task management system.
 * A {@code Task} contains a description, command input, and a completion status.
 * It provides common functionality for marking tasks as done or undone, and
 * retrieving their display symbols.
 */
public abstract class Task {

    protected String content;
    protected String command;
    protected boolean isDone;
    private final String TASK_SYMBOL = "[ ]";

    /**
     * Constructs a new {@code Task}.
     *
     * @param content The description of the task.
     * @param command The raw command entered by the user.
     */
    public Task(String content, String command) {
        this.content = content;
        this.command = command;
        this.isDone = false;
    }

    /**
     * Returns the description of the task.
     *
     * @return Task description.
     */
    public String getTask() {
        return content;
    }

    /**
     * Checks if the task is completed.
     *
     * @return {@code true} if the task is marked as done, {@code false} otherwise.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Marks the task as done.
     */
    public void markDone() {
        isDone = true;
    }

    /**
     * Marks the task as not done.
     */
    public void markUndone() {
        isDone = false;
    }

    /**
     * Returns the status icon of the task.
     * {@code [X]} if completed, {@code [ ]} otherwise.
     *
     * @return Task status icon.
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    /**
     * Returns the symbol representing the task type.
     *
     * @return Task symbol.
     */
    public String getTaskSymbol(){
        return TASK_SYMBOL;
    }

    /**
     * Returns the raw command used to create the task.
     *
     * @return Task command string.
     */
    public String getCommand() {
        return command;
    }
}
