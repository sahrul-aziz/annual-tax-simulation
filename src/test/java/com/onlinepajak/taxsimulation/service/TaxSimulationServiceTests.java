package com.onlinepajak.taxsimulation.service;


import com.onlinepajak.taxsimulation.repository.TaxReliefRepository;
import com.onlinepajak.taxsimulation.repository.TaxationSchemeRepository;
import com.onlinepajak.taxsimulation.service.impl.TaxSimulationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TaxSimulationServiceTests {

    @InjectMocks
    private TaxSimulationServiceImpl taxSimulationService;

    @Spy
    private TaxReliefRepository taxReliefRepository;

    @Spy
    private TaxationSchemeRepository taxationSchemeRepository;

    @Test
    public void given6500000AndK1_whenSimulateTax_thenReturn750000() {
        // Given
        double salary = 6500000;
        String profile = "K1";

        // When
        long actualAnnualTax = taxSimulationService.simulateTax(salary, profile);

        // Then
        long expectedAnnualTax = 750000;

        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

    @Test
    public void given25000000AndTK0_whenSimulateTax_thenReturn31900000() {
        // Given
        double salary = 25000000;
        String profile = "TK0";

        // When
        long actualAnnualTax = taxSimulationService.simulateTax(salary, profile);

        // Then
        long expectedAnnualTax = 31900000;

        assertEquals(expectedAnnualTax, actualAnnualTax);
    }


    @Test
    public void given60000000AndTK0_whenSimulateTax_thenReturn144800000() {
        //given
        double salary = 60000000;
        String profile = "TK0";

        //when
        long actualAnnualTax = taxSimulationService.simulateTax(salary, profile);

        //then
        long expectedAnnualTax = 144800000;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

    @Test
    public void given60000000AndK0_whenSimulateTax_thenReturn143450000() {
        //given
        double salary = 60000000;
        String profile = "K0";

        //when
        long actualAnnualTax = taxSimulationService.simulateTax(salary, profile);

        //then
        long expectedAnnualTax = 143450000;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

    @Test
    public void given60000000AndK1_whenSimulateTax_thenReturn142100000() {
        //given
        double salary = 60000000;
        String profile = "K1";

        //when
        long actualAnnualTax = taxSimulationService.simulateTax(salary, profile);

        //then
        long expectedAnnualTax = 142100000;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

    @Test
    public void given60000000AndK2_whenSimulateTax_thenReturn140750000() {
        //given
        double salary = 60000000;
        String profile = "K2";

        //when
        long actualAnnualTax = taxSimulationService.simulateTax(salary, profile);

        //then
        long expectedAnnualTax = 140750000;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

    @Test
    public void given60000000AndK3_whenSimulateTax_thenReturn139400000() {
        //given
        double salary = 60000000;
        String profile = "K3";

        //when
        long actualAnnualTax = taxSimulationService.simulateTax(salary, profile);

        //then
        long expectedAnnualTax = 139400000;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

    @Test
    public void given3000000AndK1_whenSimulateTax_thenReturn0() {
        //given
        double salary = 3000000;
        String profile = "K1";

        //when
        long actualAnnualTax = taxSimulationService.simulateTax(salary, profile);

        //then
        long expectedAnnualTax = 0;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

}
