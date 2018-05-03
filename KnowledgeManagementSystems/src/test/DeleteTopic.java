package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LaunchBrowser;
import pages.Qauth;
import pages.ScrolltoView;

public class DeleteTopic extends LaunchBrowser{
	private Qauth login;
	@BeforeClass
	public void launch() {
		login = new Qauth(LaunchBrowser.setup());
	}
	
	@Parameters({ "username", "password", "deleteTopicName" })
	@Test
	public void DeleteTopic1(String username, String password,String deleteTopicName)
			throws Exception {
		
		HomePage newhomepage=login.loginToKMS(username, password);
	    Thread.sleep(5000);
	    newhomepage.DeleteNewTopic(deleteTopicName);
	
}
	

	@AfterClass
	public void tearDown(){
		
		driver.close();
	}

}

