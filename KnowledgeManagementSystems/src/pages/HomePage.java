package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.WaitFluent;

public class HomePage {

	WebDriver driver;
	String mainHeadingText = ".//span[contains(text(),'RRA Topic Area (Home)')]";
	private By addNewTopicButton = By.xpath(".//*[contains(text(),'New Topic Area')]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyHeading() {
		WaitFluent.waitTillElementVisibile(driver, mainHeadingText);
	}

	private By threeDots = By.xpath(".//*[@id='areaContext']/preceding-sibling::*/i");

	public NewTopic clickOnThreeDots() throws InterruptedException {
		verifyHeading();
		driver.findElement(threeDots).click();
		driver.findElement(addNewTopicButton).click();
		return new NewTopic(driver);

	}
}
