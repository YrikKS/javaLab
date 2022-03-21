package ru.nsu.kurgin;

import ru.nsu.kurgin.Exeptions.StackExceptions;
import ru.nsu.kurgin.Exeptions.WorkerExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.kurgin.Workers.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWorkers {
    @Test
    public void pop() throws StackExceptions, WorkerExceptions {
        StackParameters stackParameters1 = new StackParameters();
        stackParameters1.stack.push("5");
        stackParameters1.stack.push("4");
        Pop pop = new Pop();
        pop.execution(null, stackParameters1);
        assertEquals(stackParameters1.stack.peek(), "5");

        StackExceptions thrown = Assertions.assertThrows(StackExceptions.class, () -> {
            StackParameters stackParameters2 = new StackParameters();
            Pop pop2 = new Pop();
            pop2.execution(null, stackParameters2);
        }, "Exeption not thrown");
        Assertions.assertEquals("attempt to remove an element from an empty stack\n", thrown.getMessage());
    }

    @Test
    public void push() throws StackExceptions, WorkerExceptions {
        StackParameters stackParameters1 = new StackParameters();
        Push push = new Push();
        push.execution("5", stackParameters1);
        assertEquals("5", stackParameters1.stack.peek());

        push.execution("arr", stackParameters1);
        assertEquals("arr", stackParameters1.stack.peek());

        push.execution("1.2", stackParameters1);
        assertEquals("1.2", stackParameters1.stack.peek());

        WorkerExceptions thrown1 = Assertions.assertThrows(WorkerExceptions.class, () -> {
            StackParameters stackParameters2 = new StackParameters();
            Push push2 = new Push();
            push2.execution(null, stackParameters2);
        }, "Exeption not thrown");
        Assertions.assertEquals(Constants.EXEPTION_PUSH_NULL_ELEMENT, thrown1.getMessage());

        WorkerExceptions thrown2 = Assertions.assertThrows(WorkerExceptions.class, () -> {
            StackParameters stackParameters3 = new StackParameters();
            Push push3 = new Push();
            push3.execution("1 2", stackParameters3);
        }, "Exeption not thrown");
        Assertions.assertEquals(Constants.EXEPTION_NUMBER_ARGUMENTS, thrown2.getMessage());
    }

    @Test
    public void define() throws StackExceptions, WorkerExceptions {
        StackParameters stackParameters = new StackParameters();
        Define define = new Define();
        define.execution("a 5", stackParameters);
        assertEquals(stackParameters.mapParameters.get("a"), 5.0);

        define.execution("b 6.333", stackParameters);
        assertEquals(stackParameters.mapParameters.get("b"), 6.333);

        WorkerExceptions thrown2 = Assertions.assertThrows(WorkerExceptions.class, () -> {
            StackParameters stackParameters2 = new StackParameters();
            Define define2 = new Define();
            define2.execution("a", stackParameters2);
        }, "Exeption not thrown");
        Assertions.assertEquals(Constants.EXEPTION_NUMBER_ARGUMENTS, thrown2.getMessage());

        WorkerExceptions thrown3 = Assertions.assertThrows(WorkerExceptions.class, () -> {
            StackParameters stackParameters3 = new StackParameters();
            Define define3 = new Define();
            define3.execution(null, stackParameters3);
        }, "Exeption not thrown");
        Assertions.assertEquals(Constants.EXEPTION_NUMBER_ARGUMENTS, thrown3.getMessage());

        WorkerExceptions thrown4 = Assertions.assertThrows(WorkerExceptions.class, () -> {
            StackParameters stackParameters4 = new StackParameters();
            Define define4 = new Define();
            define4.execution("a a", stackParameters4);
        }, "Exeption not thrown");
        Assertions.assertEquals(Constants.EXEPTION_DEFINE_ARGUMENT_NOT_NUMBER + " a", thrown4.getMessage());
    }

    @Test
    public void sum() throws StackExceptions, WorkerExceptions {
        StackParameters stackParameters = new StackParameters();
        stackParameters.stack.push("5");
        stackParameters.stack.push("6");
        Sum sum = new Sum();
        sum.execution(null, stackParameters);
        assertEquals(stackParameters.stack.peek(), "11.0");

        stackParameters.stack.push("25.25");
        stackParameters.stack.push("75.25");
        sum.execution(null, stackParameters);
        assertEquals(stackParameters.stack.peek(), "100.5");
    }

    @Test
    public void minus() throws StackExceptions, WorkerExceptions {
        StackParameters stackParameters = new StackParameters();
        stackParameters.stack.push("5");
        stackParameters.stack.push("6");
        Minus minus = new Minus();
        minus.execution(null, stackParameters);
        assertEquals(stackParameters.stack.peek(), "1.0");
        stackParameters.stack.push("-10");

        minus.execution(null, stackParameters);
        assertEquals(stackParameters.stack.peek(), "-11.0");
    }

    @Test
    public void multi() throws StackExceptions, WorkerExceptions {
        StackParameters stackParameters = new StackParameters();
        stackParameters.stack.push("5");
        stackParameters.stack.push("6");
        Multi multi = new Multi();
        multi.execution(null, stackParameters);
        assertEquals(stackParameters.stack.peek(), "30.0");

        stackParameters.stack.push("-10");
        multi.execution(null, stackParameters);
        assertEquals(stackParameters.stack.peek(), "-300.0");
    }

    @Test
    public void div() throws StackExceptions, WorkerExceptions {
        StackParameters stackParameters = new StackParameters();
        stackParameters.stack.push("10");
        stackParameters.stack.push("60");
        Div div = new Div();
        div.execution(null, stackParameters);
        assertEquals(stackParameters.stack.peek(), "6.0");

        stackParameters.stack.push("-30");
        div.execution(null, stackParameters);
        assertEquals(stackParameters.stack.peek(), "-5.0");

        WorkerExceptions thrown1 = Assertions.assertThrows(WorkerExceptions.class, () -> {
            StackParameters stackParameters1 = new StackParameters();
            Div div1 = new Div();
            stackParameters1.stack.push("0");
            stackParameters1.stack.push("-30");
            div1.execution(null, stackParameters1);
        }, "Exeption not thrown");
        Assertions.assertEquals(Constants.EXEPTION_DIVISION_BY_ZERO, thrown1.getMessage());
    }

    @Test
    public void sqrt() throws StackExceptions, WorkerExceptions {
        StackParameters stackParameters = new StackParameters();
        stackParameters.stack.push("9");
        Sqrt sqrt = new Sqrt();
        sqrt.execution(null, stackParameters);
        assertEquals(stackParameters.stack.peek(), "3.0");

        WorkerExceptions thrown1 = Assertions.assertThrows(WorkerExceptions.class, () -> {
            StackParameters stackParameters1 = new StackParameters();
            stackParameters1.stack.push("-9");
            Sqrt sqrt1 = new Sqrt();
            sqrt1.execution(null, stackParameters1);
        }, "Exeption not thrown");
        Assertions.assertEquals(Constants.EXEPTION_SQRT_NEGATIV_NUMBER, thrown1.getMessage());
    }
}
