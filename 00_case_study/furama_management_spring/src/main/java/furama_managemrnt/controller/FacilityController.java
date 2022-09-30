package furama_managemrnt.controller;

import furama_managemrnt.dto.EmployeeDto;
import furama_managemrnt.dto.FacilityDto;
import furama_managemrnt.model.Employee;
import furama_managemrnt.model.Facility;
import furama_managemrnt.serrvice.IFacilityService;
import furama_managemrnt.serrvice.IFacilityTypeService;
import furama_managemrnt.serrvice.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String showListFacility(@PageableDefault(value = 5) Pageable pageable,Model model) {
        model.addAttribute("facilityList", facilityService.findAll(pageable));
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility/create";

    }

    @PostMapping("/save")
    public String saveFacility(Facility facility,
                               RedirectAttributes redirectAttributes, Model model) {
//        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("divisionList", divisionService.findAll());
//            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
//            model.addAttribute("positionList", positionService.findAll());
//            return "employee/create";
//        }
//        Employee employee = new Employee();
//        BeanUtils.copyProperties(employeeDto, employee);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "create success!!");
        return "redirect:/facility";
    }
}