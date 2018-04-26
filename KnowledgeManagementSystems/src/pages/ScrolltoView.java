package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrolltoView {

	private static By element;

	public static void scrollToUsingXpath(WebDriver driver, String xpath) throws InterruptedException {

		element = By.xpath(xpath);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", driver.findElement(element));
		Thread.sleep(500);
	}
	public static void scrollToUsingBy(WebDriver driver, By by) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", driver.findElement(by));
		Thread.sleep(500);
	}
	
	public static void scrollToUsingWebElement(WebDriver driver, WebElement element) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
		Thread.sleep(500);
	}

	public static void hoverOverOnElement(WebDriver driver,WebElement element) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		Thread.sleep(2000);
		element.click();
	}
}
