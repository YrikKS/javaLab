package ru.nsu.kurgin.Readers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.Constants;
import ru.nsu.kurgin.Exeptions.CommandExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a class that implements the storage and processing of
 * the command name and its arguments read from the data stream
 */
public class Command {
    private static final Logger logger = LogManager.getLogger(Command.class);
    String command = null;
    String arguments = null;
    boolean readEnd = false;

    /**
     * Constructor of the class. Determines the name of the command, its arguments,
     * and checks whether the reading is finished
     *
     * @param stringRead - a string read from the data stream
     * @throws CommandExceptions -
     */
    Command(String stringRead) throws CommandExceptions {
        if (stringRead == null || stringRead.equals("END")) {
            readEnd = true;
            return;
        }
        Pattern pattern = Pattern.compile(Constants.REGEX_FOR_DIVISION_COMMAND_AND_ARGUMENTS);
        Matcher matcher = pattern.matcher(stringRead);
        if (matcher.find())
            command = stringRead.substring(matcher.start(), matcher.end());
        else {
            logger.error("An exception was triggered in  " + Constants.EXEPTION_INCORRECT_READING_STRING);
            throw (new CommandExceptions(Constants.EXEPTION_INCORRECT_READING_STRING));
        }
        if (matcher.end() == stringRead.length())
            arguments = null;
        else arguments = stringRead.substring(matcher.end() + 1);
        logger.info("the command and its arguments are read correctly");
    }

    /**
     * @return true - if read end, or false - if reading not end
     */
    public boolean isReadEnd() {
        return readEnd;
    }

    /**
     * @return name command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @return arguments command
     */
    public String getArguments() {
        return arguments;
    }

}
