package the_song_validation.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import the_song_validation.dto.TheSongDto;
import the_song_validation.model.TheSong;
import the_song_validation.service.ITheSongService;

@Controller
@RequestMapping("/song")
public class TheSongController {
    @Autowired
    private ITheSongService theSongService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("theSongList", theSongService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("theSongDto", new TheSongDto());
        return "create";

    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute @Validated TheSongDto theSongDto, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            TheSong theSong = new TheSong();
            BeanUtils.copyProperties(theSongDto, theSong);
            theSongService.save(theSong);
            redirectAttributes.addFlashAttribute("mess", "create success!!");
            return "redirect:/song";
        }

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("theSongDto", theSongService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated TheSongDto theSongDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        }
        TheSong theSong = new TheSong();
        BeanUtils.copyProperties(theSongDto, theSong);
        theSongService.update(theSong);
        return "redirect:/song";
    }

}
