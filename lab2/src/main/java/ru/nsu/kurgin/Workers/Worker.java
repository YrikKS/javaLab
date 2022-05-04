package ru.nsu.kurgin.Workers;

import ru.nsu.kurgin.Exeptions.StackExceptions;
import ru.nsu.kurgin.Exeptions.WorkerExceptions;
import ru.nsu.kurgin.StackParameters;

/**
 * interface for blocks
 *
 * if you want to create your own block, you must inherit your block from this interface
 */
public interface Worker {
    /**
     *  the function that starts the execution of the block
     * @param arguments - arguments passed to the block
     * @param stack - the wrapper class for the stack and the map
     * @throws WorkerExceptions - exceptions that are thrown by blocks
     * @throws StackExceptions - exceptions that are thrown by stack
     */
    void execution(String arguments, StackParameters stack) throws WorkerExceptions, StackExceptions;
}
