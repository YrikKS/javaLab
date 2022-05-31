package ru.nsu.kurgin.Exeptions;

/**
 * this exception is triggered when the StackParameters wrapper class does not work correctly
 */
public class StackExceptions extends Exception {
    public StackExceptions(String message) {
        super(message);
    }

    public StackExceptions(String message, Throwable cause) {
        super(message, cause);
    }

}
