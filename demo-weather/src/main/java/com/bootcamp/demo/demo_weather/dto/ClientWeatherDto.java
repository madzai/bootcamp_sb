package com.bootcamp.demo.demo_weather.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

// sorting ascending date

@Getter
@Builder
public class ClientWeatherDto {
  private LocalDate forecastDate; // JSON -> String (Serialization)
  private Double maxTemp;
  private Double minTemp;
  private Double maxRh;
  private Double minRh;
  private String description;
}

// ! Everytime you call weatherAPI, store the records into database.
