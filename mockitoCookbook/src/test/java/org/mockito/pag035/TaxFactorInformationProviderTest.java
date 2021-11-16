package org.mockito.pag035;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.common.Person;
import org.mockito.pag010.TaxService;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaxFactorInformationProviderTest {
	@Mock(answer = Answers.RETURNS_SMART_NULLS) 
	TaxService taxService;
	
	@InjectMocks 
	TaxFactorInformationProvider systemUnderTest;
	
	@Test
	public void should_calculate_mean_tax_factor() {
		// when
		String parsedIrsAddress = systemUnderTest.formatIrsAddress(new Person());
		
		// then
		BDDAssertions.then(parsedIrsAddress).isEqualTo("IRS:[]");
	}

}
