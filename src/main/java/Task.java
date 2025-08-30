public class Task {

    protected String content;
    protected boolean isDone;
    private final String TASK_SYMBOL = "[ ]";

    public Task(String content) {
        this.content = content;
        this.isDone = false;
    }

    public String getTask() {
        return content;
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
}
