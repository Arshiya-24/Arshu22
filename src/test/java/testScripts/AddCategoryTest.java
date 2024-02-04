package testScripts;
import java.util.Locale.Category;
import java.util.Map;
//This test verifies if user is able to create Category

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IConstantPath;

public class AddCategoryTest extends BaseClass
{
	@Test
	public void addCategoryTest()
	{
		SoftAssert soft=new SoftAssert();
		homepage.clickCoursesTab();
		homepage.clickCategoryLink();
		Category.clickNewButton();
		Thread.sleep(3000);
		soft.assertEquals(addCategory.getpageHeader(), "Add New Category");
		
		Map<String, String> map=excelutility.readFromExcel("Add Category");
		addCategory.setName(map.get("Name"));
		addCategory.clickSave();
		
		soft.assertEquals(addCategory.getsuccessMessage(),  "Success!");
		Category.deletecategory(web, map.get("Name"));
		soft.assertEquals(addCategory.getsuccessMessage(),  "Success!");
		if(addCategory.getsuccessMessage().equals("Success!"));
		excelutility.updateTestStatus("Add Category", "Pass", IConstantPath.EXCEL_PATH);
		
			excelutility.updateTestStatus("Add Category", "Fail", IConstantPath.EXCEL_PATH);
		
		soft.assertAll();
	}
}
		


