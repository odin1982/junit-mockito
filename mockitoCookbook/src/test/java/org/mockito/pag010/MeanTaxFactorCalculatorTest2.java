package org.mockito.pag010;

import org.assertj.core.api.BDDAssertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.common.Person;
/*
 * Esta es otra forma de implementar Mockito si tu test no usa @RunWith(MockitoJUnitRunner.class)
 * o puede llegar el caso que en los test no se este implementando esta anotacion.
 */
public class MeanTaxFactorCalculatorTest2 {
	private static final double TAX_FACTOR = 10;
	@Mock TaxService taxService;
	@InjectMocks MeanTaxFactorCalculator meanTaxFactorCalculator;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void should_calculate_mean_tax_factor() {
		BDDMockito.given(taxService.getCurrentTaxFactorFor(Mockito.any(Person.class))).willReturn(TAX_FACTOR);
		double meanTaxFactor = meanTaxFactorCalculator.calculateMeanTaxFactorFor(new Person());
		BDDAssertions.then(meanTaxFactor).isEqualTo(TAX_FACTOR);
		
	}

}
