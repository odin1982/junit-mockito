package org.mockito.pag031;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.common.Person;
import org.mockito.internal.stubbing.answers.ThrowsExceptionClass;
import org.mockito.pag010.TaxService;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {
	@Test
	public void should_throw_exception_when_calculating_mean_tax_factor() {
		TaxService taxService = Mockito.mock(TaxService.class,new ThrowsExceptionClass(IllegalStateException.class));
		MeanTaxFactorCalculator systemUnderTest = new MeanTaxFactorCalculator(taxService);
		try {
			systemUnderTest.calculateMeanTaxFactorFor(new Person());
		}catch(IllegalStateException exception) {}
	
	}
	
}
