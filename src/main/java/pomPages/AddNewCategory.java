package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class AddNewCategory {

//Declaration
	@FindBy(xpath="//b[text()='Add New Category']")
	private WebElement pageHeader;
	
	@FindBy(id="name")
	private WebElement nameTF;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	//Initialization
	public AddNewCategory(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public String getpageHeader() {
		return pageHeader.getText();
	}
	public  void setName(String courseName) {
		nameTF.sendKeys(courseName);
	}
	public String getsuccessMessage()
	{
		return getsuccessMessage();
	}

	public void clickSave() {
		saveButton.click();
	}
}


	
	

	

	


	
		