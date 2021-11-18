package org.mockito.pag041;

import org.mockito.common.Person;

public final class TaxService {

    public static final double POLAND_TAX_FACTOR = 0.3;
    public static final double DEFAULT_TAX_FACTOR = 0.5;
    public static final String POLAND = "Poland";

    public double calculateTaxFactorFor(Person person) {
        if (POLAND.equalsIgnoreCase(person.getCountryName())) {
            return POLAND_TAX_FACTOR;
        }
        return DEFAULT_TAX_FACTOR;
    }

}