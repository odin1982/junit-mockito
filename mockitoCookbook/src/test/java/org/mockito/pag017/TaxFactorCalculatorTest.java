package org.mockito.pag017;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaxFactorCalculatorTest {
	
	@Test
	public void should_calculate_sum_of_factors() {
		// given
		TaxFactorCalculator systemUnderTest = new TaxFactorCalculator();
		double taxFactorOne = 1;
		double taxFactorTwo = 2;
		double expectedSum = 3;
		
		// when
		double sumOfFactors = systemUnderTest.calculateSum(taxFactorOne, taxFactorTwo);
		
		// then
		BDDAssertions.then(sumOfFactors).isEqualTo(expectedSum);
	}
}
