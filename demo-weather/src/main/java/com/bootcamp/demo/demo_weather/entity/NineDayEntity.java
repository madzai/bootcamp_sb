package com.bootcamp.demo.demo_weather.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nine_day_weathers")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NineDayEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(name = "tran_time")
  private LocalDateTime tranTime;
  
  @Column(name = "forecast_date")
  private LocalDate forecastDate;
  @Column(name = "max_temp", precision = 5, scale = 2) // deimcal(5,2)
  private BigDecimal maxTemp;
  @Column(name = "min_temp", precision = 5, scale = 2)
  private BigDecimal minTemp;
  @Column(name = "max_rh", precision = 5, scale = 2)
  private BigDecimal maxRh;
  @Column(name = "min_rh", precision = 5, scale = 2)
  private BigDecimal minRh;
  @Column(length = 1000)
  private String description;
}
