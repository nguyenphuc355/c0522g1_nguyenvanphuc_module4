package dictionary.controller;

import dictionary.model.Dictionary;
import dictionary.service.IDictionaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/")
    public String search() {
        return "mean";
    }

    @PostMapping("result")
    public String mean(@RequestParam String keyword, Model model) {
        List<Dictionary> dictionaries = dictionaryService.findAll();
        for (Dictionary dictionary : dictionaries) {
            if (keyword.equalsIgnoreCase(dictionary.getEnglish())) {
                model.addAttribute("word", dictionary.getVietNamEse());
                model.addAttribute("key", keyword);
                break;
            } else {
                model.addAttribute("word", "word not found!!");
            }
        }
        return "mean";
    }
}
