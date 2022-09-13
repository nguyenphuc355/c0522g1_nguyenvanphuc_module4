package medical_declaration.controller;

import medical_declaration.model.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MedicalDeclarationController {
    @GetMapping("/")
    public String showDeclaration(Model model) {
        List<String> birthdayList = new ArrayList<>();
        List<String> countryList = new ArrayList<>();
        List<String> genderList = new ArrayList<>();
        List<String> travelList = new ArrayList<>();

        travelList.add("máy bay");
        travelList.add("tàu thuyền");
        travelList.add("ô tô");
        travelList.add("khác");

        genderList.add("nam");
        genderList.add("Nữ");
        genderList.add("LGBT");

        birthdayList.add("1990");
        birthdayList.add("1991");
        birthdayList.add("1992");
        birthdayList.add("1993");
        birthdayList.add("1994");
        birthdayList.add("1995");
        birthdayList.add("1996");
        birthdayList.add("1997");
        birthdayList.add("1998");
        birthdayList.add("1999");

        countryList.add("Việt Nam");
        countryList.add("Lào ");
        countryList.add("Thái Lan");

        model.addAttribute("travelList",travelList);
        model.addAttribute("genderList",genderList);
        model.addAttribute("countryList", countryList);
        model.addAttribute("birthdayList", birthdayList);
        model.addAttribute("declaration", new MedicalDeclaration());
        return "index";
    }

    @PostMapping("/info")
    public String submitDeclaration(@ModelAttribute("declaration") MedicalDeclaration medicalDeclaration, ModelMap modelMap) {
        modelMap.addAttribute("name", medicalDeclaration.getName());
        modelMap.addAttribute("birthDay", medicalDeclaration.getBirthDay());
        modelMap.addAttribute("gender", medicalDeclaration.getGender());
        modelMap.addAttribute("country", medicalDeclaration.getCountry());
        modelMap.addAttribute("passport", medicalDeclaration.getPassport());
        modelMap.addAttribute("travel", medicalDeclaration.getTravel());
        modelMap.addAttribute("vehicleNumber", medicalDeclaration.getVehicleNumber());
        modelMap.addAttribute("seatNumber", medicalDeclaration.getSeatNumber());
        modelMap.addAttribute("startDay", medicalDeclaration.getStartDay());
        modelMap.addAttribute("endDay", medicalDeclaration.getEndDay());
        modelMap.addAttribute("status", medicalDeclaration.getStatus());
        return "info";
    }
}
