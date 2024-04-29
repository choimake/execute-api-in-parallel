package com.example.executeapiinparallel.api.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateUserResponse {

  private Integer id;
  private String name;
  private String email;

}
