package com.company;

import com.company.Exeptions.StackExceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * ghbdxgfhg
 */
public class StackParameters {
    Stack<String> stack = new Stack<>();
    Map<String, Double> mapParameters = new HashMap<>();

    public Double pop() throws StackExceptions {
        if (stack.size() == 0)
            throw (new StackExceptions(Constants.EXEPTION_ZERO_STACK_SIZE));
        Pattern pattern = Pattern.compile(Constants.REGEX_NUM);
        String str = stack.pop();
        Matcher matcher = pattern.matcher(str);
        if (matcher.find())
            return Double.parseDouble(str.substring(matcher.start(), matcher.end()));
        else {
            Double digit = mapParameters.get(str);
            if (digit != null)
                return digit;
            else
                throw (new StackExceptions(Constants.EXEPTION_UNINITIALIZED_PARAMETER));
        }
    }

    public void push(String element) throws StackExceptions {
        stack.push(element);
    }

    public void push(Double element) {
        stack.push(Double.toString(element));
    }

    public void print() throws StackExceptions {
        if (stack.size() == 0)
            throw (new StackExceptions(Constants.EXEPTION_PRINT_ZERO_STACK_SIZE));
        System.out.println(stack.peek());
    }

    public void AddParametersInMap(String key, Double value) {
        mapParameters.put(key, value);
    }

}
