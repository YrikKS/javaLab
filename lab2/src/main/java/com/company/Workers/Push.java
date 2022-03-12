package com.company.Workers;

import com.company.Constants;
import com.company.Exeptions.StackExceptions;
import com.company.Exeptions.WorkerExeption;
import com.company.StackParameters;

import java.lang.constant.Constable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Push implements Worker {
    @Override
    public void execution(String arguments, StackParameters stack) throws WorkerExeption, StackExceptions {
        if (arguments == null) {
            throw (new WorkerExeption(Constants.EXEPTION_PUSH_NULL_ELEMENT));
        }

        Pattern pattern = Pattern.compile(Constants.REGEX_FOR_CHECK_ARGUMENTS_IN_PUSH_WORKER);
        Matcher matcher = pattern.matcher(arguments);
        if (matcher.find()) {
            stack.push(arguments.substring(matcher.start(), matcher.end()));
        } else
            throw (new WorkerExeption(Constants.EXEPTION_NUMBER_ARGUMENTS));
    }
}
