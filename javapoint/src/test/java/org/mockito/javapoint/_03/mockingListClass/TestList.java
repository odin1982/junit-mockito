package org.mockito.javapoint._03.mockingListClass;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestList {
	@Test
	public void testList_ReturnsSingle_value() {

		List mocklist = mock(List.class);
		when(mocklist.size()).thenReturn(1);

		assertEquals(1, mocklist.size());
		assertEquals(1, mocklist.size());

		System.out.println(mocklist.size());
		System.out.println(mocklist);
	}
}
