package ru.nsu.kurgin.Workers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.Exeptions.StackExceptions;
import ru.nsu.kurgin.Exeptions.WorkerExceptions;
import ru.nsu.kurgin.StackParameters;

/**
 * a class implementing Print block
 */
public class Print implements Worker {
    private static final Logger logger = LogManager.getLogger(Print.class);
    /**
     * the function that starts the execution of the block
     *
     * @param arguments - arguments passed to the block
     * @param stack     - the wrapper class for the stack and the map
     * @throws WorkerExceptions - never triggered
     * @throws StackExceptions  - an exception will be triggered if an incorrect stack operation was done
     */
    @Override
    public void execution(String arguments, StackParameters stack) throws WorkerExceptions, StackExceptions {
        logger.info("start of block execution Print");
        System.out.println(stack.peek());
        logger.info("the of block ended as Print");
    }
}
