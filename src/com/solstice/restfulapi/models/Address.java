package com.solstice.restfulapi.models;

import java.util.Objects;

public class Address {
    private Long block;
    private String street;
    private String city;
    private String state;

    public Address() {
    }

    public Address(Long block, String street, String city, String state) {
        this.block = block;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public Long getBlock() {
        return block;
    }

    public void setBlock(Long block) {
        this.block = block;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getBlock().equals(address.getBlock()) &&
                getStreet().equals(address.getStreet()) &&
                getCity().equals(address.getCity()) &&
                getState().equals(address.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBlock(), getStreet(), getCity(), getState());
    }
}
