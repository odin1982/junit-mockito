package org.mockito.pag056;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.common.Person;
import org.mockito.common.TaxService;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaxFactorProcessorTest {
	@Spy
	private TaxService taxService;
	
	@InjectMocks
	private TaxFactorProcessor systemUnderTest;
	
	@Test
	public void should_return_default_tax_factor_for_person_from_undefined_country() {
		// given
		Mockito.doNothing().when(taxService).updateTaxData(Mockito.anyDouble(), Mockito.any(Person.class));
		
		// when
		double taxFactor = systemUnderTest.processTaxFactorFor(new Person());
		
		//then
		BDDAssertions.then(taxFactor).isEqualTo(TaxService.DEFAULT_TAX_FACTOR);
	}
	

}
