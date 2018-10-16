package com.mindtree.executionclasses;

import java.io.FileNotFoundException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import com.mindtree.pageobjects.AmazonHomePagePageObjects;
import com.mindtree.pageobjects.AmazonLogOutPagePageObjects;
import com.mindtree.pageobjects.AmazonLoginPagePageObjects;
import com.mindtree.reusablecomponents.BaseClass;
import org.junit.runners.MethodSorters;

/**
 * This is an execution class to run all Amazon JUnit tests
 * 
 * @author M1046633
 *
 */

// Sorts test methods by name
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Amazon extends BaseClass {

	@Test
	public void amazonLoginTest() throws Exception {

		AmazonLoginPagePageObjects.amazonLogin();

	}

	@Test
	public void amazonLogOutTest() throws FileNotFoundException {

		AmazonLogOutPagePageObjects.amazonLogOut();

	}

	@Test
	public void amazonSearchTest() throws Exception {

		AmazonHomePagePageObjects.amazonSearch();

	}

}
