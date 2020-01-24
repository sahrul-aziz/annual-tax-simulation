package com.onlinepajak.taxsimulation.service;

public interface ITaxSimulationService {

    long simulateTax(Double salary, String taxReliefType);
}
