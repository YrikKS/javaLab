package ru.nsu.kurgin.Workers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.Constants;
import ru.nsu.kurgin.Exeptions.StackExceptions;
import ru.nsu.kurgin.Exeptions.WorkerExceptions;
import ru.nsu.kurgin.StackParameters;

/**
 * a class implementing Div block
 */
public class Div implements Worker {
    private static final Logger logger = LogManager.getLogger(Div.class);
    /**
     * the function that starts the execution of the block
     * @param arguments - arguments passed to the block
     * @param stack - the wrapper class for the stack and the map
     * @throws WorkerExceptions - an exception will be triggered when trying to divide by zero
     * @throws StackExceptions - an exception will be triggered if an incorrect stack operation was done
     */
    @Override
    public void execution(String arguments, StackParameters stack) throws WorkerExceptions, StackExceptions {
        logger.info("start of block execution Div");
        double del1 = stack.pop();
        double del2 = stack.pop();
        if (del2 == 0) {
            logger.error("An exception was triggered in the Div block: " + Constants.EXEPTION_DIVISION_BY_ZERO);
            throw (new WorkerExceptions(Constants.EXEPTION_DIVISION_BY_ZERO));
        }
        double res = del1 / del2;
        stack.push(Double.toString(res));
        logger.info("the Div block ended as normal");
    }
}
