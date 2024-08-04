package com.TaxiCalculate.taxiCalculate.repository;

import com.TaxiCalculate.taxiCalculate.entity.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxi, Long> {
}
