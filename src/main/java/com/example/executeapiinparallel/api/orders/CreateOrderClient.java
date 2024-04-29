package com.example.executeapiinparallel.api.orders;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CreateOrderClient {
  WebClient webClient;

  public CreateOrderClient() {
    this.webClient = WebClient.builder().baseUrl("http://localhost:4010").build();
  }

  public Mono<CreateOrderResponse> execute(CreateOrderRequest request) {
    return this.webClient
        .post()
        .uri("/orders")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(request)
        .retrieve()
        .bodyToMono(CreateOrderResponse.class);
  }
}
