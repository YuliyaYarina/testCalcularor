package com.example.testcalcularor.controller;

import com.example.testcalcularor.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController()
    @RequestMapping(path = "/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }


    @GetMapping(path = "/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2, @ModelAttribute("message") String m) {
        System.out.println(m);
        return calculatorService.plus(num1,num2);
    }

    @GetMapping(path = "/minus")
    public String plminus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2, @ModelAttribute("message") String m) {
        System.out.println(m);
        return calculatorService.minus(num1,num2);
    }
    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2, @ModelAttribute("message") String m) {
        System.out.println(m);
        return calculatorService.multiply(num1,num2);
    }
    @GetMapping(path = "/divide")
    public String divide(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2, @ModelAttribute("message") String m) {
        System.out.println(m);
        return calculatorService.divide(num1,num2);
    }
}
