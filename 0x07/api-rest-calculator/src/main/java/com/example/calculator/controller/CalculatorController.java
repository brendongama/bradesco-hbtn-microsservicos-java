package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    Calculator calc = new Calculator();

    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem vindo à CALCULATOR API REST.";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam Double number1, @RequestParam Double number2) {
        return calc.sum(number1, number2).toString();
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam Double number1, @RequestParam Double number2) {
        return calc.sub(number1, number2).toString();
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam Double number1, @RequestParam Double number2) {
        return calc.divide(number1, number2).toString();
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam Integer factorial) {
        return calc.factorial(factorial).toString();
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {
        return String.valueOf(calc.calculeDayBetweenDate(localDate1, localDate2));
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam Integer number1) {
        return calc.integerToBinary(number1).toString();
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam Integer number1) {
        return calc.integerToHexadecimal(number1);
    }
}
