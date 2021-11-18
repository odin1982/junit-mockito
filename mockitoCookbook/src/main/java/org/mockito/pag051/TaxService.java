package org.mockito.pag051;

import org.mockito.common.Person;

public interface TaxService {

    double calculateTaxFactorFor(Person person);

    void updateTaxData(double taxFactor, Person person);

}
