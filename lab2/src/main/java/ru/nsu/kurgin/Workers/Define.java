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
 * a class implementing Define block
 */
public class Define implements Worker {
    private static final Logger logger = LogManager.getLogger(Define.class);

    /**
     * the function that starts the execution of the block
     * @param arguments - arguments passed to the block
     * @param stack - the wrapper class for the stack and the map
     * @throws WorkerExceptions - an exception will be triggered if incorrect arguments were passed
     * @throws StackExceptions - an exception will be triggered if an incorrect stack operation was done
     */
    @Override
    public void execution(String arguments, StackParameters stack) throws WorkerExceptions, StackExceptions {
        logger.info("start of block execution Define");
        if (arguments == null) {
            logger.error("An exception was triggered in the Define block: " + Constants.EXEPTION_NUMBER_ARGUMENTS);
            throw (new WorkerExceptions(Constants.EXEPTION_NUMBER_ARGUMENTS));
        }
        Pattern pattern = Pattern.compile(Constants.REGEX_FOR_DEFINE_ARGUMENTS);
        Matcher matcher = pattern.matcher(arguments);
        String parameter = null;
        if (matcher.find()) {
            parameter = arguments.substring(matcher.start(), matcher.end());
        } else {
//            logger.error("An exception was triggered in the Define block: " + Constants.EXEPTION_NUMBER_ARGUMENTS);
            throw (new WorkerExceptions(Constants.EXEPTION_NUMBER_ARGUMENTS));
        }

        String valueParameter = null;
        if (matcher.find()) {
            valueParameter = arguments.substring(matcher.start(), matcher.end());
            Pattern patternForNumber = Pattern.compile(Constants.REGEX_FOR_DEFINE_ARGUMENTS_CHECK_NUMBER);
            Matcher matcherForNumber = patternForNumber.matcher(valueParameter);
            if (!matcherForNumber.find()) {
                logger.error("An exception was triggered in the Define block: " + Constants.EXEPTION_DEFINE_ARGUMENT_NOT_NUMBER + " " + valueParameter);
                throw (new WorkerExceptions(Constants.EXEPTION_DEFINE_ARGUMENT_NOT_NUMBER + " " + valueParameter));
            }
        } else {
            logger.error(Constants.EXEPTION_NUMBER_ARGUMENTS + " " + valueParameter);
            throw (new WorkerExceptions(Constants.EXEPTION_NUMBER_ARGUMENTS));
        }
        stack.AddParametersInMap(parameter, Double.parseDouble(valueParameter));
        logger.info("the Define block ended as normal");
    }
}
