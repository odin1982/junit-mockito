	package org.mockito.e001;

import java.util.LinkedList;
import java.util.List;

import org.junit.Ignore;
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
	
	@Ignore
	@Test
	public void test_list() {
		// utilizando el mock
		mockedList.add("one");
		mockedList.clear();
		
		// verification
		Mockito.verify(mockedList).add("one");
		Mockito.verify(mockedList).clear();
	}
	
	@Ignore
	@Test(expected=RuntimeException.class)
	public void test_stubbing() {
		Mockito.when(mockedLinkedList.get(0)).thenReturn("first");
		Mockito.when(mockedLinkedList.get(1)).thenThrow(new RuntimeException());
		
		System.out.println(mockedLinkedList.get(0));
		System.out.println(mockedLinkedList.get(99));
		System.out.println(mockedLinkedList.get(1));
		
		Mockito.verify(mockedLinkedList).get(0);
	}
	
	@Test
	public void test_argument_matchers() {
		// stubbing usando anyInt() argument matcher
		Mockito.when(mockedList.get(Mockito.anyInt())).thenReturn("element");
		
		// stubbing usando hamcrest( libreria de matchers )(digamos que isValid() devuelve tu propio matcher):
		//Mockito.when(mockedList.contains(argThat(isValid()))).thenReturn("element");
		
		//imprime "element"
		System.out.println(mockedList.get(999));
		
		//tambien se puede verificar usando argument matchers
		Mockito.verify(mockedList).get(Mockito.anyInt());
	}
}
