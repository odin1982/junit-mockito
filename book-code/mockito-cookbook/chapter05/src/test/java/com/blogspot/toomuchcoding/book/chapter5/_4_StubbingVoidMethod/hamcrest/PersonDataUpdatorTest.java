package com.blogspot.toomuchcoding.book.chapter5._4_StubbingVoidMethod.hamcrest;

import com.blogspot.toomuchcoding.book.chapter5.voidmethod.PersonDataUpdator;
import com.blogspot.toomuchcoding.book.chapter5.voidmethod.TaxFactorService;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.ConnectException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonDataUpdatorTest {

    @Spy TaxFactorService taxFactorService;

    @InjectMocks PersonDataUpdator systemUnderTest;

    @Test
    public void should_successfully_update_tax_factor_for_person() throws ConnectException {
        // given
        willDoNothing().given(taxFactorService).updateMeanTaxFactor(any(Person.class), anyDouble());

        // when
        boolean success = systemUnderTest.processTaxDataFor(new Person());
	    
	    // then
        assertThat(success, is(true));
    }
	
}


