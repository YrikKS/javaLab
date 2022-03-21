package ru.nsu.kurgin;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.kurgin.Exeptions.*;
import ru.nsu.kurgin.Readers.Command;
import ru.nsu.kurgin.Readers.FabricReaders;
import ru.nsu.kurgin.Readers.Reader;

import java.io.IOException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("\nLaunching the program");
        try {
            FabricForWorkers fabric = new FabricForWorkers();
            try (Reader reader = new FabricReaders().getReader(args)) {
                StackParameters stackParameters = new StackParameters();
                while (true) {
                    try {
                        Command readCommand = reader.getCommand();
                        if (readCommand.isReadEnd())
                            break;
                        else
                            fabric.getWorker(readCommand.getCommand()).execution(readCommand.getArguments(), stackParameters);
                    } catch (CommandExceptions | WorkerExceptions | StackExceptions commandExceptions) {
                        commandExceptions.printStackTrace();
                        logger.info("The exception has been processed");
                    }
                }
            } catch (Exception InputExeption) {
                InputExeption.printStackTrace();
                logger.info("The exception has been processed");
            }
        } catch (FabricExceptions  otherExeption) {
            otherExeption.printStackTrace();
            logger.info("The exception has been processed");
        }
        logger.info("Completion of the program\n");
    }
}