package com.bootcamp.demo.demo_weather.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_weather.entity.NineDayEntity;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;
import com.bootcamp.demo.demo_weather.repository.NineDayRepository;
import com.bootcamp.demo.demo_weather.service.NineDayWeatherService;
import com.bootcamp.demo.demo_weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
  @Autowired
  private NineDayWeatherService nineDayWeatherService;

  @Autowired
  private NineDayRepository nineDayRepository;

  @Override
  public WeatherDTO getWeather(DataType dataType, Lang lang) {
    return switch (dataType) {
      case NINE_DAY -> this.nineDayWeatherService.getWeather(lang); // return NineDayDTO
    };
  }

  @Override
  public List<NineDayEntity> getByForecastDate(LocalDate forecastDate) {
    return this.nineDayRepository.findByForecastDate(forecastDate);
  }

  @Override
  public List<NineDayEntity> getByTranTime(LocalDateTime startDateTime,
      LocalDateTime endDateTime) {
    return this.nineDayRepository.findByTranTimeBetween(startDateTime,
        endDateTime);
  }

  @Override
  public List<NineDayEntity> findByMaxTempJPQL(Double degree) {
    return this.nineDayRepository.findByMaxTempJPQL(degree);
  }

  @Override
  public List<NineDayEntity> findByMinTempJPQL(Double degree) {
    return this.nineDayRepository.findByMinTempJPQL(degree);
  }
}
