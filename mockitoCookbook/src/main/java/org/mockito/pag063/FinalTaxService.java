package org.mockito.pag063;

import org.mockito.common.Person;

public class FinalTaxService implements TaxService{
	public static final double POLAND_TAX_FACTOR = 0.3;
    public static final double DEFAULT_TAX_FACTOR = 0.5;
    public static final String POLAND_COUNTRY_NAME = "Poland";

	@Override
	public double calculateTaxFactorFor(Person person) {
		return 0;
	}

	@Override
	public void updateTaxData(double taxFactor, Person person) {
		System.out.println("Updating tax data");
	}

}
