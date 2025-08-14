package org.example.accountservice.dto;

public class AddBankDTO {
    private Long bankId;
    private Integer phone;

    public AddBankDTO() {
    }

    public AddBankDTO(Long bankId, Integer phone) {
        this.bankId = bankId;
        this.phone = phone;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Long getBankId() {
        return bankId;
    }

    public Integer getPhone() {
        return phone;
    }
}
