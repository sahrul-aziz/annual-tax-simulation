package com.onlinepajak.taxsimulation.service.impl;

import com.onlinepajak.taxsimulation.model.TaxRelief;
import com.onlinepajak.taxsimulation.model.TaxationScheme;
import com.onlinepajak.taxsimulation.repository.TaxReliefRepository;
import com.onlinepajak.taxsimulation.repository.TaxationSchemeRepository;
import com.onlinepajak.taxsimulation.service.ITaxSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaxSimulationServiceImpl implements ITaxSimulationService {

    private static final int PERIOD = 12;

    @Autowired
    private TaxReliefRepository taxReliefRepository;

    @Autowired
    private TaxationSchemeRepository taxationSchemeRepository;

    @Override
    public long simulateTax(Double salary, String taxReliefType) {
        double annualTaxableIncome = getAnnualTaxableIncome(salary, taxReliefType);
        return getAnnualTax(annualTaxableIncome);
    }

    private double getAnnualTaxableIncome(Double salary, String profile) {
        double annualTaxableIncome = (salary * PERIOD) - getAnnualNonTaxableIncome(profile);
        if (annualTaxableIncome > 0) return annualTaxableIncome;
        else return 0;
    }

    private double getAnnualNonTaxableIncome(String profile) {
        return taxReliefRepository.findAll().stream()
                .filter(taxRelief -> taxRelief.getProfile().equalsIgnoreCase(profile))
                .map(TaxRelief::getPtkpAmount).findAny().orElse(0D);
    }

    private long getAnnualTax(Double annualTaxableIncome) {
        if (annualTaxableIncome == 0)
            return 0;
        else {
            return getTaxFromRemainingIncome(annualTaxableIncome, 1);
        }
    }

    private TaxationScheme getTaxationSchemeByTier(Integer tier) {
        return taxationSchemeRepository.findTaxationSchemes().stream()
                .filter(taxationScheme -> taxationScheme.getTier().equals(tier))
                .findAny().orElse(null);
    }

    private long getTaxFromRemainingIncome(Double remainingIncome, Integer tier) {
        TaxationScheme taxationScheme = getTaxationSchemeByTier(tier);
        if (taxationScheme == null)
            return 0;

        if (taxationScheme.getAnnualIncomeTo() == 0) {
            Double annualTax = remainingIncome * taxationScheme.getPercentage();
            return annualTax.longValue();
        }

        double maxIncome = taxationScheme.getAnnualIncomeTo() - taxationScheme.getAnnualIncomeFrom();
        if (remainingIncome > maxIncome) {
            Double annualTax = maxIncome * taxationScheme.getPercentage();
            remainingIncome -= maxIncome;
            return annualTax.longValue() + getTaxFromRemainingIncome(remainingIncome, ++tier);
        } else {
            Double annualTax = remainingIncome * taxationScheme.getPercentage();
            return annualTax.longValue();
        }
    }
}
