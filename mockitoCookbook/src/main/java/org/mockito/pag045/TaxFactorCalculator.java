package org.mockito.pag045;

import org.mockito.common.Person;

public class TaxFactorCalculator {

    public static final double INVALID_TAX_FACTOR = -1;

    public double calculateTaxFactorFor(Person person) {
        Country country = Country.fromCountryName(person.getCountryName());
        try {
            return country.calculateTaxFactorFor(person);
        } catch (Exception e) {
            System.err.printf("Exception [%s] occurred while trying to calculate tax factor for person [%s]%n", e, person.getName());
            return INVALID_TAX_FACTOR;
        }
    }

}
