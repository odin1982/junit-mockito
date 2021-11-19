package org.mockito.e001;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Sample001 {
	// creación del mock
	@Mock private List<String> mockedList;
	@Mock private LinkedList<String> mockedLinkedList;
	
	@Test
	public void test_list() {
		// utilizando el mock
		mockedList.add("one");
		mockedList.clear();
		
		// verification
		Mockito.verify(mockedList).add("one");
		Mockito.verify(mockedList).clear();
	}
	
	@Test(expected=RuntimeException.class)
	public void test_stubbing() {
		Mockito.when(mockedLinkedList.get(0)).thenReturn("first");
		Mockito.when(mockedLinkedList.get(1)).thenThrow(new RuntimeException());
		
		System.out.println(mockedLinkedList.get(0));
		System.out.println(mockedLinkedList.get(99));
		System.out.println(mockedLinkedList.get(1));
		
		Mockito.verify(mockedLinkedList).get(0);
	}
}
