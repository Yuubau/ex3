package test;

import calc.Calculator;
import calc.operation.Additioner;
import calc.operation.Multiplier;
import calc.operation.Soustractor;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        List<Integer> values = List.of(1, 2, 3);
        Integer result = calculator.doCalculate("+", values);
        assertEquals(6, result, "Addition result should be 6");
    }

    @Test
    public void testSubtraction() {
        List<Integer> values = List.of(10, 2, 3);
        Integer result = calculator.doCalculate("-", values);
        assertEquals(5, result, "Subtraction result should be 5");
    }

    @Test
    public void testMultiplication() {
        List<Integer> values = List.of(2, 3, 4);
        Integer result = calculator.doCalculate("*", values);
        assertEquals(24, result, "Multiplication result should be 24");
    }

    @Test
    public void testUnknownOperation() {
        List<Integer> values = List.of(1, 2, 3);
        Integer result = calculator.doCalculate("?", values);
        assertNull(result, "Unknown operation should return null");
    }
}
