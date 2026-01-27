package com.bootcamp.demo.demo_weather.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_weather.entity.NineDayEntity;


@Repository
public interface NineDayRepository extends JpaRepository<NineDayEntity, Long> {
    // save() -> Post
    // saveAll()
    // findById() -> Put
    // deleteAll()
    // deleteById()

    // select * from nine_day_weathers where forecast_date = '2026-01-28';
    List<NineDayEntity> findByForecastDate(LocalDate forecastDate);
    // ! Hibernate read method name "findByForecastDate", translate to SQL

    // JPA method: tranTime between
    List<NineDayEntity> findByTranTimeBetween(LocalDateTime startDateTime,
            LocalDateTime endDateTime);

    // maxTemp >= 28
    // JPQL (Java Persistence Query Language)
    // select * from nine_day_weathers where max_temp > ?
    // ! select entity
    @Query(value = "select e from NineDayEntity e where e.maxTemp >= :degree") // or 1=1 (SQL injection)
    List<NineDayEntity> findByMaxTempJPQL(Double degree);

    // Native SQL
    // ! Hibernate put this native SQL into the bean
    // potentially SQL exception (MySQL)
    // Not Recommend to use select * for native SQL (error-prone if e.g. columns are added to the table
    @Query(value = "select n.id, n.forecast_date, n.max_temp, n.min_temp, n.max_rh, n.min_rh, n.description, n.tran_time from nine_day_weathers n where n.min_temp >= :degree",
            nativeQuery = true) // Product Specific, e.g. need correct SQL for MySQL
    List<NineDayEntity> findByMinTempJPQL(Double degree);

}
