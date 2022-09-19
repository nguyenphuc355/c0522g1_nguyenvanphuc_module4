package com.example.blog_app.controller;

import com.example.blog_app.model.BlogApp;
import com.example.blog_app.model.Category;
import com.example.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String viewCategory(Model model) {
        model.addAttribute("cateGoryList", categoryService.findAll());
        return "category/category";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("cateGoryList", categoryService.findAll());
        model.addAttribute("category", new Category());
        return "category/create";

    }
    @PostMapping("/save")
    public String saveProduct(Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "create success!!");
        return "redirect:/category";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public String update(Category category){
        categoryService.update(category);
        return "redirect:/category";
    }

    @GetMapping("delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/delete";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirect) {
        categoryService.remove(category.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/category";
    }


}
