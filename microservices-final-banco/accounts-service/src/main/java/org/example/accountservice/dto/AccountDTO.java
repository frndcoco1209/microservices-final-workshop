package org.example.accountservice.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AccountDTO {
    private Long accountId;
    private String accountNumber;
    private String accountHolder;
    private String accountType;
    private LocalDateTime createdDate;
    private List<BankDTO> banks;

    public AccountDTO() {
    }

    public AccountDTO(Long accountId, String accountNumber, String accountHolder, String accountType, LocalDateTime createdDate, List<BankDTO> banks) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.createdDate = createdDate;
        this.banks = banks;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setBanks(List<BankDTO> banks) {
        this.banks = banks;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountType() {
        return accountType;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public List<BankDTO> getBanks() {
        return banks;
    }
}
