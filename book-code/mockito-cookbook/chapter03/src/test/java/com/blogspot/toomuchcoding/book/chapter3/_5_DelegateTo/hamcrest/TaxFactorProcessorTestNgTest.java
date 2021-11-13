package com.blogspot.toomuchcoding.book.chapter3._5_DelegateTo.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.AdditionalAnswers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter3._5_DelegateTo.FinalTaxService;
import com.blogspot.toomuchcoding.book.chapter3._5_DelegateTo.TaxFactorProcessor;
import com.blogspot.toomuchcoding.book.chapter3._5_DelegateTo.TaxService;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;

@Listeners(MockitoTestNGListener.class)
public class TaxFactorProcessorTestNgTest {

    FinalTaxService finalTaxService = new FinalTaxService();

    TaxService taxService = mock(TaxService.class, delegatesTo(finalTaxService));

    TaxFactorProcessor systemUnderTest = new TaxFactorProcessor(taxService);

    @Test
    public void should_return_default_tax_factor_for_person_from_undefined_country() {
        // given
        doNothing().when(taxService).updateTaxData(anyDouble(), any(Person.class));

        // when
        double taxFactor = systemUnderTest.processTaxFactorFor(new Person());

        // then
	    assertThat(taxFactor, equalTo(FinalTaxService.DEFAULT_TAX_FACTOR));
    }

}


