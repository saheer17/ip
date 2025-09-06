class TaskException extends Exception {
    public TaskException(String message) {
        super(message);
    }
}

class UnknownCommandException extends TaskException {
    public UnknownCommandException() {
        super("Command unclear, refer to instructions above");
    }
}

class InsufficientInformationException extends TaskException {
    public InsufficientInformationException(String taskType) {
        super("Insufficient information for " + taskType + " task. Refer to instructions above");
    }
}