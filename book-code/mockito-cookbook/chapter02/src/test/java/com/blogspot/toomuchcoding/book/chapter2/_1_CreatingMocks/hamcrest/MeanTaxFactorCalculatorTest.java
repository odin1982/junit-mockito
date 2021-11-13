package com.blogspot.toomuchcoding.book.chapter2._1_CreatingMocks.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.blogspot.toomuchcoding.book.chapter2.common.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter2.common.TaxService;
import com.blogspot.toomuchcoding.person.Person;

public class MeanTaxFactorCalculatorTest {

	static final double TAX_FACTOR = 10;
	
	TaxService taxService = mock(TaxService.class);

	MeanTaxFactorCalculator systemUnderTest = new MeanTaxFactorCalculator(taxService);

	@Test
	public void should_calculate_mean_tax_factor() {
		// given
		given(taxService.getCurrentTaxFactorFor(any(Person.class))).willReturn(TAX_FACTOR);

		// when
		double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

		// then
		assertThat(meanTaxFactor, equalTo(TAX_FACTOR));
	}
	
}
