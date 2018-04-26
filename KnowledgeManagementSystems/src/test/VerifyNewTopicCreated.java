package test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.EditTopic;
import pages.HomePage;
import pages.LaunchBrowser;
import pages.PropertiesRead;
import pages.Qauth;
import pages.ScrolltoView;
import pages.NewTopic;

public class VerifyNewTopicCreated extends LaunchBrowser {
	private Qauth quath;
	private String NewtopicName,generatedTopicLocator;
	private NewTopic topic;
	private EditTopic edittopic;

	@BeforeTest
	public void launch() {
		quath = new Qauth(LaunchBrowser.setup());
	}

	@Parameters({ "username", "password", "topicName" })
	@Test
	public void NaviagteToHomePage(String username, String password, String topicName) throws InterruptedException {
		HomePage homepage = quath.loginToKMS(username, password);
		topic = homepage.clickOnThreeDots();
		NewtopicName = topicName + " " + new Date();
		topic.setTopicTitle(NewtopicName);
		topic.setTopicAdminstrators(PropertiesRead.read().getProperty("topicAdminstrator"));
		topic.clickSaveTopic();
		topic.verifySuccessMessageDisplay();
	}

	@Test(dependsOnMethods = "NaviagteToHomePage", alwaysRun = true)
	public void verifyTopicCreated() throws InterruptedException {
		Thread.sleep(3000);
		ScrolltoView.scrollTo(driver, ".//*[@title='" + NewtopicName + "']");
		WebElement generatedTopicLocator = driver.findElement(By.xpath(".//*[@title='" + NewtopicName + "']"));
		ScrolltoView.hoverOverOnElement(driver, generatedTopicLocator);
	}

	@Test(dependsOnMethods = ("verifyTopicCreated"), alwaysRun = false)
	public void verifyTopicEdited() {
		topic.editTopic(generatedTopicLocator);
	
	}

}
