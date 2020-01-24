package com.onlinepajak.taxsimulation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class TaxRelief {

    private String profile;
    private String description;
    private Double ptkpAmount;

}
