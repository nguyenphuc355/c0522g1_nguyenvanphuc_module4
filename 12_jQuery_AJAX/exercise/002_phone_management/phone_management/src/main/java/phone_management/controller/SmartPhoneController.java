package phone_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import phone_management.model.SmartPhone;
import phone_management.service.ISmartPhoneService;

import java.util.List;

@Controller
@RequestMapping("/smartPhone")
@CrossOrigin("*")
public class SmartPhoneController {
    @Autowired
    private ISmartPhoneService smartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SmartPhone>> showListSmartPhone() {
        List<SmartPhone> smartPhones = smartPhoneService.findAll();
        if (smartPhones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SmartPhone> findBlogAppById(@PathVariable int id) {
        SmartPhone smartPhone = smartPhoneService.findById(id);
        if (smartPhone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartPhone, HttpStatus.OK);
    }


    @PatchMapping("/update")
    public ResponseEntity<SmartPhone> updateSmartPhone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.OK);

    }
}
