package org.mockito.pag025;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.common.Person;
import org.mockito.pag010.TaxService;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {
	static final double TAX_FACTOR = 10;
	
	TaxService taxService = Mockito.mock(TaxService.class);
	
	@Test
	public void should_calculate_mean_tax_factor() {
		
		// given
		BDDMockito.given(taxService.getCurrentTaxFactorFor(Mockito.any(Person.class))).willReturn(TAX_FACTOR);
		
		MeanTaxFactorCalculator meanTaxFactorCalculator = new MeanTaxFactorCalculator(taxService);
		
		// when
		double meanTaxFactor = meanTaxFactorCalculator.calculateMeanTaxFactorFor(new Person());
		
		// then
		BDDAssertions.then(meanTaxFactor).isEqualTo(TAX_FACTOR);
	}
	
}
