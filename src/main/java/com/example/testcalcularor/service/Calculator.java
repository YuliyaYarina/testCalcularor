package com.example.testcalcularor.service;

import com.example.testcalcularor.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class Calculator implements CalculatorService {

//    private final String msg;
//
//    public Calculator(@Value("${calculator.msg}") String msg) {
//        this.msg = msg;
//    }

    //    public String calculator() {
//        return "Добро пожаловать в калькулятор";
//    }
    @Override
    public String plus(Integer num1, Integer num2) {
//        return msg + (num1 + num2);
        if ((num1 == null) || (num2 == null)) {
            return "Not all parameters are given";
        } else return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @Override
    public String minus(Integer num1, Integer num2) {
//        return msg + (num1 - num2);
        if ((num1 == null) || (num2 == null)) {
            return "Not all parameters are given";
        } else return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    @Override
    public String multiply(Integer num1, Integer num2) {
//        return "" + (num1 * num2);
        if ((num1 == null) || (num2 == null)) {
            return "Not all parameters are given";
        } else return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    @Override
    public String divide(Integer num1, Integer num2) {
//        return "" + (num1 / num2);
        if ((num1 == null) || (num2 == null)) {
            return "Not all parameters are given";
        } else if (num2 == 0) {
            throw new IllegalArgumentException("Cannot be divided by 0");
        } return num1 + " / " + num2 + " = " + (1.0 * num1 / num2);
    }
}
