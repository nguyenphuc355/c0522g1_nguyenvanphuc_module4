package abc.controller;

import abc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import abc.serrvice.ICustomerService;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/")
    public ModelAndView showList() {
        return new ModelAndView("/customer/list","customers",customerService.findAll()) ;
    }
}
