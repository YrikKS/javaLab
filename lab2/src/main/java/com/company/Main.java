package com.company;

import com.company.Exeptions.*;
import com.company.Readers.Command;
import com.company.Readers.FabricReaders;
import com.company.Readers.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FabricExceptions {

        try {
            FabricForWorkers fabric = new FabricForWorkers();
            Reader reader = new FabricReaders().getReader(args);
            StackParameters stackParameters = new StackParameters();
            while (true) {
                try {
                    Command readCommand = reader.getCommand();
                    if (readCommand.isReadEnd())
                        break;
                    else
                        fabric.getWorker(readCommand.getCommand()).execution(readCommand.getArguments(), stackParameters);
                } catch (CommandExceptions | WorkerExeption | StackExceptions commandExceptions) {
                    commandExceptions.printStackTrace();
//                    logger.error("Ошибка в считывании: ", commandExceptions)
                }
            }
            reader.closeInputStream();
        } catch (FabricExceptions | FileInException | IOException otherExeption) {
            otherExeption.printStackTrace();
        }
    }
}