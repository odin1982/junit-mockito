package com.blogspot.toomuchcoding.book.chapter4._9_StubbingVoidMethodCallsRealMethod.assertj;

import com.blogspot.toomuchcoding.book.chapter4._9_StubbingVoidMethodCallsRealMethod.PersonProcessor;
import com.blogspot.toomuchcoding.book.chapter4._9_StubbingVoidMethodCallsRealMethod.PersonSaver;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.willCallRealMethod;
import static org.mockito.Matchers.any;

@Listeners(MockitoTestNGListener.class)
public class PersonProcessorTestNgTest {

    @Mock
    PersonSaver personSaver;

    @InjectMocks
    PersonProcessor systemUnderTest;

    @Test
    public void should_fail_to_save_person_data_due_to_having_undefined_country() {
        // given
        willCallRealMethod().given(personSaver).savePerson(any(Person.class));

        // when
        boolean updateSuccessful = systemUnderTest.updatePersonData(new Person());

        // then
        then(updateSuccessful).isFalse();
    }
	
}


