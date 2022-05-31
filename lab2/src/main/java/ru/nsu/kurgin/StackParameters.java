package ru.nsu.kurgin;

import ru.nsu.kurgin.Exeptions.StackExceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StackParameters {
    private Stack<String> stack = new Stack<>();
    private Map<String, Double> mapParameters = new HashMap<>();

    /**
     * function get last element in stack, convert in number and return them
     *
     * @return the number corresponding to the row at the top of the stack
     * @throws StackExceptions - an exception is triggered if it is not possible to convert a string to a number
     */
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

    /**
     * the function puts a string on the top of the stack
     *
     * @param element - the string to put on the top of the stack
     */
    public void push(String element) throws StackExceptions {
        stack.push(element);
    }

    /**
     * the function puts a string on the top of the stack
     *
     * @param element the number to put on the top of the stack
     */
    public void push(Double element) {
        stack.push(Double.toString(element));
    }

    /**
     * function copy last element in stack and return copy
     *
     * @return number in top the stack
     * @throws StackExceptions -  an exception is triggered if stack size is zero
     */
    public String peek() throws StackExceptions {
        if (stack.size() == 0)
            throw (new StackExceptions(Constants.EXEPTION_PRINT_ZERO_STACK_SIZE));
        return stack.peek();
    }

    /**
     * the function that fills the card
     */
    public void AddParametersInMap(String key, Double value) {
        mapParameters.put(key, value);
    }


    public Map<String, Double> getMapParameters() {
        return mapParameters;
    }

    public Stack<String> getStack() {
        return stack;
    }

}
