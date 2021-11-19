package org.mockito.pag061;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.common.Person;
import org.mockito.common.TaxService;
import org.mockito.pag056.TaxFactorProcessor;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaxFactorProcessorTest {
	@Mock TaxService taxService;
	@InjectMocks TaxFactorProcessor systemUnderTest;
	
	@Test
	public void should_return_default_tax_factor_for_person_from_undefined_country() {
		
		// given
		BDDMockito.given(taxService.calculateTaxFactorFor(Mockito.any(Person.class))).willCallRealMethod();
		
		// when
		double taxFactor = systemUnderTest.processTaxFactorFor(new Person());
		
		// then 
		BDDAssertions.then(taxFactor).isEqualTo(TaxService.DEFAULT_TAX_FACTOR);
	}
}
