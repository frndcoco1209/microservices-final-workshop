package org.example.banksservice.controller;

import org.example.banksservice.model.Bank;
import org.example.banksservice.service.BanksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/banks")
public class BanksController {
    private final BanksService service;

    public BanksController(BanksService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Bank> getAll() {
        return service.getAll();
    }

    @GetMapping("/{BankId}")
    public Mono<Bank> getById(@PathVariable Long BankId) {
        return service.getById(BankId);
    }
}
