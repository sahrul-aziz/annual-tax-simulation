package com.onlinepajak.taxsimulation.repository;

import com.onlinepajak.taxsimulation.model.TaxationScheme;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaxationSchemeRepository {

    public List<TaxationScheme> findTaxationSchemes(){
        List<TaxationScheme> taxationSchemeList = new ArrayList<>();
        taxationSchemeList.add(new TaxationScheme(1, 0.05, 0D, 50000000D));
        taxationSchemeList.add(new TaxationScheme(2, 0.15, 50000000D, 250000000D));
        taxationSchemeList.add(new TaxationScheme(3, 0.25, 250000000D, 500000000D));
        taxationSchemeList.add(new TaxationScheme(4, 0.3, 500000000D, 0D));
        return taxationSchemeList;
    }
}
