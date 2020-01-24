package com.onlinepajak.taxsimulation.controller;


import com.onlinepajak.taxsimulation.service.ITaxSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;


@RestController
@RequestMapping("simulation")
public class TaxSimulationController {

    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    @Autowired
    private ITaxSimulationService taxSimulationService;

    @RequestMapping(value = "annualTax", method = RequestMethod.GET)
    public String simulateAnnualTax(@RequestParam double salary, @RequestParam String profile) {
        return decimalFormat.format(taxSimulationService.simulateTax(salary, profile));
    }

}
