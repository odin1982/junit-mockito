package org.mockito.javapoint._01.stubbing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ToDoBusinessStub {
	@Test
	public void test() {
		ToDoService doServiceStub = new ToDoServiceStub();
		ToDoBusiness business = new ToDoBusiness(doServiceStub);
		List<String> retrievedtotodos = business.getTodosForSpring("Dummy");
		assertEquals(2,retrievedtotodos.size());
		System.out.println("Stub is working correctly...!!");
	}

}
