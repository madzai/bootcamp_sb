package com.bootcamp.demo.demo_weather.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO.ForecastDTO.ValueDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NineDayDTO implements WeatherDTO {
  private String generalSituation;
  @JsonProperty(value = "weatherForecast")
  private List<ForecastDTO> forecasts;
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "Asia/Hong_Kong")
  private LocalDateTime updateTime;
  private ValueDTO2 seaTemp;
  private List<ValueDTO2> soilTemp;

  @Getter
  public static class ValueDTO2 {
    private String place;
    private Double value;
    private String unit;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "Asia/Hong_Kong")
    private LocalDateTime recordTime;
    private ValueDTO depth;
  }

  @Getter
  public static class ForecastDTO {
    // "20260125" -> LocalDate
    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate forecastDate;
    private String week;
    @JsonProperty(value = "forecastWind")
    private String wind;
    @JsonProperty(value = "forecastWeather")
    private String weatherDesc;
    @JsonProperty(value = "forecastMaxtemp")
    private ValueDTO maxTemp;
    @JsonProperty(value = "forecastMintemp")
    private ValueDTO minTemp;
    @JsonProperty(value = "forecastMaxrh")
    private ValueDTO maxRh;
    @JsonProperty(value = "forecastMinrh")
    private ValueDTO minRh;

    @Getter
    public static class ValueDTO {
      private Double value;
      private String unit;
    }
  }
}
