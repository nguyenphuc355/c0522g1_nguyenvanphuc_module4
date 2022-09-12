package calculator_simple.controller;

import calculator_simple.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class  CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/")
    public String page() {
        return "index";
    }

    @GetMapping("calculate")
    public ModelAndView calculate(@RequestParam String number1,@RequestParam  String number2,@RequestParam String calculation) {
        return new ModelAndView("index", "result", calculatorService.calculator(number1, number2, calculation));
    }
}
