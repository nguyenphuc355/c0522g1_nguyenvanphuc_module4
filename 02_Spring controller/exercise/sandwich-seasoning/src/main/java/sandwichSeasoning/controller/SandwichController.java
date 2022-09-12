package sandwichSeasoning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String showList() {
        return "index";
    }

    @GetMapping("save")
    public String save(@RequestParam String[] condiments, ModelMap modelMap) {
        modelMap.addAttribute("condiments", condiments);
        return "index";
    }
}
