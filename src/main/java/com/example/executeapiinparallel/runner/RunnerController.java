package com.example.executeapiinparallel.runner;

import com.example.executeapiinparallel.api.AggregateResult;
import com.example.executeapiinparallel.api.orders.CreateOrderClient;
import com.example.executeapiinparallel.api.orders.CreateOrderRequest;
import com.example.executeapiinparallel.api.orders.CreateOrderResponse;
import com.example.executeapiinparallel.api.products.CreateProductClient;
import com.example.executeapiinparallel.api.products.CreateProductRequest;
import com.example.executeapiinparallel.api.products.CreateProductResponse;
import com.example.executeapiinparallel.api.users.CreateUserClient;
import com.example.executeapiinparallel.api.users.CreateUserRequest;
import com.example.executeapiinparallel.api.users.CreateUserResponse;
import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RunnerController implements ApplicationRunner {

  CreateUserClient createUserClient;
  CreateProductClient createProductClient;
  CreateOrderClient createOrderClient;

  public RunnerController(
      CreateUserClient createUserClient,
      CreateProductClient createProductClient,
      CreateOrderClient createOrderClient) {
    this.createUserClient = createUserClient;
    this.createProductClient = createProductClient;
    this.createOrderClient = createOrderClient;
  }

  @Override
  public void run(ApplicationArguments args) {

    var createUserRequest = new CreateUserRequest();
    createUserRequest.setName("name");
    createUserRequest.setEmail("email");

    var createUserResponse = createUserClient.execute(createUserRequest);

    var createProductRequest = new CreateProductRequest();
    createProductRequest.setName("name");
    createProductRequest.setDescription("description");
    createProductRequest.setPrice(10);

    var createProductResponse = createProductClient.execute(createProductRequest);

    var createOrderRequest = new CreateOrderRequest();
    createOrderRequest.setUserId(1);
    createOrderRequest.setProductId(2);
    createOrderRequest.setQuantity(3);

    var createOrderResponse = createOrderClient.execute(createOrderRequest);

    var apiResponses =
        Arrays.asList(createUserResponse, createProductResponse, createOrderResponse);

    var aggregateResultMono =
        Mono.zip(
            apiResponses,
            responses -> {
              var userResponse = (CreateUserResponse) responses[0];
              var productResponse = (CreateProductResponse) responses[1];
              var orderResponse = (CreateOrderResponse) responses[2];

              return new AggregateResult(userResponse, productResponse, orderResponse);
            });

    // 全APIを実行
    var aggregateResult = aggregateResultMono.block();
    // 結果を表示
    System.out.println(aggregateResult);
  }
}
