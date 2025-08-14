package org.example.accountservice.dto;

public class BankDTO {
    private Long bank_Id;
    private String name;
    private String country;

    public BankDTO() {
    }

    public BankDTO(Long bank_Id, String name, String country) {
        this.bank_Id = bank_Id;
        this.name = name;
        this.country = country;
    }

    public void setBank_Id(Long bank_Id) {
        this.bank_Id = bank_Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getBank_Id() {
        return bank_Id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
