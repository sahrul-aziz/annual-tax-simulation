package com.onlinepajak.taxsimulation.repository;

import com.onlinepajak.taxsimulation.model.TaxRelief;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaxReliefRepository {

    public List<TaxRelief> findAll(){
        List<TaxRelief> taxReliefList = new ArrayList<>();
        taxReliefList.add(new TaxRelief("TK0", "Single", 54000000D));
        taxReliefList.add(new TaxRelief("K0", "Married with no dependant", 58500000D));
        taxReliefList.add(new TaxRelief("K1", "Married with 1 dependant", 63000000D));
        taxReliefList.add(new TaxRelief("K2", "Married with 2 dependans", 67500000D));
        taxReliefList.add(new TaxRelief("K3", "Married with 3 dependans", 72000000D));
        return taxReliefList;
    }
}
