package org.example.accountservice.controller;

import org.example.accountservice.dto.AccountDTO;
import org.example.accountservice.dto.AddBankDTO;
import org.example.accountservice.model.Account;
import org.example.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<Account> create(@RequestBody AccountDTO accountDTO) {
        return service.create(accountDTO.getAccountNumber(), accountDTO.getAccountHolder(), accountDTO.getAccountType(), 0);
    }

    @PostMapping("/{accountNumber}/banks")
    public Mono<AccountDTO> addBank(@PathVariable("accountNumber") String accountNumber, @RequestBody AddBankDTO addBankDTO) {
        return service.addAccount(addBankDTO, accountNumber);
    }
}
