package com.TaxiCalculate.taxiCalculate.controller;


import com.TaxiCalculate.taxiCalculate.entity.Taxi;
import com.TaxiCalculate.taxiCalculate.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxis")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    @PostMapping
    public Taxi addTaxi(@RequestBody Taxi taxi){
        return taxiService.addTaxi(taxi);
    }

    @GetMapping
    public List<Taxi> getAllTaxis(){
        return taxiService.getAllTaxis();
    }

    @GetMapping("/{id}")
    public Taxi getTaxiById(@PathVariable Long id){
        return taxiService.getTaxiById(id);
    }

    @GetMapping("/{id}/costos")
    public String getCostosById(@PathVariable Long id){
        Taxi taxi = taxiService.getTaxiById(id);
        if (taxi == null){
            return "Taxi no encontrado";
        }
        return String.format("Costo Licencia: $%.2f, Costo Permiso Concesion: $%.2f, Total a Pagar: $%.2f",
                taxi.getCostoLicencia(), taxi.getCostoPermisoConcesion(), taxi.getTotalAPagar());
    }
}
