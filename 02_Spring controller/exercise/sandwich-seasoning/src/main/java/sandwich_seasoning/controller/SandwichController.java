package sandwich_seasoning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String showList() {
        return "index";
    }

    @GetMapping("save")
    public ModelAndView result(@RequestParam(value = "condiment", defaultValue = "") String[] arr) {
        ModelAndView modelAndView = new ModelAndView("index");

        if (arr.length == 0) {
            modelAndView.addObject("condiment", "There is no choice you !!");
        } else {
            modelAndView.addObject("condiment", arr);
        }

        return modelAndView;
    }
}
