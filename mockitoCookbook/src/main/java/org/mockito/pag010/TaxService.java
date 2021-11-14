package org.mockito.pag010;

import org.mockito.common.Person;

public interface TaxService {

    double getCurrentTaxFactorFor(Person person);

	double performAdditionalCalculation();
}


