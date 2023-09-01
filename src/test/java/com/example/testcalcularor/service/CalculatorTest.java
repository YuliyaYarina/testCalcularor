package com.example.testcalcularor.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator out = new Calculator();

    @Test
    void plus() {
        Integer x = 4;
        Integer y = 2;
        Integer z = null;
        String exz = "Not all parameters are given";
        String expected = "4 + 2 = 6";
        String actual = out.plus(x,y);
        String actual2 = out.plus(x,z);
        Assertions.assertEquals(expected,actual);
        Assertions.assertEquals(exz, actual2);
    }

    @Test
    void minus() {
    }

    @Test
    void multiply() {
    }

    @Test
    void divide() {

        Integer x = 5;
        Integer y = 2;
        Integer z = null;
        Integer zero = 0;
        String exz = "Not all parameters are given";
        String expected = "5 / 2 = 2.5";
        String actual = out.divide(x,y);
        String actual2 = out.divide(x,z);
        Assertions.assertEquals(expected,actual);
        Assertions.assertEquals(exz, actual2);
        Assertions.assertThrows(IllegalArgumentException.class, ()-> out.divide(x,zero));


    }
}