package ru.nsu.kurgin;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.Exeptions.CommandExceptions;
import ru.nsu.kurgin.Exeptions.FabricExceptions;
import ru.nsu.kurgin.Workers.Worker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FabricForWorkers {
    private static final Logger logger = LogManager.getLogger(FabricForWorkers.class);
    Map<String, Worker> mapWorkers = new HashMap<>();
    BufferedReader reader;

    /**
     * the constructor for the factory, it fills in the map
     * @throws FabricExceptions - an exception will be triggered if fabric works incorrect
     */
    FabricForWorkers() throws FabricExceptions {
        logger.info("Factory Configuration");
        try {
            logger.info("Opening the configuration file for the factory");
            openConfigurationFile();
            Pattern pattern = Pattern.compile(Constants.REGEX_FOR_CONFIGURATION_FABRIC);
            String str = reader.readLine();
            logger.info("filling out the map for the factory");
            while (str != null) {
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    String workerKey = str.substring(matcher.start(), matcher.end());
                    if (matcher.find()) {
                        Class<?> executor = Class.forName(str.substring(matcher.start(), matcher.end()));
                        Worker worker = (Worker) executor.getDeclaredConstructor().newInstance();

                        mapWorkers.put(workerKey, worker);
                        str = reader.readLine();
                    } else {
                        logger.error("An exception was triggered in factory configuration: " + Constants.EXEPTION_FABRIC_CONFIGURATION_FILE);
                        throw (new FabricExceptions(Constants.EXEPTION_FABRIC_CONFIGURATION_FILE));
                    }
                } else {
                    logger.error("An exception was triggered in factory configuration: " + Constants.EXEPTION_FABRIC_CONFIGURATION_FILE);
                    throw (new FabricExceptions(Constants.EXEPTION_FABRIC_CONFIGURATION_FILE));
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
            throw (new FabricExceptions(Constants.EXEPTION_FABRIC_CONFIGURATION_FILE));
        }
    }

    private void openConfigurationFile() {
        try {
            reader = new BufferedReader(new FileReader(Constants.FABRIC_CONFIGURATION_FILE_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * function of getting Worker from the map
     * @param str - name command
     * @return - the worker that is the implementation of this command
     * @throws CommandExceptions - An exception was triggered while incorrect name command or not use define from this command
     */
    public Worker getWorker(String str) throws CommandExceptions {//+-*
        logger.info("Getting a worker from the factory");
        Worker worker = mapWorkers.get(str);
        if (worker == null) {
            logger.error("An exception was triggered while getting worker: " + Constants.EXEPTION_INCORRECT_COMMAND);
            throw (new CommandExceptions(Constants.EXEPTION_INCORRECT_COMMAND));
        }
        return mapWorkers.get(str);
    }
}
