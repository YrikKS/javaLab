package ru.nsu.kurgin.Readers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.Constants;
import ru.nsu.kurgin.Exeptions.CommandExceptions;
import ru.nsu.kurgin.Exeptions.FileInException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a class that implements reading from the console
 * implements from Reader
 */
public class ReaderFromFile implements Reader {
    private static final Logger logger = LogManager.getLogger(ReaderFromFile.class);
    private final BufferedReader reader;

    /**
     * the constructor initializes the Scanner(To enter from the file)
     *
     * @throws FileInException - the exception is triggered when the file name is incorrect
     */
    ReaderFromFile(String fileName) throws FileNotFoundException, FileInException {
        checkNameFileIn(fileName);
        logger.info("Opening a file");
        reader = new BufferedReader(new FileReader(fileName));
    }

    /**
     * @param nameFile - the name of the file passed to the program
     * @throws FileInException - the exception is triggered if the file name is not correct
     */
    private void checkNameFileIn(String nameFile) throws FileInException {
        logger.info("Checking the file name");
        Pattern pattern = Pattern.compile(Constants.REGEX_FILE_NAME_IN);
        Matcher matcher = pattern.matcher(nameFile);
        if (!matcher.find()) {
            logger.error("An exception was triggered while check file name: " + Constants.EXEPTION_FILE_NAME);
            throw (new FileInException(Constants.EXEPTION_FILE_NAME));
        }
    }

    /**
     * the function of reading a string from a Console
     *
     * @return - returns a class that stores the name of the command and its arguments
     * @throws IOException       - standard exception when reading from a file stream
     * @throws CommandExceptions - special exception for this class
     */
    @Override
    public Command getCommand() throws IOException, CommandExceptions {
        logger.info("Reading a line from a file");
        return new Command(reader.readLine());
    }

    /**
     * function close file
     */
    @Override
    public void close() throws Exception {
        logger.info("Closing a file");
        reader.close();
    }
}
