package com.junitMockito.chapter._01._01.workingWithJUnit4._01.runningTheFirstUnitTest._02.verifyingTestConditionsWithAssertion;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssertTest {

    @Test
    public void assertTrueAndFalseTest() throws Exception{
        Assert.assertTrue(true);
        Assert.assertFalse(false);
    }

    @Test
    public void assertNullAndNotNullTest() throws Exception{
        Object myObject = null;
        Assert.assertNull(myObject);
        myObject = new String("Some value");
        Assert.assertNotNull(myObject);
    }

    // only the values are compared, not the references
    @Test
    public void assertEqualsTest() throws Exception{
        Integer i = new Integer("5");
        Integer j = new Integer("5");
        assertEquals(i,j);
    }

    // es verdadero si hacen referencia a diferentes objetos
    @Test
    public void assertNotSameTest() throws Exception {
        Integer i = new Integer("5");
        Integer j = new Integer("5");;
        assertNotSame(i , j);
    }

    // es verdadero si tienen la misma referencia
    @Test
    public void assertSameTest() throws Exception {
        Integer i = new Integer("5");
        Integer j = i;
        assertSame(i,j);
    }
}
