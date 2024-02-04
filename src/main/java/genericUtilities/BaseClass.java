package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pomPages.AddNewCategory;
import pomPages.AddNewCoursepage;
import pomPages.AddnewUserpage;
import pomPages.Categorypage;
import pomPages.Homepage;
import pomPages.Loginpage;
import pomPages.Userspage;
import pomPages.courseListpage;

public class BaseClass {
	 protected WebDriver driver;
	protected PropertiesUtility property;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected ExcelUtility excelutility;
	protected Loginpage login;
	protected Homepage homepage;
	protected Userspage Userspage;
	protected courseListpage courseListpage;
	protected Categorypage Categorypage;
	protected AddnewUserpage addUser;
	protected AddnewUserpage addCourse;
	protected AddNewCategory addCategory;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	

//@BeforeSuite
	//@BeforeTest
	
	//@BeforeClass
	public void classSetup() {
	web=new WebDriverUtility();
	jutil=new JavaUtility();
	property=new PropertiesUtility();
	excelutility=new ExcelUtility();
	property.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
	driver=web.launchBrowserAndMaximize(property.readFromProperties("browser"));
	web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
	
	sdriver = driver;
	sjutil = jutil;
	
	}
	//@BeforeMethod
	public void methodSetup() {
		login=new Loginpage(driver);
		homepage=new Homepage(driver);
		Userspage=new Userspage(driver);
		courseListpage=new courseListpage(driver);
		Categorypage=new Categorypage(driver);
		addCourse=new AddnewUserpage(driver);
		courseListpage=new courseListpage(driver);
		addCategory=new AddNewCategory(driver);
		
		excelutility.excelInit(IConstantPath.EXCEL_PATH, "Sheet1");
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getpageHeader(), "Login");
		login .loginToApp(property.readFromProperties("username"),property.readFromProperties("password"));
		property.readFromProperties("password");
		Assert.assertEquals(homepage.getpageHeader(), "Home");
	}
	//@AfterMethod
	public void methodTearDown() {
	excelutility.closeExcel();
	homepage.signOutOfApp();
	}
		
	//@AfterClass
	public void classTearDown()
	{	
		web.quitAllWindows();
	}
	//@AfterSuite
	//@AfterTest
	}
//@AfterSuite
//@AfterTest
	


	
	
	
	
