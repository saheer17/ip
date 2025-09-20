package Chintu.Task;

/**
 * Represents a {@link Task} that occurs within a time range.
 * An {@code Event} stores a description, start time, and end time.
 */
public class Event extends Task {

    private String startTime;
    private String endTime;
    private final static String TASK_SYMBOL = "[E]";

    /**
     * Constructs a new {@code Event} task.
     * @param content   The description of the event.
     * @param startTime The start time string, prefixed with "from".
     * @param endTime   The end time string, prefixed with "to".
     * @param command   The raw command entered by the user.
     */
    public Event(String content, String startTime, String endTime, String command) {
        super(content, command);
        String[] startTimeWords = startTime.split(" ",2);
        this.startTime = startTimeWords[1]; // Ignore 'from' and store only the start time
        String[] endTimeWords = endTime.split(" ",2);
        this.endTime = endTimeWords[1]; // Ignore 'to' and store only the end time
    }

    /**
     * Returns the symbol representing an {@code Event} task.
     * @return "[E]".
     */
    @Override
    public String getTaskSymbol() {
        return TASK_SYMBOL;
    }

    /**
     * Returns the formatted string representation of the event task,
     * including start and end times.
     * @return Formatted event task string.
     */
    @Override
    public String getTask() {
        return (super.content + " (from: " +  this.startTime + " to: " +  this.endTime + ")");
    }
}
