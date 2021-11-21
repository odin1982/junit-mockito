package org.mockito.javapoint._02.mocking;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ToDoBusinessMock {
	
	@Test
	public void testUsingMocks() {
		ToDoService doService = Mockito.mock(ToDoService.class);  
		List<String> combinedList = Arrays.asList("Use Core Java","Use Spring Core","Use Hibernate","Use Spring MVC");
		Mockito.when(doService.getTodos("dummy")).thenReturn(combinedList);
		ToDoBusiness business = new ToDoBusiness(doService);
		List<String> allTd = business.getTodosforHibernate("dummy");
		System.out.println(allTd);
		assertEquals(1, allTd.size());
	}

}
