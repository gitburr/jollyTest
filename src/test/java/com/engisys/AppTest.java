package com.engisys;

import java.time.LocalDate;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
	    	try {
	    		Set<LocalDate> test = App.setHolidays();
	    		assertNotNull("Test is null", test);
	    		Assert.assertTrue((test.size()>0));
	    		System.out.println("test has " + test.size() + " entries");
	    	} catch (Throwable t) {
	    		t.printStackTrace();
	    		fail("Exception received");
	    	}
    }
}
