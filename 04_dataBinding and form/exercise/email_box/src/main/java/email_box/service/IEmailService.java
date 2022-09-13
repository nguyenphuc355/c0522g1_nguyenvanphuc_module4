package email_box.service;

import email_box.model.Email;

import java.util.List;

public interface IEmailService {

    List<Email> findAll();

    Email findById(int id);

    void update(Email email);

    List<String> languages();

    List<Integer> pageSize();


}
