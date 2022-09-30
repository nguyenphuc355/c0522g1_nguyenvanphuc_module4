package furama_managemrnt.dto;

import furama_managemrnt.model.CustomerType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class CustomerDto {

    private int id;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "tên phải đúng định dạng, không chứa kí tự đặc biệt")
    private String name;

    @NotBlank(message = "không được trống")
    private String dateOfBirth;


    private int gender;

    @NotBlank(message = "không được trống")
    private String idCard;

    @NotBlank(message = "không được trống")
    @Pattern(regexp = "^((\\(\\+84\\-\\))|0)(90|91)[0-9]{7}$",message = "nhập đúng định dạng 0xxxxxxxxx")
    private String phoneNumber;

    @NotBlank(message = "không được trống")
    @Email(message = "nhập đúng định dạng xxxx@.xxx")
    private String email;

    @NotBlank(message = "không được trống")
    @Pattern(regexp = "^([\\p{Lu}/,-][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "tên phải đúng định dạng, không chứa kí tự đặc biệt")
    private String address;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String dateOfBirth,
                       int gender, String idCard, String phoneNumber,
                       String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
