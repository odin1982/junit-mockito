package org.mockito.pag019;

import org.mockito.common.Person;
import org.mockito.pag010.TaxService;

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