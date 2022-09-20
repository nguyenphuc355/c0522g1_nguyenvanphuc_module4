package registration_form.service;

import org.springframework.stereotype.Service;
import registration_form.model.User;

import java.util.List;


public interface IUserService   {

    List<User> findAll();

    void save(User user);
}
