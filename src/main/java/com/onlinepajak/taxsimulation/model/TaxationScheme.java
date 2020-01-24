package com.onlinepajak.taxsimulation.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaxationScheme {

    private Integer tier;
    private Double percentage;
    private Double annualIncomeFrom;
    private Double annualIncomeTo;

}
