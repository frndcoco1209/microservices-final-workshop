package org.example.banksservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("banks")
public class Bank {
 @Id
    private Long id;
    private String name;
    private String country;
    private String address;
    private Integer phone;

    public Bank(Long id, String name, String country, String address, Integer phone) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phone = phone;

    }

    public Bank() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
