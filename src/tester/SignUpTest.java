package tester;

import helper.Helper;
import helper.Locators;

public class SignUpTest {

	
	public static void signup_page_test_cases() throws InterruptedException
	{
		Helper.open_Hamburger_menu(); // open Hamburger menu
		Helper.sleep();
		Helper.button_click_id(Locators.signup_text);// click on sign up text field
		Helper.sleep();
		
		//signup_with_invalid_credentials(); // 1st test case, invalid cred signup
		
		already_have_account(); // go to login page
		
		forget_login_password(); // 2nd test case
		
		Helper.navigate_back(); // go to hamburger menu again
		Helper.sleep();
		System.out.println("in home page with Hampurger menu");
		Helper.button_click_id(Locators.signup_text);// click on sign up text field
		Helper.sleep();
		
		//signup_with_Facebook_Account(); // 3rd test case
		//Helper.navigate_back();
		
		already_have_account(); // go to login page again
		
		login_with_Facebook(); // 6th test case
		Helper.navigate_back();
		
		login_with_invalid_credentials(); // 4th test case
		
		open_signup_page_from_login_page(); //5th test case
		
		already_have_account(); // go to login page again
				
		login_with_valid_credentials(); // 7th test case
		
		Helper.logout(); // logout
	}

	private static void login_with_Facebook() throws InterruptedException 
	{
		Helper.button_click_id(Locators.login_Facebook);
		Helper.sleep();
		Helper.console_print("login with Facebook Account test case is passed");
		Helper.sleep();
	}

	private static void open_signup_page_from_login_page() throws InterruptedException 
	{
		
		Helper.button_click_id(Locators.login_signup);
		Helper.sleep();
		Helper.console_print("open signup page from login page test case is passed");
		Helper.sleep();
		
	}

	private static void signup_with_invalid_credentials() throws InterruptedException
	{
		String username="archie@gmail.com";
		String password="archie";
		String confirm_password="archxghhh";
		String result;
		
		Helper.sendkeys_id(Locators.reg_user_name, username); // enter user name
		Helper.sendkeys_id(Locators.reg_password, password); // enter password
		Helper.sendkeys_id(Locators.reg_confirm_password, confirm_password); //enter confirm password
		Helper.hide_keyboard(); //hide keyboard
		Helper.sleep();
		
		Helper.button_click_id(Locators.reg_check_terms); // mark terms as accepted
		Helper.button_click_id(Locators.reg_register_button); // press register button
		result = Helper.text_print_id(Locators.error_text); // take the result of registering
		Helper.sleep();
		
		Helper.button_click_id(Locators.error_ok_button); // press OK for error message
		
		Helper.console_print(result); // print the result
		Helper.console_print("Signup with invalid credentials test case is passed");
		Helper.sleep();
	
	}

	private static void already_have_account() throws InterruptedException
	{
		Helper.button_click_id(Locators.reg_already_have_account_test_button);
		Helper.sleep();
		Helper.console_print("we are in login page");
		Helper.sleep();
	}
	
	private static void forget_login_password() throws InterruptedException
	{
		String wrong_user_name ="wehfak@gmail.com";
		String result;
		
		Helper.button_click_id(Locators.login_forget_password); // click on forget password text buttom
		Helper.sleep();
		Helper.sendkeys_id(Locators.login_forget_password_mail_text, wrong_user_name); // enter invalid user name
		Helper.sleep();
		Helper.button_click_id(Locators.forget_pass_login_button);
		
		result = Helper.text_print_id(Locators.error_text); // take the result of registering
		Helper.sleep();
		
		Helper.button_click_id(Locators.error_ok_button); // press OK for error message
		
		Helper.console_print(result); // print the result
		Helper.console_print("forget login password test case is passed");
		Helper.sleep();
		Helper.navigate_back(); // dismiss the forget password dialog
		Helper.sleep();
	}
	
	private static void signup_with_Facebook_Account() throws InterruptedException
	{
		Helper.button_click_id(Locators.reg_Facebook);
		Helper.sleep();
		Helper.console_print("signup with Facebook Account test case is passed");
		Helper.sleep();
	}
	
	private static void login_with_invalid_credentials() throws InterruptedException 
{
		String username="rachel@gmail.com";
		String password="rasfgjk";
		String result;
		Helper.sendkeys_id(Locators.login_email_text, username); // enter user name
		Helper.sendkeys_id(Locators.login_password, password); // enter password
		Helper.hide_keyboard(); //hide keyboard
		Helper.sleep();
		Helper.button_click_id(Locators.login_button); // press login button
		result = Helper.text_print_id(Locators.error_text); // take the result of login
		Helper.sleep();
		
		Helper.button_click_id(Locators.error_ok_button); // press OK for error message
		
		Helper.console_print(result); // print the result
		Helper.console_print("login with invalid credentials test case is passed");
		Helper.sleep();
	}

	private static void login_with_valid_credentials() throws InterruptedException 
	{
		String username="rachel@gmail.com";
		String password="rachel";
		
		Helper.sendkeys_id(Locators.login_email_text, username); // enter user name
		Helper.sendkeys_id(Locators.login_password, password); // enter password
		//Helper.hide_keyboard(); //hide keyboard
		Helper.sleep();
		Helper.button_click_id(Locators.login_button); // press login button
		Helper.sleep();
		Helper.dismiss_alert(); // press no on system alert dialog
		Helper.sleep();
		Helper.console_print("login with valid credentials test case is passed");
	}

}
