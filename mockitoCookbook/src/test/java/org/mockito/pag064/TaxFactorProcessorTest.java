package org.mockito.pag064;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.mockito.common.Person;
import org.mockito.common.TaxService;
import org.mockito.pag056.TaxFactorProcessor;
import org.mockito.pag063.FinalTaxService;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaxFactorProcessorTest {
	
	@Test
	public void should_return_default_tax_factor_for_person_from_undefined_country() {
		FinalTaxService finalTaxService = new FinalTaxService();
		TaxService taxService = Mockito.mock(TaxService.class,AdditionalAnswers.delegatesTo(finalTaxService));
		TaxFactorProcessor systemUnderTest = new TaxFactorProcessor(taxService);
		
		// given
		Mockito.doNothing().when(taxService).updateTaxData(Mockito.anyDouble(), Mockito.any(Person.class));
		
		// when
		double taxFactor = systemUnderTest.processTaxFactorFor(new Person());
		
		// then
		BDDAssertions.then(taxFactor).isEqualTo(FinalTaxService.DEFAULT_TAX_FACTOR);
	}
}
