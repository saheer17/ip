public class ToDo extends Task{

    protected final static String TASK_SYMBOL = "[T]";

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String getTaskSymbol(){
        return TASK_SYMBOL;
    }
}
