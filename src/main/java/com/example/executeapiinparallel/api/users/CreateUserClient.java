package com.example.executeapiinparallel.api.users;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CreateUserClient {
  WebClient webClient;

  public CreateUserClient() {
    this.webClient = WebClient.builder().baseUrl("http://localhost:4010").build();
  }

  public Mono<CreateUserResponse> execute(CreateUserRequest request) {
    return this.webClient
        .post()
        .uri("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(request)
        .retrieve()
        .bodyToMono(CreateUserResponse.class);
  }
}
