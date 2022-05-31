package ru.nsu.kurgin.Workers;

import ru.nsu.kurgin.Exeptions.StackExceptions;
import ru.nsu.kurgin.Exeptions.WorkerExceptions;
import ru.nsu.kurgin.StackParameters;

/**
 * a class implementing # block
 */
public class Comment implements Worker{
    /**
     * This function does nothing, since the comment should not be processed.
     * @param arguments - comment
     * @param stack - the wrapper class for the stack and the map
     * @throws WorkerExceptions
     * @throws StackExceptions
     */
    @Override
    public void execution(String arguments, StackParameters stack) throws WorkerExceptions, StackExceptions {
    }
}
