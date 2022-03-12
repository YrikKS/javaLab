package com.company.Workers;

import com.company.Constants;
import com.company.Exeptions.StackExceptions;
import com.company.Exeptions.WorkerExeption;
import com.company.Readers.Command;
import com.company.StackParameters;

public class Div implements Worker {
    @Override
    public void execution(String arguments, StackParameters stack) throws WorkerExeption, StackExceptions {
        double del1 = stack.pop();
        double del2 = stack.pop();
        if (del2 == 0)
            throw (new WorkerExeption(Constants.EXEPTION_DIVISION_BY_ZERO));
        double res = del1 / del2;
        stack.push(Double.toString(res));
    }
}
