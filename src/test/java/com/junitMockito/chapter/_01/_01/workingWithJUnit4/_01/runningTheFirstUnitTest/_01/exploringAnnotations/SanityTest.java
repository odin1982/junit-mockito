package com.junitMockito.chapter._01._01.workingWithJUnit4._01.runningTheFirstUnitTest._01.exploringAnnotations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SanityTest {
	@BeforeClass
	public static void beforeClass() {
		System.out.println("***Before class is invoked");
	}
	
	@Before
	public void before() {
		System.out.println("_______________");
		System.out.println("\t Before is invoked");
	}
	
	@After
	public void after() {
		System.out.println("\t After is invoked");
		System.out.println("==============");
	}
	
	@Test
	public void someTest() {
		System.out.println("\t\t someTest is invoked");
	}
	
	@Test
	public void someTest2() {
		System.out.println("\t\t someTest2 is invoked");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("***After Class is invoked");
	}
	
}
