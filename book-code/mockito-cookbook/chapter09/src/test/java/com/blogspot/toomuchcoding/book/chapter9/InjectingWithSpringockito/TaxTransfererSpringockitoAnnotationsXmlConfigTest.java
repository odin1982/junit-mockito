package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpringockito;

import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringockitoContextLoader.class, locations = {"/chapter9/InjectingWithSpringockito/application-context.xml"})
public class TaxTransfererSpringockitoAnnotationsXmlConfigTest {

    @Autowired TaxTransferer taxTransferer;

    @ReplaceWithMock @Autowired TaxService taxService;

    @Test
    public void should_transfer_tax_for_person() {
        // given
        Person person = new Person();

        // when
        boolean transferSuccessful = taxTransferer.transferTaxFor(person);

        // then
        then(transferSuccessful).isTrue();
        verify(taxService).transferTaxFor(person);
    }

}
