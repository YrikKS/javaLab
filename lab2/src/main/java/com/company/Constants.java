package com.company;

public class Constants {
    public static final String REGEX_NUM = "[0-9.-]+";
    public static final String REGEX_FOR_CONFIGURATION_FABRIC = "([\\S]+)";
    public static final String REGEX_FOR_DEFINE_ARGUMENTS = "([\\w.-]+)";
    public static final String REGEX_FOR_DEFINE_ARGUMENTS_CHECK_NUMBER = "(\\A[0-9.-]+\\Z)";
    public static final String REGEX_FOR_DIVISION_COMMAND_AND_ARGUMENTS = "([\\w+-/*#]+)";
    public static final String REGEX_FILE_NAME_IN = "([A-Za-z0-9А-Яа-яёЁ]+)(.txt)";
    public static final String REGEX_FOR_CHECK_ARGUMENTS_IN_PUSH_WORKER = "(\\A[A-Za-z0-9А-Яа-яёЁ.-]+\\Z)";
    public static final String FABRIC_CONFIGURATION_FILE_NAME = "C:\\code\\second_year\\sem4\\lab2\\src\\main\\java\\com\\company\\ConfigurationFabric.txt";

    public static final String EXEPTION_FILE_NAME = "error file name\n";
    public static final String EXEPTION_FABRIC_CONFIGURATION_FILE = "incorrect configuration file for the factory\n";
    public static final String EXEPTION_NUMBER_ARGUMENTS = "incorrect number of arguments\n";
    public static final String EXEPTION_INCORRECT_COMMAND = "incorrect name of command\n";
    public static final String EXEPTION_INCORRECT_READING_STRING = "incorrect line entered\n";
    public static final String EXEPTION_ZERO_STACK_SIZE = "attempt to remove an element from an empty stack\n";
    public static final String EXEPTION_PRINT_ZERO_STACK_SIZE = "attempt to print an element from an empty stack\n";
    public static final String EXEPTION_PUSH_NULL_ELEMENT = "attempt to put null element on stack\n";
    public static final String EXEPTION_UNINITIALIZED_PARAMETER = "attempt to use an uninitialized parameter\n";
    public static final String EXEPTION_DEFINE_ARGUMENT_NOT_NUMBER = "attempt to pass a non-number to arguments\n";
    public static final String EXEPTION_DIVISION_BY_ZERO = "attempt to division by zero\n";
    public static final String EXEPTION_SQRT_NEGATIV_NUMBER = "trying to extract the sqrt from a negative number\n";
}
