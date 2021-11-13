package com.blogspot.toomuchcoding.book.chapter3._1_CreatingSpies.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;

import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter3.common.TaxFactorProcessor;
import com.blogspot.toomuchcoding.book.chapter3.common.TaxService;
import com.blogspot.toomuchcoding.person.Person;

public class TaxFactorProcessorTestNgTest {

    TaxService taxService = spy(new TaxService());

    TaxFactorProcessor systemUnderTest = new TaxFactorProcessor(taxService);

    @Test
    public void should_return_default_tax_factor_for_person_from_undefined_country() {
        // given
        doNothing().when(taxService).updateTaxData(anyDouble(), any(Person.class));

        // when
        double taxFactor = systemUnderTest.processTaxFactorFor(new Person());

        // then
        assertThat(taxFactor, equalTo(TaxService.DEFAULT_TAX_FACTOR));
    }

}


