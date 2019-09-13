package com.solstice.restfulapi.models;

import java.awt.image.BufferedImage;
import java.sql.Date;

public class Contact extends BaseModel {
    private String name;
    private String company;
    private BufferedImage profileImage;
    private String email;
    private Date birthday;
    private Long workNumber;
    private Long personalNumber;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BufferedImage getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(BufferedImage profileImage) {
        this.profileImage = profileImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(Long workNumber) {
        this.workNumber = workNumber;
    }

    public Long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Long personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
