package com.blogspot.toomuchcoding.book.chapter1._5_AddingMockitoHintsToExceptionMessages.verbose.assertj;

import com.blogspot.toomuchcoding.book.chapter1._5_AddingMockitoHintsToExceptionMessages.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter1._5_AddingMockitoHintsToExceptionMessages.TaxService;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.VerboseMockitoJUnitRunner;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@RunWith(VerboseMockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {

    /**
     * VerboseMockitoJUnitRunner appends a listener that changes the failure's exception in a very hacky way...
     * <p/>
     * - Finds all unused stubs for given mocks
     * - Finds all stubs
     * - Prints additional warning msg - it might help in finding the reasons
     */

    static final double UNUSED_VALUE = 10;

    @Test(expected = ComparisonFailure.class)
    public void should_calculate_mean_tax_factor() {
        // given
        TaxService taxService = given(Mockito.mock(TaxService.class).performAdditionalCalculation()).willReturn(UNUSED_VALUE).getMock();
        MeanTaxFactorCalculator systemUnderTest = new MeanTaxFactorCalculator(taxService);

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
        then(meanTaxFactor).isEqualTo(UNUSED_VALUE);
    }

}
