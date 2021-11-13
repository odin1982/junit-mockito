package com.blogspot.toomuchcoding.book.chapter4._2_StubbingMethodThatReturnValues.hamcrest;

import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.TaxFactorFetcher;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@Listeners(MockitoTestNGListener.class)
public class MeanTaxFactorCalculatorTestNgTest {

    @Mock TaxFactorFetcher taxFactorFetcher;

    @InjectMocks MeanTaxFactorCalculator systemUnderTest;

    @Test
    public void should_calculate_mean_tax_factor() {
        // given
        double expectedTaxFactor = 10;
        given(taxFactorFetcher.getTaxFactorFor(any(Person.class))).willReturn(expectedTaxFactor);

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
        assertThat(meanTaxFactor, equalTo(expectedTaxFactor));
    }

}


