package com.junitMockito.chapter._01._01.workingWithJUnit4._01.runningTheFirstUnitTest._03.workingWithExceptionHandling;

import org.junit.Test;

public class WorkingWithExceptionHandling {
    @Test(expected=RuntimeException.class)
    public void exception() {
        throw new RuntimeException();
    }
}
