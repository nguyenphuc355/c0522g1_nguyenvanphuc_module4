package customer_management.controller;

import customer_management.model.Customer;
import customer_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/")
    public ModelAndView listCustomer() {
        List<Customer> customerList = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("customer", customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/createCustomer")
    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "successful new creation");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/editCustomer")
    public String update(Customer customer) {
        customerService.update(customer);
        return "redirect:/";
    }
    @GetMapping("view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }
    @GetMapping("delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }
}
