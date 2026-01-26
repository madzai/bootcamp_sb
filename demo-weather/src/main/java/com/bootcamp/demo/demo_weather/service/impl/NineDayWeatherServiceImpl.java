package com.bootcamp.demo.demo_weather.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO;
import com.bootcamp.demo.demo_weather.service.NineDayWeatherService;

@Service
public class NineDayWeatherServiceImpl implements NineDayWeatherService {
  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "${external-api.hk-observatory.domain}")
  private String domain;

  @Value(value = "${external-api.hk-observatory.weather.path-segment}")
  private String pathSegment;

  @Value(value = "${external-api.hk-observatory.weather.path}")
  private String path;

  @Value(value = "${external-api.hk-observatory.weather.dataset.nine-day}")
  private String dataType;

  @Override
  public NineDayDTO getWeather(Lang lang) {
    MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
    paramMap.put("dataType", List.of(dataType));
    paramMap.put("lang", List.of(lang.getValue()));
    String url = UriComponentsBuilder.newInstance() //
        .scheme("https") //
        .host(this.domain) //
        .pathSegment(this.pathSegment) //
        .path(this.path) //
        .queryParams(paramMap) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);
    return this.restTemplate.getForObject(url, NineDayDTO.class); // throw exception
  }
}
