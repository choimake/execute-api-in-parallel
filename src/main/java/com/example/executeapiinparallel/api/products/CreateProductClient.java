package com.example.executeapiinparallel.api.products;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CreateProductClient {
  WebClient webClient;

  public CreateProductClient() {
    this.webClient = WebClient.builder().baseUrl("http://localhost:4010").build();
  }

  public Mono<CreateProductResponse> execute(CreateProductRequest request) {
    return this.webClient
        .post()
        .uri("/products")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(request)
        .retrieve()
        .bodyToMono(CreateProductResponse.class);
  }
}
