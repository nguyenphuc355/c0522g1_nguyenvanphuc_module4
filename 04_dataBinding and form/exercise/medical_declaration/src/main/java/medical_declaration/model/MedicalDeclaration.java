package medical_declaration.model;

public class MedicalDeclaration {
    private String name;
    private String birthDay;
    private String gender;
    private String country;
    private String passport;
    private String travel;
    private int vehicleNumber;
    private int seatNumber;
    private String startDay;
    private String endDay;
    private String status;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String name, String birthDay, String gender, String country, String passport,
                              String travel, int vehicleNumber, int seatNumber, String startDay, String endDay,
                              String status) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.country = country;
        this.passport = passport;
        this.travel = travel;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.endDay = endDay;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
