package com.blogspot.toomuchcoding.book.chapter4._12_StubbingObjectInstantiationWithPowerMock.hamcrest;

import com.blogspot.toomuchcoding.book.chapter4._12_StubbingObjectInstantiationWithPowerMock.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4._12_StubbingObjectInstantiationWithPowerMock.TaxFactorFetcher;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MeanTaxFactorCalculator.class)
public class MeanTaxFactorCalculatorTest {
	
    @Mock TaxFactorFetcher taxFactorFetcher;
	
	MeanTaxFactorCalculator systemUnderTest = new MeanTaxFactorCalculator();
	
    @Test
    public void should_calculate_tax_factor_for_a_player_from_undefined_country() throws Exception {
        // given
	    double expectedMeanTaxFactor = 10;
	    whenNew(TaxFactorFetcher.class).withNoArguments().thenReturn(taxFactorFetcher);
        given(taxFactorFetcher.getTaxFactorFor(any(Person.class))).willReturn(5.5, 14.5);

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
        assertThat(meanTaxFactor, equalTo(expectedMeanTaxFactor));
    }
	
}
