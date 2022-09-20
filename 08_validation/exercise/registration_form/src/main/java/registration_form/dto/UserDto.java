package registration_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {

    private int id;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String fistName;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "0\\d{9}", message = "Phải nhập đúng định dạng 0xxxxxxxxx")
    private String phoneNumber;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "1[8-9]|[2-7]\\d|80", message = "phải lớn hơn 18 tuổi")
    private String age;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "phải nhập đúng định dạng xxxx@xxx.xxx")
    private String email;


    public UserDto() {
    }

    public UserDto(int id, String fistName, String lastName, String phoneNumber, String age, String email) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if ("admin".equals(userDto.getFistName())) {
            errors.rejectValue("fistName", "", "không được dùng admin");
        }
    }
}
