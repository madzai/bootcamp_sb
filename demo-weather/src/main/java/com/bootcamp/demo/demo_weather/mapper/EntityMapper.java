package com.bootcamp.demo.demo_weather.mapper;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_weather.entity.NineDayEntity;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO;

@Component
public class EntityMapper {
  public NineDayEntity map(NineDayDTO.ForecastDTO forecastDTO) {
    return NineDayEntity.builder() //
        .forecastDate(forecastDTO.getForecastDate()) //
        .maxTemp(BigDecimal.valueOf(forecastDTO.getMaxTemp().getValue())) //
        .minTemp(BigDecimal.valueOf(forecastDTO.getMaxTemp().getValue())) //
        .maxRh(BigDecimal.valueOf(forecastDTO.getMaxRh().getValue())) //
        .minRh(BigDecimal.valueOf(forecastDTO.getMinRh().getValue())) //
        .description(forecastDTO.getWeatherDesc()) //
        .build();
  }
}
