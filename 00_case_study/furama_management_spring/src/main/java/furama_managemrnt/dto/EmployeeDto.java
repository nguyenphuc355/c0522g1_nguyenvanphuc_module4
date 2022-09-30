package furama_managemrnt.dto;


import furama_managemrnt.model.Division;
import furama_managemrnt.model.EducationDegree;
import furama_managemrnt.model.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EmployeeDto {

    private int id;

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "tên phải đúng định dạng, không chứa kí tự đặc biệt")
    private String name;

    @NotBlank(message = "không được trống")
    private String dateOfBirth;

    @NotBlank(message = "không được trống")
    private String idCard;

    @NotBlank(message = "không được trống")
    private String salary;

    @NotBlank(message = "không được trống")
    @Pattern(regexp = "^((\\(\\+84\\-\\))|0)(90|91)[0-9]{7}$",message = "nhập đúng định dạng 0xxxxxxxxx")
    private String phoneNumber;

    @NotBlank(message = "không được trống")
    @Email(message = "nhập đúng định dạng xxxx@.xxx")
    private String email;

    @NotBlank(message = "không được trống")
    @Pattern(regexp = "^([\\p{Lu}/,-][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "tên phải đúng định dạng, không chứa kí tự đặc biệt")
    private String address;

    private Division division;
    private EducationDegree educationDegree;
    private Position position;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, String name, String dateOfBirth, String idCard, String salary, String phoneNumber, String email, String address, Division division, EducationDegree educationDegree, Position position) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.division = division;
        this.educationDegree = educationDegree;
        this.position = position;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
