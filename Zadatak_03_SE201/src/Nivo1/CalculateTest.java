package Nivo1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateTest {
    @Test
    public void testAddPositiveNumbers() {
        Calculate calculator = new Calculate();
        int result = calculator.add(5, 7);
        assertEquals(12, result);
    }
}

