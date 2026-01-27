package com.bootcamp.demo.bc_mtr_station.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mtr_stations")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 3)
  private String code;
  private String description;
  @Column(length = 3)
  private String prevCode;
  @Column(length = 3)
  private String nextCode;

  @ManyToOne
  @JoinColumn(name = "line_id")
  @Setter
  private LineEntity lineEntity;

}
