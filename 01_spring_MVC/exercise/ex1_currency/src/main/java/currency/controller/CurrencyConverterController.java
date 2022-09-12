package currency.controller;

import currency.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyConverterController {
    @Autowired
    private ICurrencyService currencyService;

    @GetMapping("/")
    public String currency() {
        return "submit";
    }

    @PostMapping("/usd")
    public ModelAndView result(@RequestParam double money){
        return new ModelAndView("submit","result",currencyService.calculate(money));
    }
}
