package ru.nsu.kurgin.Workers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.Exeptions.StackExceptions;
import ru.nsu.kurgin.Exeptions.WorkerExceptions;
import ru.nsu.kurgin.StackParameters;

/**
 * a class implementing Sum block
 */
public class Sum implements Worker {
    private static final Logger logger = LogManager.getLogger(Sum.class);

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
        logger.info("start of block execution Sum");
        double result = stack.pop() + stack.pop();
        stack.push(Double.toString(result));
        logger.info("the of block ended as Sum");
    }
}
