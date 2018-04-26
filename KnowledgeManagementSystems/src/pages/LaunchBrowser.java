package pages;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
	public static WebDriver driver;

	public static WebDriver setup() {
		try {
			String browser = PropertiesRead.read().getProperty("browser");
			if (browser.toLowerCase().equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://qkmsnapshots.deloitte.com/");
				return driver;
			}
		} catch (SessionNotCreatedException e) {
			System.out.println("Session Couldn't be created");
		}
		return driver = null;
	}
}
