package phone_management.service;

import phone_management.model.SmartPhone;

import java.util.List;

public interface ISmartPhoneService {
    List<SmartPhone> findAll();

    SmartPhone findById(int id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(int id);
}
