package com.example.blog_app.controller;

import com.example.blog_app.model.BlogApp;
import com.example.blog_app.service.IBlogService;
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
public class BlogController {
    @Autowired
    private IBlogService blogService;


    @GetMapping({"index", "/"})
    public String showList(Model model) {
        List<BlogApp> blogAppList = blogService.findAll();
        model.addAttribute("blogList", blogAppList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blogApp", new BlogApp());
        return "create";

    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute BlogApp blogApp, RedirectAttributes redirectAttributes) {
        blogService.save(blogApp);
        redirectAttributes.addFlashAttribute("mess", "create success!!");
        return "redirect:/index";
    }

    @GetMapping("delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("blogApp", blogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(BlogApp blogApp, RedirectAttributes redirect) {
        blogService.remove(blogApp.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/index";
    }

    @GetMapping("view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blogApp", blogService.findById(id));
        return "view";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blogApp", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(BlogApp blogApp) {
        blogService.update(blogApp);
        return "redirect:/index";
    }
}
