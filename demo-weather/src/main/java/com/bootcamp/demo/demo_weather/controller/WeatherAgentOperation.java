package com.bootcamp.demo.demo_weather.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_weather.entity.NineDayEntity;

// ! Database Retrieval (select)

public interface WeatherAgentOperation {
  @GetMapping(value = "/weather/agent/forecastdate")
  public List<NineDayEntity> getWeather(@RequestParam LocalDate date);

  @GetMapping(value = "/weather/agent/trandate")
  public List<NineDayEntity> getWeatherBetween(
      @RequestParam LocalDate startDate, @RequestParam LocalDate endDate);

  @GetMapping(value = "/weather/agent/maxtemp")
  public List<NineDayEntity> getWeatherMaxTemp(@RequestParam Double temp);

  @GetMapping(value = "/weather/agent/mintemp")
  public List<NineDayEntity> getWeatherMinTemp(@RequestParam Double temp);
}
