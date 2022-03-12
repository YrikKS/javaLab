package com.company.Workers;

import com.company.Constants;
import com.company.Exeptions.StackExceptions;
import com.company.Exeptions.WorkerExeption;
import com.company.StackParameters;

public class Sqrt implements Worker{
    @Override
    public void execution(String arguments, StackParameters stack) throws WorkerExeption, StackExceptions {
        double num = stack.pop();
        if (num < 0)
            throw (new WorkerExeption(Constants.EXEPTION_SQRT_NEGATIV_NUMBER));
        stack.push(Math.sqrt(num));
    }
}
