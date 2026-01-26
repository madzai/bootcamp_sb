package com.bootcamp.demo.demo_weather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;
import com.bootcamp.demo.demo_weather.service.NineDayWeatherService;
import com.bootcamp.demo.demo_weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
  @Autowired
  private NineDayWeatherService nineDayWeatherService;
  
  @Override
  public WeatherDTO getWeather(DataType dataType, Lang lang) {
    return switch (dataType) {
      case NINE_DAY -> this.nineDayWeatherService.getWeather(lang); // return NineDayDTO
    };
  }
}
