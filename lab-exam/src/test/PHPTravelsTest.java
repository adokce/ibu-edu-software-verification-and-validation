package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class PHPTravelsTest {
	private static WebDriver webDriver;
	private static String baseUrl = "https://www.phptravels.net/";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/home/adokce/repos/uni/ibu-edu-software-verification-and-testing/external-libs/chromedriver_linux64/chromedriver");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(1000);

		WebElement flightsLink = webDriver.findElement(By.cssSelector(
				"body > header > div.header-menu-wrapper.padding-right-100px.padding-left-100px > div > div > div > div > div.main-menu-content > nav > ul > li:nth-child(3) > a"));
		flightsLink.click();
		Thread.sleep(1000);

		WebElement roundTripLabel = webDriver.findElement(By.cssSelector(
				"#fadein > form > div.row.mb-3.g-1 > div.col-md-4.flight_types > div > div:nth-child(2) > div > label"));
		roundTripLabel.click();
		Thread.sleep(1000);

		WebElement flightClass = webDriver.findElement(By.cssSelector("#flight_type"));
		Select flightClassSelect = new Select(flightClass);
		flightClassSelect.selectByVisibleText("First");

		Thread.sleep(1000);

		WebElement from = webDriver.findElement(By.cssSelector("#autocomplete"));
		from.click();
		Thread.sleep(1000);

		from.sendKeys("LGA");

		Thread.sleep(2000);

		WebElement firstResultFrom = webDriver.findElement(By.cssSelector(
				"#onereturn > div.col-md-6 > div > div:nth-child(1) > div > div > div > div > div:nth-child(1)"));
		firstResultFrom.click();
		Thread.sleep(1000);

		WebElement to = webDriver.findElement(By.cssSelector("#autocomplete2"));

		to.click();
		Thread.sleep(1000);

		to.sendKeys("MIA");

		Thread.sleep(2000);

		WebElement firstResultTo = webDriver.findElement(By.cssSelector(
				"#onereturn > div.col-md-6 > div > div:nth-child(2) > div > div > div > div > div:nth-child(1)"));
		firstResultTo.click();
		Thread.sleep(1000);

		WebElement search = webDriver.findElement(By.cssSelector("#flights-search > span.ladda-label"));
		search.click();
		Thread.sleep(1000);

		WebElement firstResult = webDriver.findElement(By.linkText("Book Now"));
//		WebElement firstResult = webDriver.findElement(By.cssSelector("#MixItUp0C24DE > ul > li:nth-child(1) > div > form > div > div.col-md-2 > div > button > span"));
		firstResult.click();
		Thread.sleep(1000);

	}

}
