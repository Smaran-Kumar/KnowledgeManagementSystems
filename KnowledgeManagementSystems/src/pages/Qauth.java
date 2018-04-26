package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Qauth extends LaunchBrowser {
	WebDriver driver;

	public Qauth(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ".//span[contains(text(),'qauth.us.deloitte.com')]")
	private WebElement quathLink;

	@FindBy(how = How.XPATH, using = ".//*[@id='userNameInput']")
	private WebElement usernameInput;

	@FindBy(how = How.XPATH, using = ".//*[@id='passwordInput']")
	private WebElement passwordInput;

	@FindBy(how = How.XPATH, using = ".//*[@id='submitButton']")
	private WebElement submitButton;

	public HomePage loginToKMS(String username, String password) {
		quathLink.click();
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		submitButton.click();
		try{
		return new HomePage(driver);
		}
		catch(org.openqa.selenium.TimeoutException e)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				System.out.println("Timeout : Interreputed");
			}
			return new HomePage(driver);
		}
	}

}
