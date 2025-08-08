package org.example.banksservice.service;

import org.example.banksservice.model.Bank;
import org.example.banksservice.repository.IBanksRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BanksService {
    private final IBanksRepository repository;

    public BanksService(IBanksRepository repository) {
        this.repository = repository;
    }

    public Flux<Bank> getAll() {
        return repository.findAll();
    }

    public Mono<Bank> getById(Long BankId) {
        return repository
                .findById(BankId)
                .switchIfEmpty(Mono.error(new RuntimeException("Bank not found")));
    }
}
