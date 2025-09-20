package Chintu.Task;

/**
 * Represents a simple {@link Task} without deadlines or time ranges.
 * A {@code ToDo} stores only a description.
 */
public class ToDo extends Task {

    private final static String TASK_SYMBOL = "[T]";

    /**
     * Constructs a new {@code ToDo} task.
     * @param description The description of the task.
     * @param command     The raw command entered by the user.
     */
    public ToDo(String description, String command) {
        super(description, command);
    }

    /**
     * Returns the symbol representing a {@code ToDo} task.
     * @return "[T]".
     */
    @Override
    public String getTaskSymbol(){
        return TASK_SYMBOL;
    }
}
