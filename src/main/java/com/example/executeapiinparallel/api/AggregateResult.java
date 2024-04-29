package com.example.executeapiinparallel.api;

import com.example.executeapiinparallel.api.orders.CreateOrderResponse;
import com.example.executeapiinparallel.api.products.CreateProductResponse;
import com.example.executeapiinparallel.api.users.CreateUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class AggregateResult {
  CreateUserResponse createUserResponse;
  CreateProductResponse createProductResponse;
  CreateOrderResponse createOrderResponse;
}
