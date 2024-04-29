package com.example.executeapiinparallel.api.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateProductResponse {

  private Integer id;
  private String name;
  private String email;
  private Integer price;

}
