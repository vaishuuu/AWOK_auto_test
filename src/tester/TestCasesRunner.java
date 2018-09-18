package tester;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import helper.Helper;

public class TestCasesRunner {

	@Test(priority=0,description="signup and login test cases")
	public void run_test_cases() throws MalformedURLException, InterruptedException 
	{
		
		Helper.app_luncher();
		Helper.tutorial_page_done();
		Helper.country_language_page();
		SignUpTest.signup_page_test_cases();
		
	}
	
}
