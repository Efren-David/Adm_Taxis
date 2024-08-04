package com.TaxiCalculate.taxiCalculate.service;

import com.TaxiCalculate.taxiCalculate.entity.Taxi;
import com.TaxiCalculate.taxiCalculate.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiService {

    @Autowired
    private TaxiRepository taxiRepository;

    public Taxi addTaxi(Taxi taxi) {
        return taxiRepository.save(taxi);
    }

    public List<Taxi> getAllTaxis() {
        return taxiRepository.findAll();
    }

    public Taxi getTaxiById(Long id) {
        return taxiRepository.findById(id).orElse(null);
    }

}
