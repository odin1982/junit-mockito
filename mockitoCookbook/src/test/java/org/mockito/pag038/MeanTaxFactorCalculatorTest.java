package org.mockito.pag038;

import java.io.Serializable;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.common.Person;
import org.mockito.pag010.TaxService;
import org.mockito.pag025.MeanTaxFactorCalculator;

public class MeanTaxFactorCalculatorTest {
	static final double TAX_FACTOR = 10;
		
	@Test
	public void should_calculate_mean_tax_factor() {
		TaxService taxService = Mockito.mock(TaxService.class,Mockito.withSettings().serializable());
		MeanTaxFactorCalculator systemUnderTest = new MeanTaxFactorCalculator(taxService);
		
		// given
		BDDMockito.given(taxService.getCurrentTaxFactorFor(Mockito.any(Person.class))).willReturn(TAX_FACTOR);
		
		// when
		double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());
		
		// then
		BDDAssertions.then(meanTaxFactor).isEqualTo(TAX_FACTOR);
		BDDAssertions.then(taxService).isInstanceOf(Serializable.class);
	}
}
