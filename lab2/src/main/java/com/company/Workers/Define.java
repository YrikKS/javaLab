package com.company.Workers;

import com.company.Constants;
import com.company.Exeptions.StackExceptions;
import com.company.Exeptions.WorkerExeption;
import com.company.StackParameters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Define implements Worker {
    @Override
    public void execution(String arguments, StackParameters stack) throws WorkerExeption, StackExceptions {
        if (arguments == null)
            throw (new WorkerExeption(Constants.EXEPTION_NUMBER_ARGUMENTS));
        Pattern pattern = Pattern.compile(Constants.REGEX_FOR_DEFINE_ARGUMENTS);
        Matcher matcher = pattern.matcher(arguments);
        String parameter = null;
        if (matcher.find()) {
            parameter = arguments.substring(matcher.start(), matcher.end());
        } else
            throw (new WorkerExeption(Constants.EXEPTION_NUMBER_ARGUMENTS));

        String valueParameter = null;
        if (matcher.find()) {
            valueParameter = arguments.substring(matcher.start(), matcher.end());
            Pattern patternForNumber = Pattern.compile(Constants.REGEX_FOR_DEFINE_ARGUMENTS_CHECK_NUMBER);
            Matcher matcherForNumber = patternForNumber.matcher(valueParameter);
            if (!matcherForNumber.find())
                throw (new WorkerExeption(Constants.EXEPTION_DEFINE_ARGUMENT_NOT_NUMBER + " " + valueParameter));
        } else
            throw (new WorkerExeption(Constants.EXEPTION_NUMBER_ARGUMENTS));
        stack.AddParametersInMap(parameter, Double.parseDouble(valueParameter));
    }
}
