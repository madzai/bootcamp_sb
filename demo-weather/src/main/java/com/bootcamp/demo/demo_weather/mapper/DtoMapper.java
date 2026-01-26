package com.bootcamp.demo.demo_weather.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_weather.dto.ClientWeatherDto;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO;

@Component
public class DtoMapper {
  // TBC. NumberFormatException
  public ClientWeatherDto map(NineDayDTO.ForecastDTO forecastDTO) {
    return ClientWeatherDto.builder() //
        .forecastDate(forecastDTO.getForecastDate()) //
        .maxTemp(Double.valueOf(forecastDTO.getMaxTemp().getValue())) //
        .minTemp(Double.valueOf(forecastDTO.getMinTemp().getValue())) //
        .maxRh(Double.valueOf(forecastDTO.getMaxRh().getValue())) //
        .minRh(Double.valueOf(forecastDTO.getMinRh().getValue())) //
        .description(forecastDTO.getWeatherDesc()) //
        .build();
  }
}
