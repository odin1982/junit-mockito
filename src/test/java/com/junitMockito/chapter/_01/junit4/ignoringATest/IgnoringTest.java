package com.junitMockito.chapter._01.junit4.ignoringATest;

import org.junit.Ignore;
import org.junit.Test;

public class IgnoringTest {
	
	@Test
	@Ignore("John's holiday stuff failing")
	public void when_today_is_holiday_then_stop_alarm() {}

}
