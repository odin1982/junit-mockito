package org.mockito.pag019;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.common.Person;
import org.mockito.pag010.TaxService;
import org.mockito.runners.ConsoleSpammingMockitoJUnitRunner;
import org.mockito.runners.VerboseMockitoJUnitRunner;

//@RunWith(VerboseMockitoJUnitRunner.class)
@RunWith(ConsoleSpammingMockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {
	private static final double UNUSED_VALUE = 10;
	
	@Test
	public void shoul_calculate_mean_tax_factor() {
		// given 
		TaxService taxService = BDDMockito.given(Mockito.mock(TaxService.class).performAdditionalCalculation()).willReturn(UNUSED_VALUE).getMock();
		
		MeanTaxFactorCalculator systemUnderTest = new MeanTaxFactorCalculator(taxService);
		
		// when
		double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());
		
		// then
		BDDAssertions.then(meanTaxFactor).isEqualTo(UNUSED_VALUE);
	}

}
