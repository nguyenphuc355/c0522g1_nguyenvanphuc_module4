package product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_management.model.Product;
import product_management.service.IProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;


    @GetMapping({"/index", "/"})
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";

    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess", "create success!!");
        return "redirect:/index";
    }

    @GetMapping("delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/index";
    }

    @GetMapping("view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/index";
    }

    @GetMapping("nameSearch")
    public ModelAndView search(@RequestParam String name) {
        return new ModelAndView("index", "productList", productService.findByName(name));
    }
}
