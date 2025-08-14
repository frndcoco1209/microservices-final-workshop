package org.example.accountservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Table("accounts")
public class Account {
    @Id
    @Column("account_id")
    private Long id;
    @Column("account_number")
    private String accountNumber;
    @Column("account_holder")
    private String accountHolder;
    @Column("account_type")
    private String accountType;
    @Column("balance")
    private Integer balance;
    @Column("created_at")
    private LocalDateTime createdAt;

    public Account() {
    }

    public Account(Long id, String accountNumber, String accountHolder, String accountType, Integer balance, LocalDateTime createdAt) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
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

    public Integer getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
