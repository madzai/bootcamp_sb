package com.bootcamp.demo.demo_weather.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.bootcamp.demo.demo_weather.entity.NineDayEntity;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;

public interface WeatherService {
  WeatherDTO getWeather(DataType dataType, Lang lang);

  List<NineDayEntity> getByForecastDate(LocalDate forecastDate);

  List<NineDayEntity> getByTranTime(LocalDateTime startDateTime,
      LocalDateTime endDateTime);

  List<NineDayEntity> findByMaxTempJPQL(Double degree);

  List<NineDayEntity> findByMinTempJPQL(Double degree);

}
