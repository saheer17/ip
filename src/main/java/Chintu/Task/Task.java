package Chintu.Task;

public abstract class Task {

    protected String content;
    protected String command;
    protected boolean isDone;
    private final String TASK_SYMBOL = "[ ]";

    public Task(String content, String command) {
        this.content = content;
        this.command = command;
        this.isDone = false;
    }

    public String getTask() {
        return content;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markDone() {
        isDone = true;
    }

    public void markUndone() {
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    public String getTaskSymbol(){
        return TASK_SYMBOL;
    }

    public String getCommand() {
        return command;
    }
}
