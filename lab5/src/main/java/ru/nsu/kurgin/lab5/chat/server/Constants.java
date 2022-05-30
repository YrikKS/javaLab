package ru.nsu.kurgin.lab5.chat.server;

public class Constants {
    public static final int SOCKET = 11111;
    public static final String FABRIC_CONFIGURATION_FILE_NAME = "src/main/java/ru/nsu/kurgin/lab5/chat/server/fileConfiguration";
    public static final String REGEX_FOR_CONFIGURATION_FABRIC = "([\\S]+)";
    public static final String EXEPTION_FABRIC_CONFIGURATION_FILE = "incorrect configuration file for the factory\n";

    public static final String COMMAND_MASSAGE = "massage";
    public static final String COMMAND_LOGIN = "login";
    public static final String COMMAND_LOGOUT = "logout";
    public static final String COMMAND_LIST_USERS = "listUsers";
    public static final String COMMAND_USER_LOGIN = "userLogin";
    public static final String COMMAND_USER_LOGOUT = "userLogout";
    public static final String COMMAND_ANSWER = "answer";
}
