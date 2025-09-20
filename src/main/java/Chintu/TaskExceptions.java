package Chintu;

/**
 * Base class for all task-related exceptions in the Chintu application.
 * All other task-specific exceptions should extend this class.
 */
class TaskException extends Exception {
    /**
     * Constructs a new {@code TaskException} with the specified detail message.
     *
     * @param message Detail message explaining the cause of the exception.
     */
    public TaskException(String message) {
        super(message);
    }
}

/**
 * Thrown to indicate that the user entered a command
 * that does not match any known command.
 */
class UnknownCommandException extends TaskException {
    /**
     * Constructs a new {@code UnknownCommandException} with a default message.
     */
    public UnknownCommandException() {
        super("Command unclear, refer to instructions above");
    }
}

/**
 * Thrown to indicate that the user did not provide enough
 * information when creating a task (e.g., missing description or time).
 */
class InsufficientInformationException extends TaskException {
    /**
     * Constructs a new {@code InsufficientInformationException} for the specified task type.
     * @param taskType The type of task for which information was insufficient.
     */
    public InsufficientInformationException(String taskType) {
        super("Insufficient information for " + taskType + " task. Refer to instructions above");
    }
}

/**
 * Thrown to indicate that the user attempted to mark or unmark
 * a task number that does not exist in the task list.
 */
class InvalidTaskNumberException extends TaskException {
    /**
     * Constructs a new {@code InvalidTaskNumberException} with a default message.
     */
    public InvalidTaskNumberException() {
        super("Invalid task number given to mark/unmark task");
    }
}

/**
 * Thrown to indicate that the user attempted to delete
 * a task number that does not exist in the task list.
 */
class InvalidDeleteCommandException extends TaskException {
    /**
     * Constructs a new {@code InvalidDeleteCommandException} with a default message.
     */
    public InvalidDeleteCommandException() {
        super("Invalid delete command, task number does not exist");
    }
}