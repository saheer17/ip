package Chintu;

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

class InvalidTaskNumberException extends TaskException {
    public InvalidTaskNumberException() {
        super("Invalid task number given to mark/unmark task");
    }
}