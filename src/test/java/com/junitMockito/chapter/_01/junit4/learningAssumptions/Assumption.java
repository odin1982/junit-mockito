package com.junitMockito.chapter._01.junit4.learningAssumptions;

import static org.junit.Assert.assertTrue;

import org.junit.Assume;
import org.junit.Test;

public class Assumption {
	boolean isSonarRunning = false;

	@Test
	public void very_critical_test() throws Exception {
		isSonarRunning = true;
		Assume.assumeFalse(isSonarRunning);
		assertTrue(true);
	}
}
