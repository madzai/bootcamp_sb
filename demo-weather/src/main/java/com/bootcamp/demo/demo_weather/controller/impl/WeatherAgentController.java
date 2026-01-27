package com.bootcamp.demo.demo_weather.controller.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_weather.controller.WeatherAgentOperation;
import com.bootcamp.demo.demo_weather.entity.NineDayEntity;
import com.bootcamp.demo.demo_weather.service.WeatherService;

@RestController
public class WeatherAgentController implements WeatherAgentOperation {
  @Autowired
  private WeatherService weatherService;

  @Override
  public List<NineDayEntity> getWeather(LocalDate date) {
    return this.weatherService.getByForecastDate(date);
  }

  @Override
  public List<NineDayEntity> getWeatherBetween(LocalDate startDate,
      LocalDate endDate) {
    return this.weatherService.getByTranTime(startDate.atStartOfDay(), // 00:00:00
        endDate.atTime(LocalTime.MAX)); // 23:59:59.9999999
  }

  @Override
  public List<NineDayEntity> getWeatherMaxTemp(Double temp) {
    return this.weatherService.findByMaxTempJPQL(temp);
  }

  @Override
  public List<NineDayEntity> getWeatherMinTemp(Double temp) {
    return this.weatherService.findByMinTempJPQL(temp);
  }
}
