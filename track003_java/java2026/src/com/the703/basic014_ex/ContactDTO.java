package com.the703.basic014_ex;

public class ContactDTO {
    private String name;
    private String phone;

    public ContactDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return name + " | " + phone;
    }
}
