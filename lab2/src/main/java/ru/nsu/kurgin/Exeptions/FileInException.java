package ru.nsu.kurgin.Exeptions;

/**
 * this exception is triggered when the incorrect file name
 */
public class FileInException extends Exception {
    public FileInException(String message) {
        super(message);
    }

}
