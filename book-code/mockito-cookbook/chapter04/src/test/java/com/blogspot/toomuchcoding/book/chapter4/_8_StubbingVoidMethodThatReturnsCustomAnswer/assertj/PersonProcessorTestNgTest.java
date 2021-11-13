package com.blogspot.toomuchcoding.book.chapter4._8_StubbingVoidMethodThatReturnsCustomAnswer.assertj;

import com.blogspot.toomuchcoding.book.chapter4.common.exception.FailedToSavedPersonDataException;
import com.blogspot.toomuchcoding.book.chapter4.common.voidmethod.PersonProcessor;
import com.blogspot.toomuchcoding.book.chapter4.common.voidmethod.PersonSaver;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.willAnswer;
import static org.mockito.Matchers.any;

@Listeners(MockitoTestNGListener.class)
public class PersonProcessorTestNgTest {

    @Mock PersonSaver personSaver;
	 
    @InjectMocks PersonProcessor systemUnderTest;

    @Test
    public void should_fail_to_save_person_data_due_to_having_undefined_country() {
        // given
        willAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                if (invocation.getArguments().length > 0) {
                    Person person = (Person) invocation.getArguments()[0];
                    if (!person.isCountryDefined()) {
                        throw new FailedToSavedPersonDataException("Undefined country");
                    }
                }
                return null;
            }
        }).given(personSaver).savePerson(any(Person.class));

        // when
        boolean updateSuccessful = systemUnderTest.process(new Person());

        // then
        then(updateSuccessful).isFalse();
    }
	
}


