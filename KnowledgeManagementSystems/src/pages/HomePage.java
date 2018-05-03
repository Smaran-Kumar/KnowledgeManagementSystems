package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import common.WaitFluent;

public class HomePage {

	public static WebDriver driver;
	String mainHeadingText = ".//span[contains(text(),'RRA Topic Area (Home)')]";
	private By addNewTopicButton = By.xpath(".//*[contains(text(),'New Topic Area')]");
	@FindBy(how = How.XPATH, using = ".//*[@id='De']")
	private WebElement editManageTopic;
	@FindBy(how = How.XPATH, using = ".//*[@id='delete']")
	public WebElement deleteopton;
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
	
	public void DeleteNewTopic(String deleteTopicName ) throws Exception{
		verifyHeading();
		ScrolltoView.scrollToUsingXpath(driver,".//*[@title='"+deleteTopicName+"']" );
		WebElement deleteTopicLocator=driver.findElement(By.xpath(".//*[@title='"+deleteTopicName+"']"));
		ScrolltoView.hoverOverOnElement(driver,deleteTopicLocator);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//span[@title='"+deleteTopicName+"']/parent::span/following-sibling::*/child::span/child::i")).click();
		driver.findElement(By.xpath(".//*[@id='delete']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
}}
