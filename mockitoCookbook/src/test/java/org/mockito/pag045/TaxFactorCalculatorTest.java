package org.mockito.pag045;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.common.Person;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Country.class)
public class TaxFactorCalculatorTest {
	static final double TAX_FACTOR = 10000;
	@Mock Country country;
	@InjectMocks TaxFactorCalculator systemUnderTest;

	@Test
	public void should_calculate_tax_factor() {
		// given
		PowerMockito.mockStatic(Country.class);
		BDDMockito.given(Country.fromCountryName(Mockito.anyString())).willReturn(country);
		BDDMockito.given(country.calculateTaxFactorFor(Mockito.any(Person.class))).willReturn(TAX_FACTOR);
		
		// when
		double taxFactorForPerson = systemUnderTest.calculateTaxFactorFor(new Person());
		
		// then
		BDDAssertions.then(taxFactorForPerson).isEqualTo(TAX_FACTOR);
	}

}
