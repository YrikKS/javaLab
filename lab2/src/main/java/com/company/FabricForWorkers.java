package com.company;

import com.company.Exeptions.CommandExceptions;
import com.company.Exeptions.FabricExceptions;
import com.company.Workers.Worker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Этот класс является фабриуой для команд
 */
public class FabricForWorkers {
    Map<String, Worker> mapWorkers = new HashMap<>();
    BufferedReader reader;

    FabricForWorkers() throws FabricExceptions {
        try {
            openConfigurationFile();
            Pattern pattern = Pattern.compile(Constants.REGEX_FOR_CONFIGURATION_FABRIC);
            String str = reader.readLine();
            while (str != null) {
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    String workerKey = str.substring(matcher.start(), matcher.end());
                    if (matcher.find()) {
                        Class<?> executor = Class.forName(str.substring(matcher.start(), matcher.end()));
                        Worker worker = (Worker) executor.getDeclaredConstructor().newInstance();

                        mapWorkers.put(workerKey, worker);
                        str = reader.readLine();
                    } else throw (new FabricExceptions(Constants.EXEPTION_FABRIC_CONFIGURATION_FILE));
                } else throw (new FabricExceptions(Constants.EXEPTION_FABRIC_CONFIGURATION_FILE));
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void openConfigurationFile() {
        try {
            reader = new BufferedReader(new FileReader(Constants.FABRIC_CONFIGURATION_FILE_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Worker getWorker(String str) throws CommandExceptions {//+-*
        Worker worker = mapWorkers.get(str);
        if (worker == null)
            throw (new CommandExceptions(Constants.EXEPTION_INCORRECT_COMMAND));
        return mapWorkers.get(str);
    }
}
