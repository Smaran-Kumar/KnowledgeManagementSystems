package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class WaitFluent {
	public static void waitTillElementVisibile(WebDriver driver, String xpath) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(100, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.NANOSECONDS).ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver,WebElement>(){

			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(xpath));
			}});
	}
}
