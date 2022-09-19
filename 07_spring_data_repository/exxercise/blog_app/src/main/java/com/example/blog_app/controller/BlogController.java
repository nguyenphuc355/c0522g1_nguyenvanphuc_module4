package com.example.blog_app.controller;

import com.example.blog_app.model.BlogApp;
import com.example.blog_app.service.IBlogService;
import com.example.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

//    @GetMapping("")
//    public String showList(@PageableDefault(value = 3) Pageable pageable, Model model) {
//        model.addAttribute("blogList", blogService.findAll(pageable));
//        return "index";
//    }


    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("cateGoryList", categoryService.findAll());
        model.addAttribute("blogApp", new BlogApp());
        return "blog/create";

    }

    @PostMapping("/save")
    public String saveProduct(BlogApp blogApp, RedirectAttributes redirectAttributes) {
        blogService.save(blogApp);
        redirectAttributes.addFlashAttribute("mess", "create success!!");
        return "redirect:/blog";
    }

    @GetMapping("delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("blogApp", blogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(BlogApp blogApp, RedirectAttributes redirect) {
        blogService.remove(blogApp.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/blog";
    }

    @GetMapping("view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blogApp", blogService.findById(id));
        model.addAttribute("category",categoryService.findById(id));
        return "blog/view";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blogApp", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(BlogApp blogApp) {
        blogService.update(blogApp);
        return "redirect:/blog";
    }

    @GetMapping("")
    public String search(@RequestParam(value = "name", defaultValue = "") String name, @PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blogList", blogService.findByName(pageable, name));
        return "blog/index";
    }

}
