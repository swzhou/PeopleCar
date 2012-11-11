package com.peoplecar.dto;

import com.peoplecar.domain.Driver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverDto implements IDto<Driver> {

    private String name;

    private Gender gender;

    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Driver toModel() {
        Driver driver = null;
        try {
            boolean gender = this.gender == Gender.male;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date birthdayDate = format.parse(birthday);
            driver = new Driver(name, gender, birthdayDate);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return driver;
        }
    }

    public static DriverDto fromModel(Driver driver) {
        DriverDto driverDto = new DriverDto();
        driverDto.setName(driver.getName());
        driverDto.setBirthday(driver.getBirthday().toString());
        driverDto.setGender(driver.getGender() ? Gender.male : Gender.female);
        return driverDto;
    }
}
