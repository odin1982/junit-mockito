package org.mockito.pag051;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.common.Person;
import org.mockito.common.TaxService;
import org.mockito.runners.MockitoJUnitRunner;;

@RunWith(MockitoJUnitRunner.class)
public class TaxFactorProcessorTest {
	TaxService taxService = Mockito.spy(new TaxService());
	TaxFactorProcessor systemUnderTest = new TaxFactorProcessor(taxService);
	
	@Test
	public void should_return_default_tax_factor_for_person_fromundefined_country() {
		// given
		Mockito.doNothing().when(taxService).updateTaxData(Mockito.anyDouble(), Mockito.any(Person.class));
		
		// when
		double taxFactor = systemUnderTest.processTaxFactorFor(new Person());
		
		// then
		BDDAssertions.then(taxFactor).isEqualTo(TaxService.DEFAULT_TAX_FACTOR);
	}
}
