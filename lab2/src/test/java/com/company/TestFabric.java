package com.company;

import com.company.Exeptions.CommandExceptions;
import com.company.Exeptions.WorkerExeption;
import com.company.Workers.*;
import com.company.Exeptions.FabricExceptions;
import com.company.Readers.FabricReaders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TestFabric {
    @Test
    public void FabricTests() throws FabricExceptions, CommandExceptions {
        FabricForWorkers fabric = new FabricForWorkers();
        assertSame(fabric.mapWorkers.get("+"), fabric.getWorker("+"));
        assertSame(fabric.mapWorkers.get("-"), fabric.getWorker("-"));
        assertSame(fabric.mapWorkers.get("*"), fabric.getWorker("*"));
        assertSame(fabric.mapWorkers.get("/"), fabric.getWorker("/"));
        assertSame(fabric.mapWorkers.get("SQRT"), fabric.getWorker("SQRT"));
        assertSame(fabric.mapWorkers.get("PUSH"), fabric.getWorker("PUSH"));
        assertSame(fabric.mapWorkers.get("POP"), fabric.getWorker("POP"));
        assertSame(fabric.mapWorkers.get("DEFINE"), fabric.getWorker("DEFINE"));
        assertSame(fabric.mapWorkers.get("PRINT"), fabric.getWorker("PRINT"));

        CommandExceptions thrown1 = Assertions.assertThrows(CommandExceptions.class, () -> {
            FabricForWorkers fabric1 = new FabricForWorkers();
            fabric1.getWorker("1");
        }, "Exeption not thrown");
        Assertions.assertEquals(Constants.EXEPTION_INCORRECT_COMMAND, thrown1.getMessage());
    }
}
