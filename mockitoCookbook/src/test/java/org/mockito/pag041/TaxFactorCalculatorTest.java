package org.mockito.pag041;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.common.Person;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest(TaxService.class)
public class TaxFactorCalculatorTest {
	static final double TAX_FACTOR = 10000;
	
	@Mock
	private TaxService taxService;
	
	@InjectMocks
	private TaxFactorCalculator taxFactorCalculator;
	
	@Test
	public void should_calculate_tax_factor() {
		// given
		BDDMockito.given(taxService.calculateTaxFactorFor(Mockito.any(Person.class))).willReturn(TAX_FACTOR);
		
		// when
		double taxFactorForPerson = taxFactorCalculator.calculateTaxFactorFor(new Person());
		
		// then 
		BDDAssertions.then(taxFactorForPerson).isEqualTo(TAX_FACTOR);
	}
}
