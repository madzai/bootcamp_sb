package com.bootcamp.demo.demo_weather.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_weather.controller.WeatherOperation;
import com.bootcamp.demo.demo_weather.dto.ClientWeatherDto;
import com.bootcamp.demo.demo_weather.mapper.DtoMapper;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;
import com.bootcamp.demo.demo_weather.service.WeatherService;

@RestController
public class WeatherController implements WeatherOperation {
  @Autowired
  private WeatherService weatherService;
  @Autowired
  private DtoMapper dtoMapper;

  // ! ClientWeatherDto implies "Nine Day"
  @Override
  public List<ClientWeatherDto> getWeatherService(String dataType,
      String lang) {
    // exceptions (String -> enum)
    WeatherDTO weatherDTO =
        this.weatherService.getWeather(DataType.of(dataType), Lang.of(lang));
    // enum class throwing runtime exception

    NineDayDTO nineDayDTO = null;
    if (weatherDTO instanceof NineDayDTO) {
      nineDayDTO = (NineDayDTO) weatherDTO;
    }
    // System.out.println("nineDayDTO=" + nineDayDTO);
    System.out.println(nineDayDTO.getUpdateTime());
    System.out.println(nineDayDTO.getSeaTemp().getRecordTime());
    System.out.println(nineDayDTO.getSoilTemp().get(0).getRecordTime());

    return nineDayDTO.getForecasts().stream() //
        .map(e -> this.dtoMapper.map(e)) //
        .sorted((w1,
            w2) -> w1.getForecastDate().isBefore(w2.getForecastDate()) ? -1 : 1) //
        .collect(Collectors.toList());
  }
}
