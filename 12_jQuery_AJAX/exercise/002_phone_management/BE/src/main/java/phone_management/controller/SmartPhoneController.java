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
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhone, HttpStatus.OK);
    }


    @PatchMapping("/update/{id}")
    public ResponseEntity<SmartPhone> updatePhone(@PathVariable int id,
                                             @RequestBody SmartPhone phone) {
        SmartPhone newPhone = smartPhoneService.findById(id);
        if (newPhone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        newPhone.setModel(phone.getModel());
        newPhone.setPrice(phone.getPrice());
        newPhone.setProducer(phone.getProducer());
        smartPhoneService.save(newPhone);
        return new ResponseEntity<>(newPhone, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable int id) {
        SmartPhone smartphoneOptional = smartPhoneService.findById(id);
        if (smartphoneOptional == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional, HttpStatus.OK);
    }
}
