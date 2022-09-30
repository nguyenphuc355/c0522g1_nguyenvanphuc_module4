package furama_managemrnt.dto;

import furama_managemrnt.model.FacilityType;
import furama_managemrnt.model.RenType;

public class FacilityDto {
    private int id;
    private String name;
    private String area;
    private String cost;
    private Integer maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String poolArea;
    private Integer numberOfFloors;
    private String facilityFree;
    private FacilityType facilityTypeS;
    private RenType renType;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, String area, String cost, Integer maxPeople, String standardRoom,
                       String descriptionOtherConvenience, String poolArea, Integer numberOfFloors,
                       String facilityFree, FacilityType facilityTypeS, RenType renType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.facilityTypeS = facilityTypeS;
        this.renType = renType;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityTypeS() {
        return facilityTypeS;
    }

    public void setFacilityTypeS(FacilityType facilityTypeS) {
        this.facilityTypeS = facilityTypeS;
    }

    public RenType getRenType() {
        return renType;
    }

    public void setRenType(RenType renType) {
        this.renType = renType;
    }
}
