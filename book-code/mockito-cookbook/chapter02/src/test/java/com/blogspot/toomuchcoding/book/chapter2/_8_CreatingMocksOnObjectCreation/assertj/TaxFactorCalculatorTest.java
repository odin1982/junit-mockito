package com.blogspot.toomuchcoding.book.chapter2._8_CreatingMocksOnObjectCreation.assertj;

import com.blogspot.toomuchcoding.book.chapter2._8_CreatingMocksOnObjectCreation.TaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter2._8_CreatingMocksOnObjectCreation.TaxWebService;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TaxFactorCalculator.class)
public class TaxFactorCalculatorTest {

    static final double TAX_FACTOR = 10000;

    @Mock
    TaxWebService taxWebService;

    @InjectMocks TaxFactorCalculator systemUnderTest;

    @Test
    public void should_calculate_tax_factor() throws Exception {
        // given
        whenNew(TaxWebService.class).withNoArguments().thenReturn(taxWebService);
        when(taxWebService.calculateTaxFactorFor(any(Person.class))).thenReturn(TAX_FACTOR);

        // when
        double taxFactorForPerson = systemUnderTest.calculateTaxFactorFor(new Person());

        // then
        then(taxFactorForPerson).isEqualTo(TAX_FACTOR);
    }

}
