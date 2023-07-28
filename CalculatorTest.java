import org.junit.Test;

import java.util.Arrays;
import java.util.List;
//import static org.mockito.Mockito.*;


import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAddition() {
        Calculator1 calculator = new Calculator1();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }
    
    @Test
    public void testAddition2() {
        Calculator1 calculator = new Calculator1();
        int result = calculator.add(9, 10);
        assertEquals(19, result);
    }

    @Test
    public void testAddition3() {
        Calculator1 calculator = new Calculator1();
        int result = calculator.add(23, 10);
        assertEquals(33, result);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAdditionWithNegativeParameters() {
        Calculator1 calculator = new Calculator1();
        calculator.add(-2, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdditionWithOverflow() {
        Calculator1 calculator = new Calculator1();
        calculator.add(Integer.MAX_VALUE, 1);
    }


    @Test(expected = NullPointerException.class)
    public void testAdditionNull() {
        Calculator1 calculator = new Calculator1();
        calculator.add(null, 1);
    }
    @Test
    public void testMyFunction() {
        Calculator1 obj = new Calculator1();
        List<Integer> inputs = Arrays.asList(10, 20, 30);
        List<Integer> expectedValues = Arrays.asList(11, 21, 31);
        for (int i = 0; i < inputs.size(); i++) {
            obj.setValue(inputs.get(i));
            obj.increment();
            assertEquals(expectedValues.get(i), obj.getValue());
        }
    }
//    @Test
//    public void testMyMethod() {
//        MyClass obj = mock(MyClass.class);
//        when(obj.myMethod(anyInt())).thenReturn(10);
//        int result = obj.myMethod(2);
//        assertEquals(10, result);
//    }
    
}
