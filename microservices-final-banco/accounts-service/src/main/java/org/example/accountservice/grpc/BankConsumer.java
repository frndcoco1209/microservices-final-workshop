package org.example.accountservice.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.accountservice.dto.GetBankDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BankConsumer {
    @Value("${grpc.server.host}")
    private  String grpcHost;
    @Value("${grpc.server.port}")
    private  Integer grpcPort;
    private ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
    private BankServiceGrpc.BankServiceBlockingStub stub = BankServiceGrpc.newBlockingStub(channel);

    public Mono<GetBankDTO> getBank(Long bankId) {
        BankRequest request = BankRequest.newBuilder().setBankId(bankId).build();
        BankResponse response = stub.getBank(request);
        GetBankDTO dto = new GetBankDTO(response.getId(), response.getName(), response.getCountry(), response.getAddress(), response.getPhone());
        return Mono.just(dto);
    }

}
