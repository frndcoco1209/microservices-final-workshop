package org.example.accountservice.service;

import org.example.accountservice.dto.AccountDTO;
import org.example.accountservice.dto.AddBankDTO;
import org.example.accountservice.dto.BankDTO;
import org.example.accountservice.model.Account;
import org.example.accountservice.model.Bank;
import org.example.accountservice.repository.IAccountRepository;
import org.example.accountservice.repository.IBankRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class AccountService {
    private final IBankRepository bankRepository;
    private final IAccountRepository accountRepository;
    private final BankService bankService;

    public AccountService(IBankRepository bankRepository, IAccountRepository accountRepository, BankService bankService) {
        this.bankRepository = bankRepository;
        this.accountRepository = accountRepository;
        this.bankService = bankService;
    }

    public Mono<Account> create(String number, String holder, String type, Integer balance) {
        return this.accountRepository.save(new Account(null, number, holder, type, balance, LocalDateTime.now()));

    }

    public Mono<AccountDTO> addAccount (AddBankDTO addBankDTO, String account_number){
        return bankService.getBank(addBankDTO.getBankId())
                .flatMap(bank -> {
                    if (bank.getPhone() == null || addBankDTO.getPhone() == null) {
                        return Mono.error(new RuntimeException("faltan datos del banco"));
                    }

                    return accountRepository.findByAccountNumber(account_number)
                .flatMap(account ->
                bankRepository
                .save(new Bank(null, bank.getName(), bank.getCountry(), bank.getAddress(), addBankDTO.getPhone(), account.getId()))
                .flatMap(newBank -> bankRepository
                        .findAllByAccountId(account.getId())
                        .map(ban -> new BankDTO(ban.getId(), ban.getName(), ban.getCountry()))
                        .collectList()
                        .map(banks -> new AccountDTO(account.getId(), account.getAccountNumber(),
                        account.getAccountHolder(), account.getAccountType(), account.getCreatedAt(), banks)))
                );
    })
            .onErrorResume(error -> Mono.error(new RuntimeException(error.getMessage())));

    }
}
