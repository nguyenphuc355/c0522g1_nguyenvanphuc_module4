package registration_form.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import registration_form.dto.UserDto;
import registration_form.model.User;
import registration_form.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";

    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            redirectAttributes.addFlashAttribute("mess", "create success!!");
            return "redirect:/user";
        }
    }

}
