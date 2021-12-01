package com.target.java.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Rectangle2D;

import static org.junit.jupiter.api.Assertions.*;
// (.* imports all the static functions of a class)
// This import helps us use its functions directly
// Instead of typing Assertions.assertEquals
// Any class that has a static function, we can import the static part and use them
// as if the functions are present in our own file

public class CalculatorTests {

    Calculator calc;

    @BeforeEach
    // calls this function before executing each test specified
    // If we use @BeforeAll, there might be issues like, the tests might not even run
    public void setup(){
        calc = new Calculator();
    }

    @Test
    // Says that the following is a test case and run it even if it doesnt have main
    public void  shouldAddTwoNumbers(){

        //calc = new Calculator(); This can be called using the above setup() function
        Double actual = calc.add(12., 20.);
        Double expected = 32.;

        assertEquals(expected, actual);
        // THe above checks if they are equal or not
        // The test fails if they are not equal


    }

    @Test
    public void shouldAddStringNumbers(){
        Double actual = calc.add(10, "10.0", null);
        assertEquals(20.0, actual);
    }

    @Test
    public void shouldAddNegativeNumbers(){

        //calc = new Calculator(); This can be called using the above setup() function
        Double actual = calc.add(-10., -20., -30.);
        Double expected = -60.;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddAllNumbersButNulls()
    {
        // Double actual = calc.add(10.1, null, 10.1, null, 10.1);
       // Double expected = 30.3; Fails as output will be 30.299999999
        // One solution is to roundoff the actual part using Math.round
        Double actual = calc.add(10., null, 10., null, 10.);
        assertNotNull(actual);
        assertEquals(30.0, actual);
    }

    @Test
    public void shouldThrowException()
    {
        // SHould throw exception when no number strings ar given
        //Double actual = calc.add(10, "10.0", "ten");
        assertThrows(NumberFormatException.class, ()->calc.add(10, "10.0", "ten"));
        // this test will be passed when the calculator code throws an exception
    }

    @Test
    public void shouldNotThrowException()
    {
        assertDoesNotThrow(()-> {
            Double actual = calc.add(10, "10.0", "20.0");
            assertEquals(40., actual);
        });
    }


}
