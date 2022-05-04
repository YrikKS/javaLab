package ru.nsu.kurgin;

import ru.nsu.kurgin.Exeptions.CommandExceptions;
import ru.nsu.kurgin.Exeptions.FabricExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class TestFabric {
    @Test
    public void FabricTests() throws FabricExceptions, CommandExceptions {
        FabricForWorkers fabric = new FabricForWorkers();
        assertSame(fabric.getMapWorkers().get("+"), fabric.getWorker("+"));
        assertSame(fabric.getMapWorkers().get("-"), fabric.getWorker("-"));
        assertSame(fabric.getMapWorkers().get("*"), fabric.getWorker("*"));
        assertSame(fabric.getMapWorkers().get("/"), fabric.getWorker("/"));
        assertSame(fabric.getMapWorkers().get("SQRT"), fabric.getWorker("SQRT"));
        assertSame(fabric.getMapWorkers().get("PUSH"), fabric.getWorker("PUSH"));
        assertSame(fabric.getMapWorkers().get("POP"), fabric.getWorker("POP"));
        assertSame(fabric.getMapWorkers().get("DEFINE"), fabric.getWorker("DEFINE"));
        assertSame(fabric.getMapWorkers().get("PRINT"), fabric.getWorker("PRINT"));

        CommandExceptions thrown1 = Assertions.assertThrows(CommandExceptions.class, () -> {
            FabricForWorkers fabric1 = new FabricForWorkers();
            fabric1.getWorker("1");
        }, "Exeption not thrown");
        Assertions.assertEquals(Constants.EXEPTION_INCORRECT_COMMAND, thrown1.getMessage());
    }
}
