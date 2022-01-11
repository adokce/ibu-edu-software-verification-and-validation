package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class MOPTest {
	private static WebDriver webDriver;
	private static String baseUrl = "https://www.ministryofprogramming.com/";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/adokce/repos/uni/ibu-edu-software-verification-and-testing/external-libs/chromedriver_linux64/chromedriver");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}

	@Test
	void test() throws InterruptedException{
		webDriver.get(baseUrl);
		Thread.sleep(1000);
		
		WebElement teamLink = webDriver.findElement(By.cssSelector("#__next > div.Layout__Grid-c9d8yh-0.cCsMXE > header > div > nav > a:nth-child(5)"));
		teamLink.click();
		
		Thread.sleep(1000);

		WebElement headerText = webDriver.findElement(By.cssSelector("#__next > div.Layout__Grid-c9d8yh-0.cCsMXE > main > div.Container__StyledContainer-q68b95-0.gYnweh > div.team__DisplayWrapper-e37ft8-0.bEVbQY > div"));
		Thread.sleep(1000);
		
		assertEquals(headerText.getText(),"Meet our people");

	}

}
