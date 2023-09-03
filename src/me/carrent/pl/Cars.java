package me.carrent.pl;

public class Cars{

    String mark;
    String model;
    String registrationNumber;
    int yearOfProduction;
    double volume;
    String petrolType;
    int horsePower;


public Cars(String mark, String model, String registrationNumber, int yearOfProduction, double volume, String petrolType, int horsePower){
    this.mark = mark;
    this.model = model;
    this.registrationNumber = registrationNumber;
    this.yearOfProduction = yearOfProduction;
    this.volume = volume;
    this.petrolType = petrolType;
    this.horsePower = horsePower;


    }
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getYearOfProduction() {
        return Integer.parseInt(String.valueOf(yearOfProduction));
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getPetrolType() {
        return petrolType;
    }

    public void setPetrolType(String petrolType) {
        this.petrolType = petrolType;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return mark+" "+model+" "+volume+" "+petrolType+" "+horsePower+"km "+yearOfProduction+" "+registrationNumber;
    }


}
