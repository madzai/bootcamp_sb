package com.bootcamp.demo.demo_external_api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

// ! Data Transfer Object
@Getter
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private AddressDTO address;
  private String phone;
  private String website;
  private CompanyDTO company;

  @Getter
  public static class CompanyDTO {
    private String name;
    private String catchPhrase;
    private String bs;
  }

  @Getter
  public static class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;

    @Getter
    public static class GeoDTO {
      @JsonProperty(value = "lat")
      private String latitude;
      @JsonProperty(value = "lng")
      private String longitude;
    }
  }
}
