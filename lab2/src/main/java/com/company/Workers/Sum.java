package com.company.Workers;

import com.company.Exeptions.StackExceptions;
import com.company.Exeptions.WorkerExeption;
import com.company.StackParameters;

public class Sum implements Worker {
    @Override
    public void execution(String arguments, StackParameters stack) throws WorkerExeption, StackExceptions {
        double result = stack.pop() + stack.pop();
        stack.push(Double.toString(result));
    }
}
