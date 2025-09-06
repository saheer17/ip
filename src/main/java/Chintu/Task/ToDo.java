package Chintu.Task;

public class ToDo extends Task {

    private final static String TASK_SYMBOL = "[T]";

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String getTaskSymbol(){
        return TASK_SYMBOL;
    }
}
