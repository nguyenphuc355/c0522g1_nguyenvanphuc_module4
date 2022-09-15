package music_management.controller;

import music_management.model.Music;
import music_management.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;


    @GetMapping("/")
    public String showList(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";

    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
        musicService.save(music);
        redirectAttributes.addFlashAttribute("mess", "create success!!");
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirect) {
        musicService.remove(music.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Music music) {
        musicService.update(music);
        return "redirect:/";
    }
}
