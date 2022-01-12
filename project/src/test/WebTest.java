package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class WebTest {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		String osName = System.getProperty("os.name").toLowerCase();
		String projectPath = System.getProperty("user.dir");

		if (osName.equals("windows 10")) {
			String windowsChromeDriverPath = projectPath + "\\external-libs\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", windowsChromeDriverPath);
		} else {
			String linuxChromeDriverPath = projectPath + "/external-libs/chromedriver_linux64/chromedriver";
			System.setProperty("webdriver.chrome.driver", linuxChromeDriverPath);
		}

		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		baseUrl = "https://www.demoblaze.com/";

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}

	@Test
	void testContactModalTitle() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(1000);

		WebElement contactNavLink = webDriver.findElement(By.cssSelector("li.nav-item:nth-child(2) > a:nth-child(1)"));
		contactNavLink.click();
		Thread.sleep(1000);

		WebElement aboutModalTitle = webDriver.findElement(By.cssSelector("#exampleModalLabel"));
		assertEquals(aboutModalTitle.getText(), "New message");
	}

	@Test
	void testContactModalFormSubmit() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(1000);

		WebElement aboutNavLink = webDriver.findElement(By.cssSelector("li.nav-item:nth-child(2) > a:nth-child(1)"));
		aboutNavLink.click();
		Thread.sleep(1000);
		
		WebElement email = webDriver.findElement(By.id("recipient-email"));
		WebElement name = webDriver.findElement(By.id("recipient-name"));
		WebElement text = webDriver.findElement(By.id("message-text"));
		WebElement submitButton = webDriver.findElement(By.cssSelector("#exampleModal > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)"));
		
		email.sendKeys("adotest@yopmail.com");
		name.sendKeys("Ado Tester");
		text.sendKeys("Bas vam je dobra ova stranica");
		submitButton.click();
		Thread.sleep(2000);
		
		Alert alert = webDriver.switchTo().alert();
        alert.accept();

		Thread.sleep(2000);
	}
	

	@Test
	void testContactModalFormCancel() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(1000);

		WebElement aboutNavLink = webDriver.findElement(By.cssSelector("li.nav-item:nth-child(2) > a:nth-child(1)"));
		aboutNavLink.click();
		Thread.sleep(1000);
		
		WebElement cancelButton = webDriver.findElement(By.cssSelector("#exampleModal > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(1)"));
		
		cancelButton.click();
		Thread.sleep(2000);
	}

	@Test
	void testAboutModalTitle() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(1000);

		WebElement aboutNavLink = webDriver.findElement(By.cssSelector("li.nav-item:nth-child(3) > a:nth-child(1)"));
		aboutNavLink.click();
		Thread.sleep(1000);

		WebElement aboutModalTitle = webDriver.findElement(By.cssSelector("#videoModalLabel"));
		assertEquals(aboutModalTitle.getText(), "About us");
	}
}
