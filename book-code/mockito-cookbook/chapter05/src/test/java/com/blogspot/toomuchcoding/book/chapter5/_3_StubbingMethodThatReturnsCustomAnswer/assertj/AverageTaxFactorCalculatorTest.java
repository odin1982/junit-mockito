package com.blogspot.toomuchcoding.book.chapter5._3_StubbingMethodThatReturnsCustomAnswer.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.blogspot.toomuchcoding.book.chapter5.returningvalue.AverageTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter5.returningvalue.TaxFactorFetcher;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class AverageTaxFactorCalculatorTest {

	@Spy TaxFactorFetcher taxFactorFetcher;

	@InjectMocks AverageTaxFactorCalculator systemUnderTest;

    @Test
    public void should_return_incremented_tax_factor_while_trying_to_calculate_mean_tax_factor_for_a_person_from_undefined_country() {
        // given
	    final double expectedTaxFactor = 107;
        willAnswer(withTaxFactorDependingOnPersonOrigin()).given(taxFactorFetcher).getTaxFactorFromDb(any(Person.class));

        // when
        double avgTaxFactor = systemUnderTest.calculateAvgTaxFactorFor(new Person());

        // then
        then(avgTaxFactor).isEqualTo(expectedTaxFactor);
    }

	private Answer<Object> withTaxFactorDependingOnPersonOrigin() {
		return new Answer<Object>() {			
		    @Override
		    public Object answer(InvocationOnMock invocation) throws Throwable {			    
			    double baseTaxFactor = 50;
			    double incrementedTaxFactor = 200;
		        if (invocation.getArguments().length > 0) {
		            Person person = (Person) invocation.getArguments()[0];
		            if (!person.isCountryDefined()) {
		                return incrementedTaxFactor;
		            }
		        }
		        return baseTaxFactor;
		    }
		};
	}

}


