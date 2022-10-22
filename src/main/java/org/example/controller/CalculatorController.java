package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.CalculatorService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator/")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @GetMapping
    public String welcome (){
        return "<b>Добро пожаловать!</b>";
    }

    @GetMapping ("/plus")
    public String plus (@RequestParam (name = "number1", required = false) Integer a,
                        @RequestParam (name = "number2", required = false) Integer b ) {
        if (a==null || b==null) return "Ошибка";
        int plus = calculatorService.plus(a, b);
        return a + " + " + b + " = " + plus;
    }

    @GetMapping ("/minus")
    public String minus (@RequestParam (name = "number1", required = false) Integer a,
                        @RequestParam (name = "number2", required = false) Integer b ) {
        if (a==null || b==null) return "Ошибка";
        int minus = calculatorService.minus(a, b);
        return a + " - " + b + " = " + minus;
    }

    @GetMapping ("/multiply")
    public String multiply (@RequestParam (name = "number1", required = false) Integer a,
                         @RequestParam (name = "number2", required = false) Integer b ) {
        if (a==null || b==null) return "Ошибка";
        int multiply = calculatorService.multiply(a, b);
        return a + " * " + b + " = " + multiply;
    }

    @GetMapping ("/divide")
    public String divide (@RequestParam (name = "number1", required = false) Integer a,
                         @RequestParam (name = "number2", required = false) Integer b ) {
        if (a==null || b==null) return "Ошибка";
        double divide;
        try {
            divide = calculatorService.divide(a, b);
        } catch (Throwable e){
            return e.getMessage();
        }
        return a + " / " + b + " = " + divide;
    }
}
