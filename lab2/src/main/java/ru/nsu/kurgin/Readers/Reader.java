package ru.nsu.kurgin.Readers;

import ru.nsu.kurgin.Exeptions.CommandExceptions;

import java.io.IOException;

/**
 * interface for reading from a data stream
 */
public interface Reader extends AutoCloseable {
    /**
     * the function of reading a string from a stream
     *
     * @return - returns a class that stores the name of the command and its arguments
     * @throws IOException       - standard exception when reading from a data stream
     * @throws CommandExceptions - special exception for this class
     */
    Command getCommand() throws IOException, CommandExceptions;

}
