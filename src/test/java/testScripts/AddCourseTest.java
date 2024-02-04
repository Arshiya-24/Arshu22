package testScripts;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IConstantPath;

public class AddCourseTest extends BaseClass
{
	@Test(groups="smoke")
	public void addCourseTest()
	{
		SoftAssert soft=new SoftAssert();
		homepage.clickCoursesTab();
		homepage.clickCourseListLink();
		soft.assertTrue(courseListpage.getpageHeader().contains("Course List"));
		courseListpage.clickNewButton();
		soft.assertEquals(addCourse.getpageHeader(),  "Add New Course");		
		Map<String,String> map=excelutility.readFromExcel("Add Course");
		addCourse.setName(map.get("Name"));
 		addCourse.selectCategory(web, map.get("Category"));
 		addCourse.setprice(map.get("price"));
 		addCourse.uploadPhoto(map.get("Photo"));
 		addCourse.setDescription(map.get("Description"), web);
 		addUser.clickSave();
 		
 		
 		soft.assertEquals(courseList.getSuccessMessage(), "Success!");
 		courseList.deleteCourse(web, map.get("Name"));
 		soft.assertEquals(courseList.getSuccessMessage(), "Success!");
 	

		if(courseListpage.getSuccessMessage().equals("Success!"))
			excelutility.updateTestStatus("Add Course", "pass", IConstantPath.EXCEL_PATH);
		else
			excelutility.updateTestStatus("Add Course", "Fail", IConstantPath.EXCEL_PATH);
		soft.assertAll();
		
		
		
	}
}


		
	

		
	

		
	

		
		
		
		
		
	
