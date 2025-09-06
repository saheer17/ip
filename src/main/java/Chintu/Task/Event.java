package Chintu.Task;

public class Event extends Task {

    private String startTime;
    private String endTime;
    private final static String TASK_SYMBOL = "[E]";

    public Event(String content, String startTime, String endTime) {
        super(content);
        String[] startTimeWords = startTime.split(" ",2);
        this.startTime = startTimeWords[1]; // Ignore 'from' and store only the start time
        String[] endTimeWords = endTime.split(" ",2);
        this.endTime = endTimeWords[1]; // Ignore 'to' and store only the end time
    }

    @Override
    public String getTaskSymbol() {
        return TASK_SYMBOL;
    }

    @Override
    public String getTask() {
        return (super.content + " (from: " +  this.startTime + " to: " +  this.endTime + ")");
    }
}
