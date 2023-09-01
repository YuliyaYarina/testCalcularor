package com.example.testcalcularor.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorParameterizedTest {
    private final Calculator out = new Calculator();

    static Stream<Arguments> valuesForPlus (){
        return Stream.of(
                Arguments.of(5,5,"5 + 5 = 10"),
                Arguments.of(-3,7,"-3 + 7 = 4"),
                Arguments.of(0,5,"0 + 5 = 5"),
                Arguments.of(-3,3,"-3 + 3 = 0"),
                Arguments.of(-5,-5,"-5 + -5 = -10")
                );
    }

    static Stream<Arguments> valuesForMinus () {
        return Stream.of(
                Arguments.of(5, 5, "5 - 5 = 0"),
                Arguments.of(-3, 7, "-3 - 7 = -10"),
                Arguments.of(0, 5, "0 - 5 = -5"),
                Arguments.of(-3, 3, "-3 - 3 = -6"),
                Arguments.of(-5, -5, "-5 - -5 = 0")
        );
    }

    static Stream<Arguments> valuesForMultiply () {
        return Stream.of(
                Arguments.of(5, 5, "5 * 5 = 25"),
                Arguments.of(-3, 7, "-3 * 7 = -21"),
                Arguments.of(0, 5, "0 * 5 = 0"),
                Arguments.of(-3, 3, "-3 * 3 = -9"),
                Arguments.of(-5, -5, "-5 * -5 = 25")
        );
    }

    static Stream<Arguments> valuesForDivide () {
        return Stream.of(
                Arguments.of(5, 5, "5 / 5 = 1.0"),
                Arguments.of(-3, 7, "-3 / 7 = -0.42857142857142855"),
                Arguments.of(0, 5, "0 / 5 = 0.0"),
                Arguments.of(-3, 3, "-3 / 3 = -1.0"),
                Arguments.of(-5, -5, "-5 / -5 = 1.0")
        );
    }


    static Stream<Arguments> provideValuesForDivideByZero() {
        return Stream.of(
                Arguments.of(2, 0, IllegalArgumentException.class),
                Arguments.of(0, 0, IllegalArgumentException.class)
            );
    }
    @ParameterizedTest
    @MethodSource("valuesForPlus")
    void plus(Integer x, Integer y, String expected) {
        String actual = out.plus(x,y);
        Assertions.assertEquals(expected,actual);
    }

    @ParameterizedTest
    @MethodSource("valuesForMinus")
    void minus(Integer x, Integer y, String expected) {
        String actual = out.minus(x,y);
        Assertions.assertEquals(expected,actual);

    }

    @ParameterizedTest
    @MethodSource("valuesForMultiply")
    void multiply(Integer x, Integer y, String expected) {
        String actual = out.multiply(x,y);
        Assertions.assertEquals(expected,actual);
    }

    @ParameterizedTest
    @MethodSource("valuesForDivide")
    void divide(Integer x, Integer y, String expected) {
        String actual = out.divide(x,y);
        Assertions.assertEquals(expected,actual);
    }

    @ParameterizedTest
    @MethodSource("provideValuesForDivideByZero")
    void testDivideByZero(Integer x, Integer y) {
        assertThrows(IllegalArgumentException.class,
                () -> out.divide(x,y));
    }
}