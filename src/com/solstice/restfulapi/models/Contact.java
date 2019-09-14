package com.solstice.restfulapi.models;

import javax.ws.rs.BeanParam;
import javax.ws.rs.QueryParam;
import java.awt.image.BufferedImage;
import java.sql.Date;
import java.util.Objects;

public class Contact extends BaseModel {

    @QueryParam("name")
    private String name;
    @QueryParam("company")
    private String company;
    private BufferedImage profileImage;
    @QueryParam("email")
    private String email;
    @QueryParam("birthday")
    private Date birthday;
    @QueryParam("workNumber")
    private Long workNumber;
    @QueryParam("personalNumber")
    private Long personalNumber;
    @BeanParam
    private Address address;

    public Contact() {
    }

    public Contact(String name, String company, BufferedImage profileImage, String email, Date birthday, Long workNumber, Long personalNumber, Address address) {
        this.name = name;
        this.company = company;
        this.profileImage = profileImage;
        this.email = email;
        this.birthday = birthday;
        this.workNumber = workNumber;
        this.personalNumber = personalNumber;
        this.address = address;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return getName().equals(contact.getName()) &&
                getCompany().equals(contact.getCompany()) &&
                Objects.equals(getProfileImage(), contact.getProfileImage()) &&
                getEmail().equals(contact.getEmail()) &&
                getBirthday().equals(contact.getBirthday()) &&
                getWorkNumber().equals(contact.getWorkNumber()) &&
                getPersonalNumber().equals(contact.getPersonalNumber()) &&
                getAddress().equals(contact.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCompany(), getProfileImage(), getEmail(), getBirthday(), getWorkNumber(), getPersonalNumber(), getAddress());
    }
}
