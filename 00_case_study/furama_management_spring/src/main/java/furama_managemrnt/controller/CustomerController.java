package furama_managemrnt.controller;

import furama_managemrnt.dto.CustomerDto;
import furama_managemrnt.model.Customer;
import furama_managemrnt.repository.ICustomerTypeRepository;
import furama_managemrnt.serrvice.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

//    @GetMapping("")
//    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model) {
//        model.addAttribute("customerTypeList", customerTypeRepository.findAll());
//        model.addAttribute("customerList", customerService.findAll(pageable));
//        return "customer/index";
//    }


    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customerTypeList", customerTypeRepository.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";

    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", customerTypeRepository.findAll());
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "create success!!");
        return "redirect:/customer";
    }

    @GetMapping("delete/{id}")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("customerList", customerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/customer";
    }

    @GetMapping("view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/view";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customerList", customerService.findById(id));
        model.addAttribute("customerTypeList", customerTypeRepository.findAll());
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.update(customer);
        return "redirect:/customer";
    }

    @GetMapping("")
    public String search(@RequestParam(value = "name", defaultValue = "") String name,
                         @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
                         @RequestParam(value = "address", defaultValue = "") String address,
                         @PageableDefault(value = 5) Pageable pageable, Model model) {
        model.addAttribute("customerType", customerTypeRepository.findAll());
        model.addAttribute("customer", customerService.findByName(pageable, name, phoneNumber, address));
        model.addAttribute("name", name);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("address", address);
        return "customer/index";
    }
}
