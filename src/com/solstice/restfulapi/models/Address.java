package com.solstice.restfulapi.models;

public class Address {
    private String block;
    private String street;

    public Address(String block, String street) {
        this.block = block;
        this.street = street;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
