package com.junitMockito.chapter._01.junit4.workingWithExceptionHandling;

import org.junit.Test;

public class ExceptionHandlingTest {
	
	@Test(expected = RuntimeException.class)
	public void exception() {
		throw new RuntimeException();
	}

}
