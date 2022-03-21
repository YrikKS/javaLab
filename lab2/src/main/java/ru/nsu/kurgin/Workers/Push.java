package ru.nsu.kurgin.Workers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.Constants;
import ru.nsu.kurgin.Exeptions.StackExceptions;
import ru.nsu.kurgin.Exeptions.WorkerExceptions;
import ru.nsu.kurgin.StackParameters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a class implementing Print block
 */
public class Push implements Worker {
    private static final Logger logger = LogManager.getLogger(Push.class);
    /**
     * the function that starts the execution of the block
     *
     * @param arguments - arguments passed to the block
     * @param stack     - the wrapper class for the stack and the map
     * @throws WorkerExceptions - an exception will be triggered if incorrect arguments were passed
     * @throws StackExceptions  - an exception will be triggered if an incorrect stack operation was done
     */
    @Override
    public void execution(String arguments, StackParameters stack) throws WorkerExceptions, StackExceptions {
        logger.info("start of block execution Push");
        if (arguments == null) {
            logger.error("An exception was triggered in the push block: " + Constants.EXEPTION_PUSH_NULL_ELEMENT);
            throw (new WorkerExceptions(Constants.EXEPTION_PUSH_NULL_ELEMENT));
        }

        Pattern pattern = Pattern.compile(Constants.REGEX_FOR_CHECK_ARGUMENTS_IN_PUSH_WORKER);
        Matcher matcher = pattern.matcher(arguments);
        if (matcher.find()) {
            stack.push(arguments.substring(matcher.start(), matcher.end()));
        } else {
            logger.error("An exception was triggered in the push block: " + Constants.EXEPTION_PUSH_NULL_ELEMENT);
            throw (new WorkerExceptions(Constants.EXEPTION_NUMBER_ARGUMENTS));
        }
        logger.info("the of block ended as Push");
    }
}
