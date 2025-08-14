package org.example.accountservice.service;

import org.example.accountservice.dto.GetBankDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BankService {
    private final WebClient.Builder webClientBuilder;

    @Value("${banks-service.url}")
    private String banksServiceUrl;

    public BankService(final WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<GetBankDTO> getBank(Long bankId) {
        return webClientBuilder
                .build()
                .get()
                .uri(banksServiceUrl + "/" + bankId)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> {
                    System.err.println("Banco no encontrado (404): " + bankId);
                    return Mono.error(new RuntimeException("bank does not exist"));
                })
                .onStatus(HttpStatusCode::is5xxServerError, response -> {
                    System.err.println("Error del servicio de bancos (5xx)");
                    return Mono.error(new RuntimeException("bank service error"));
                })
                .bodyToMono(GetBankDTO.class);
    }
}
