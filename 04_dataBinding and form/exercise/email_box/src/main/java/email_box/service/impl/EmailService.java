package email_box.service.impl;

import email_box.model.Email;
import email_box.service.IEmailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService {
    private static List<Email> emailList;

    static {
        emailList = new ArrayList<>();
        emailList.add(new Email(1, "vietnamese", 5, true, "no"));
    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public Email findById(int id) {
        for (Email email : emailList) {
            if (email.getId() == id) {
                return email;
            }
        }
        return null;
    }

    @Override
    public void update(Email email) {
        for (Email email1 : emailList) {
            if (email.getId() == email1.getId()) {
                emailList.remove(email1);
                emailList.add(email);
            }
        }
    }

    @Override
    public List<String> languages() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("japanese");
        languageList.add("chinese");
        return languageList;
    }

    @Override
    public List<Integer> pageSize() {
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        return pageSizeList;
    }
}
