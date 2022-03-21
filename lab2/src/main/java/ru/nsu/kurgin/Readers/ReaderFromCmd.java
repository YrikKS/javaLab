package ru.nsu.kurgin.Readers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.Exeptions.CommandExceptions;

import java.util.Scanner;

/**
 * a class that implements reading from the console
 * implements from Reader
 */
public class ReaderFromCmd implements Reader {
    private static final Logger logger = LogManager.getLogger(ReaderFromCmd.class);
    Scanner in = null;

    /**
     * the constructor initializes the Scanner(To enter from the console)
     */
    ReaderFromCmd() {
        in = new Scanner(System.in);
    }

    /**
     * the function of reading a string from a Console
     *
     * @return - returns a class that stores the name of the command and its arguments
     * @throws CommandExceptions - special exception for this class
     */
    @Override
    public Command getCommand() throws CommandExceptions {
        logger.info("Reading the next line from the console");
        return new Command(in.nextLine());
    }

    /**
     * function closing the data stream
     */
    @Override
    public void close() {
        logger.info("Closing the console stream");
        in.close();
        logger.info("Console stream is closed");
    }
}
