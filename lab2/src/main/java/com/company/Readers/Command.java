package com.company.Readers;

import com.company.Constants;
import com.company.Exeptions.CommandExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {
    String command = null;
    String arguments = null;
    boolean readEnd = false;

    Command(String stringRead) throws CommandExceptions {
        if (stringRead == null || stringRead.equals("END")) {
            readEnd = true;
            return;
        }
        Pattern pattern = Pattern.compile(Constants.REGEX_FOR_DIVISION_COMMAND_AND_ARGUMENTS);
        Matcher matcher = pattern.matcher(stringRead);
        if (matcher.find())
            command = stringRead.substring(matcher.start(), matcher.end());
        else
            throw (new CommandExceptions(Constants.EXEPTION_INCORRECT_READING_STRING));
        if (matcher.end() == stringRead.length())
            arguments = null;
        else arguments = stringRead.substring(matcher.end() + 1, stringRead.length());
    }

    public boolean isReadEnd() {
        return readEnd;
    }

    public String getCommand() {
        return command;
    }

    public String getArguments() {
        return arguments;
    }

}
