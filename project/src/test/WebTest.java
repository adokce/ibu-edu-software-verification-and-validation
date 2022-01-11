package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
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
			System.out.println(windowsChromeDriverPath);
			System.setProperty("webdriver.chrome.driver", windowsChromeDriverPath);
		} else {
			String linuxChromeDriverPath = projectPath + "/external-libs/chromedriver_linux64/chromedriver";
			System.out.println(linuxChromeDriverPath);
			System.setProperty("webdriver.chrome.driver", linuxChromeDriverPath);
		}

		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		baseUrl = "https://google.com/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(2000);
	}

}
