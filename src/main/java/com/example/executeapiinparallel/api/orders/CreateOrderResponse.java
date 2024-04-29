package com.example.executeapiinparallel.api.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateOrderResponse {

  private Integer id;
  private Integer productId;
  private Integer quantity;
}
