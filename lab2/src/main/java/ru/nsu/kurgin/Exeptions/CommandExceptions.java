package ru.nsu.kurgin.Exeptions;

/**
 * This exception is triggered when the command is working incorrectly
 */
public class CommandExceptions extends Exception {
    public CommandExceptions(String message) {
        super(message);
    }
}