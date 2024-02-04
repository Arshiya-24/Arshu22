package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;

	 public class AddUserTest extends BaseClass
	 {
	 	@Test(groups="smoke")
	 	public void AddUserTest()
	 	{
	 		SoftAssert soft=new SoftAssert();
	 		homepage.UsersTab();
	 		soft.assertTrue(Userspage.getpageHeader().contains("Users"));
	 		Userspage.clickNewButton();
	 		soft.assertEquals(addUser.getpageHeader(), "Add New User");
	 		Map<String, String> map=excelutility.readFromExcel("Add User");
	 		
	 		addUser.setEmail(map.get("Email"));
	 		addUser.setPassword(map.get("Password"));
	 		addUser.setFirstname(map.get("Firstname"));
	 		addUser.setLastname(map.get("Lastname"));
	 		addUser.setAddress(map.get("Address"));
	 		addUser.setContactInfo(map.get("Contact Info"));
	 		addUser.uploadPhoto(map.get("photo"));
	 		addUser.clickSave();
	 		
	 		soft.assertEquals(Userspage.getSuccessMessage(), "Success!");
	 		soft.assertAll();
	 	}
	 }
	 		
	 	
	 	