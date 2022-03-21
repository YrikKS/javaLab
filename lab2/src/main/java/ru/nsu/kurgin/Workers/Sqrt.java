package ru.nsu.kurgin.Workers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.Constants;
import ru.nsu.kurgin.Exeptions.StackExceptions;
import ru.nsu.kurgin.Exeptions.WorkerExceptions;
import ru.nsu.kurgin.StackParameters;

/**
 * a class implementing Print block
 */
public class Sqrt implements Worker {
    private static final Logger logger = LogManager.getLogger(Sqrt.class);
    /**
     * the function that starts the execution of the block
     *
     * @param arguments - arguments passed to the block
     * @param stack     - the wrapper class for the stack and the map
     * @throws WorkerExceptions - an exception will be triggered if sqrt negativ number
     * @throws StackExceptions  - an exception will be triggered if an incorrect stack operation was done
     */
    @Override
    public void execution(String arguments, StackParameters stack) throws WorkerExceptions, StackExceptions {
        logger.info("start of block execution Sqrt");
        double num = stack.pop();
        if (num < 0) {
            logger.error("An exception was triggered in the push block: " + Constants.EXEPTION_SQRT_NEGATIV_NUMBER);
            throw (new WorkerExceptions(Constants.EXEPTION_SQRT_NEGATIV_NUMBER));
        }
        stack.push(Math.sqrt(num));
        logger.info("the of block ended as Sqrt");
    }
}
