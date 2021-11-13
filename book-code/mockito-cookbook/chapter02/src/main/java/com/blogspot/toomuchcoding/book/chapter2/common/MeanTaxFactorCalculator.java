package com.blogspot.toomuchcoding.book.chapter2.common;

import com.blogspot.toomuchcoding.person.Person;

public class MeanTaxFactorCalculator {

    private final TaxService taxService;

    public MeanTaxFactorCalculator(TaxService taxService) {
        this.taxService = taxService;
    }

    public double calculateMeanTaxFactorFor(Person person) {
        double currentTaxFactor = taxService.getCurrentTaxFactorFor(person);
        double anotherTaxFactor = taxService.getCurrentTaxFactorFor(person);
        return (currentTaxFactor + anotherTaxFactor) / 2;
    }

}
