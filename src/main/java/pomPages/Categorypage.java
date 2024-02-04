package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class Categorypage {

//Declaration
	@FindBy(xpath= "//h1[normalize-space(text())='Category']")
	private WebElement pageHeader;
	
	@FindBy(xpath= "//a[text()='New']")
	private WebElement newButton;
	
	private String deletepath="//td[text()='%s']/ancestor::tr/descendant::button[text()='Delete']";
			
			@FindBy(name="delete")
	private WebElement deleteButton;
	
	@FindBy(xpath="//h4[text()='Success!']")
	private WebElement successMessage;
	
	//Initialization
	public Categorypage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public String getpageHeader() {
		return pageHeader.getText();
	}
	public void clickNewButton() {
		newButton.click();
	}
	public void deleteCategory(WebDriverUtility web, String categoryName) {
		web.convertPathToWebelement(deletepath, categoryName).click();
		deleteButton.click();
	}
	public String getSuccessMessage() {
		return successMessage.getText();
	}
	}
	
	
	
	
