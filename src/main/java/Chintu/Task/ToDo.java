package Chintu.Task;

public class ToDo extends Task {

    private final static String TASK_SYMBOL = "[T]";

    public ToDo(String description, String command) {
        super(description, command);
    }

    @Override
    public String getTaskSymbol(){
        return TASK_SYMBOL;
    }
}
