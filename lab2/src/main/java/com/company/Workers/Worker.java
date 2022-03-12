package com.company.Workers;

import com.company.Exeptions.StackExceptions;
import com.company.Exeptions.WorkerExeption;
import com.company.StackParameters;

public interface Worker {
    /**
     *
     * @param arguments это аргументы передаваемые воркеру
     * @param stack
     * @throws WorkerExeption
     * @throws StackExceptions
     */
    public void execution(String arguments, StackParameters stack) throws WorkerExeption, StackExceptions;
}
