package org.mockito.pag010;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.common.Person;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {
	private static final double TAX_FACTOR = 10;
	@Mock TaxService taxService;
	@InjectMocks MeanTaxFactorCalculator meanTaxFactorCalculator;
	
	@Test
	public void should_calculate_mean_tax_factor() {
		BDDMockito.given(taxService.getCurrentTaxFactorFor(Mockito.any(Person.class))).willReturn(TAX_FACTOR);
		double meanTaxFactor = meanTaxFactorCalculator.calculateMeanTaxFactorFor(new Person());
		BDDAssertions.then(meanTaxFactor).isEqualTo(TAX_FACTOR);
		
	}

}
