package email_box.controller;

import email_box.model.Email;
import email_box.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index", "listEmail", emailService.findAll());
    }

    @GetMapping("update")
    public String showUpdate(int id, Model model) {
        model.addAttribute("email", emailService.findById(id));
        model.addAttribute("languages", emailService.languages());
        model.addAttribute("pageSize", emailService.pageSize());
        return "update";
    }

    @PostMapping("save")
    public String updateEmail(@ModelAttribute Email email, RedirectAttributes redirectAttributes) {
        emailService.update(email);
        redirectAttributes.addFlashAttribute("message", "update successful !!");
        return "redirect:/";
    }

}
