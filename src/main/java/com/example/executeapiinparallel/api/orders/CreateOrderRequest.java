package com.example.executeapiinparallel.api.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateOrderRequest {

  private Integer userId;
  private Integer productId;
  private Integer quantity;
}
