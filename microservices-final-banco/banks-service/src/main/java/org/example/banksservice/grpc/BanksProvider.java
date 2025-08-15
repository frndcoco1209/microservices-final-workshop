package org.example.banksservice.grpc;

import io.grpc.stub.StreamObserver;
import org.example.banksservice.repository.IBanksRepository;
import org.springframework.grpc.server.service.GrpcService;
import reactor.core.publisher.Mono;

@GrpcService
public class BanksProvider extends BankServiceGrpc.BankServiceImplBase{
    private final IBanksRepository repository;

    public BanksProvider(IBanksRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getBank(BankRequest request, StreamObserver<BankResponse> responseObserver) {
        repository.findById(request.getBankId())
                .switchIfEmpty(Mono.error(new RuntimeException("Bank not found")))
                .subscribe(bank -> {
                    BankResponse response = BankResponse
                            .newBuilder()
                            .setId(bank.getId())
                            .setName(bank.getName())
                            .setCountry(bank.getCountry())
                            .setAddress(bank.getAddress())
                            .setPhone(bank.getPhone())
                            .build();

                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }, responseObserver::onError).dispose();
    }
}