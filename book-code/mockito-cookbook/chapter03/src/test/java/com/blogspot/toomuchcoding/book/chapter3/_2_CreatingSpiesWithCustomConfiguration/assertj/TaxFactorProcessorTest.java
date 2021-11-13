package com.blogspot.toomuchcoding.book.chapter3._2_CreatingSpiesWithCustomConfiguration.assertj;

import com.blogspot.toomuchcoding.book.chapter3.common.TaxFactorProcessor;
import com.blogspot.toomuchcoding.book.chapter3.common.TaxService;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;

import java.io.Serializable;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;

public class TaxFactorProcessorTest {

    TaxService taxService = mock(TaxService.class, withSettings().serializable().spiedInstance(new TaxService()).defaultAnswer(CALLS_REAL_METHODS));

    TaxFactorProcessor systemUnderTest = new TaxFactorProcessor(taxService);

    @Test
    public void should_return_default_tax_factor_for_person_from_undefined_country() {
        // given
        doNothing().when(taxService).updateTaxData(anyDouble(), any(Person.class));

        // when
        double taxFactor = systemUnderTest.processTaxFactorFor(new Person());

        // then
        then(taxFactor).isEqualTo(TaxService.DEFAULT_TAX_FACTOR);
        then(taxService).isInstanceOf(Serializable.class);
    }

}


