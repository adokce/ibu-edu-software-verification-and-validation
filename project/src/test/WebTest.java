package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	@Test
	void loginFail() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(2000);
		
		WebElement loginButton = webDriver.findElement(By.id("login2"));
		loginButton.click();
		Thread.sleep(2000);
		
		WebElement falseUsername = webDriver.findElement(By.xpath("//*[@id=\"loginusername\"]"));
		falseUsername.sendKeys("JohnDoe");
		Thread.sleep(2000);
		
		WebElement falsePassword = webDriver.findElement(By.xpath("//*[@id=\"loginpassword\"]"));
		falsePassword.sendKeys("12345678");
		Thread.sleep(2000);
		
		WebElement falseLogin = webDriver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
		falseLogin.click();
		Thread.sleep(2000);
		
		Alert alertLogin = webDriver.switchTo().alert();
		assertEquals(alertLogin.getText(),"Wrong password.");
		
		alertLogin.accept();
		Thread.sleep(1500);
	}
	
	@Test
	void loginSuccess() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(2000);
		
		WebElement loginButton = webDriver.findElement(By.id("login2"));
		loginButton.click();
		Thread.sleep(2000);

		WebElement username = webDriver.findElement(By.xpath("//*[@id=\"loginusername\"]"));
		username.sendKeys("EdinDzeko");
		Thread.sleep(2000);
		
		WebElement password = webDriver.findElement(By.xpath("//*[@id=\"loginpassword\"]"));
		password.sendKeys("12345678");
		Thread.sleep(2000);
		
		WebElement logIn = webDriver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
		logIn.click();
		Thread.sleep(2000);
		
		assertEquals("Welcome EdinDzeko", webDriver.findElement(By.xpath("/html/body/nav/div[1]/ul/li[7]/a")).getText());
		Thread.sleep(2000);
	}
	
	@Test
	void loginLogout() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(2000);
		
		WebElement loginButton = webDriver.findElement(By.id("login2"));
		loginButton.click();
		Thread.sleep(2000);

		WebElement username = webDriver.findElement(By.xpath("//*[@id=\"loginusername\"]"));
		username.sendKeys("EdinDzeko");
		Thread.sleep(2000);
		
		WebElement password = webDriver.findElement(By.xpath("//*[@id=\"loginpassword\"]"));
		password.sendKeys("12345678");
		Thread.sleep(2000);
		
		WebElement logIn = webDriver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
		logIn.click();
		Thread.sleep(2000);
		
		assertEquals("Welcome EdinDzeko", webDriver.findElement(By.xpath("/html/body/nav/div[1]/ul/li[7]/a")).getText());
		Thread.sleep(2000);
		
		WebElement logOut = webDriver.findElement(By.cssSelector("#logout2"));
		logOut.click();
		
		WebElement logIn2 = webDriver.findElement(By.cssSelector("#login2"));
		assertEquals(logIn2.getText(), "Log in");
		
		Thread.sleep(2000);
	}
	
	@Test
	void purchase() throws InterruptedException {
		webDriver.get(baseUrl);
		
		JavascriptExecutor js = (JavascriptExecutor) webDriver;

		Thread.sleep(2000);
		
		WebElement s6 = webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a"));
		s6.click();
		Thread.sleep(2000);
		
		WebElement cart1 = webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
		cart1.click();
		Thread.sleep(2000);
		
		Alert alertCart = webDriver.switchTo().alert();
		alertCart.accept();
		Thread.sleep(1500);
		
		WebElement goHome = webDriver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a"));
		goHome.click();
		Thread.sleep(2000);
		
		WebElement next = webDriver.findElement(By.xpath("//*[@id=\"next2\"]"));
		js.executeScript("arguments[0].scrollIntoView();", next);
		Thread.sleep(2000);
		next.click();
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(1000);
		WebElement dell = webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[4]/div/div/h4/a"));
		dell.click();
		Thread.sleep(2000);
		
		WebElement cart2 = webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
		cart2.click();
		Thread.sleep(2000);
		
		Alert alertDell = webDriver.switchTo().alert();
		alertDell.accept();
		Thread.sleep(1500);
		
		WebElement home2 = webDriver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a"));
		home2.click();
		Thread.sleep(2000);
		
		WebElement cart = webDriver.findElement(By.xpath("//*[@id=\"cartur\"]"));
		cart.click();
		Thread.sleep(2000);
		
		WebElement deleteDell = webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[4]/a"));
		deleteDell.click();
		Thread.sleep(2000);
		
		WebElement placeOrder = webDriver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
		placeOrder.click();
		Thread.sleep(2000);
		
		WebElement orderName = webDriver.findElement(By.xpath("//*[@id=\"name\"]"));
		orderName.sendKeys("Edin Dzeko");
		Thread.sleep(1000);
		
		WebElement orderCountry = webDriver.findElement(By.xpath("//*[@id=\"country\"]"));
		orderCountry.sendKeys("Italy");
		Thread.sleep(1000);
		
		WebElement orderCity = webDriver.findElement(By.xpath("//*[@id=\"city\"]"));
		orderCity.sendKeys("Milano");
		Thread.sleep(1000);
		
		WebElement orderCreditCard = webDriver.findElement(By.xpath("//*[@id=\"card\"]"));
		orderCreditCard.sendKeys("87654321");
		Thread.sleep(1000);
		
		WebElement orderMonth = webDriver.findElement(By.xpath("//*[@id=\"month\"]"));
		orderMonth.sendKeys("08");
		Thread.sleep(1000);
		
		WebElement orderYear = webDriver.findElement(By.xpath("//*[@id=\"year\"]"));
		orderYear.sendKeys("2024");
		Thread.sleep(1000);
		
		WebElement orderPurchase = webDriver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
		orderPurchase.click();
		Thread.sleep(1000);
		
		WebElement message = webDriver.findElement(By.cssSelector("body > div.sweet-alert.showSweetAlert.visible > h2"));
		
		assertEquals("Thank you for your purchase!", message.getText());
		
		WebElement confirmPurchase = webDriver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button"));
		confirmPurchase.click();
		Thread.sleep(1000);
	}

	@Test
	void purchaseEmptyCart() throws InterruptedException {
		webDriver.get(baseUrl);
		
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		WebElement cart = webDriver.findElement(By.xpath("//*[@id=\"cartur\"]"));
		cart.click();
		Thread.sleep(2000);
		
		WebElement placeOrder = webDriver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
		placeOrder.click();
		Thread.sleep(2000);
		
		WebElement orderName = webDriver.findElement(By.xpath("//*[@id=\"name\"]"));
		orderName.sendKeys("Edin Dzeko");
		Thread.sleep(1000);
		
		WebElement orderCountry = webDriver.findElement(By.xpath("//*[@id=\"country\"]"));
		orderCountry.sendKeys("Italy");
		Thread.sleep(1000);
		
		WebElement orderCity = webDriver.findElement(By.xpath("//*[@id=\"city\"]"));
		orderCity.sendKeys("Milano");
		Thread.sleep(1000);
		
		WebElement orderCreditCard = webDriver.findElement(By.xpath("//*[@id=\"card\"]"));
		orderCreditCard.sendKeys("87654321");
		Thread.sleep(1000);
		
		WebElement orderMonth = webDriver.findElement(By.xpath("//*[@id=\"month\"]"));
		orderMonth.sendKeys("08");
		Thread.sleep(1000);
		
		WebElement orderYear = webDriver.findElement(By.xpath("//*[@id=\"year\"]"));
		orderYear.sendKeys("2024");
		Thread.sleep(1000);
		
		WebElement orderPurchase = webDriver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
		orderPurchase.click();
		Thread.sleep(2000);
		
		WebElement message = webDriver.findElement(By.cssSelector("body > div.sweet-alert.showSweetAlert.visible > h2"));
		String messageText = message.getText();
		
		WebElement confirmPurchase = webDriver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button"));
		confirmPurchase.click();
		Thread.sleep(2000);
		
		assertNotEquals("Thank you for your purchase!", messageText);
	}
	
	@Test
	void purchaseFormValidation() throws InterruptedException {
		webDriver.get(baseUrl);
		
		JavascriptExecutor js = (JavascriptExecutor) webDriver;

		Thread.sleep(2000);
		
		WebElement s6 = webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a"));
		s6.click();
		Thread.sleep(2000);
		
		WebElement cart1 = webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
		cart1.click();
		Thread.sleep(2000);
		
		Alert alertCart = webDriver.switchTo().alert();
		alertCart.accept();
		Thread.sleep(1500);
		
		WebElement goHome = webDriver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a"));
		goHome.click();
		Thread.sleep(2000);
		
		WebElement next = webDriver.findElement(By.xpath("//*[@id=\"next2\"]"));
		js.executeScript("arguments[0].scrollIntoView();", next);
		Thread.sleep(2000);
		next.click();
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(1000);
		WebElement dell = webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[4]/div/div/h4/a"));
		dell.click();
		Thread.sleep(2000);
		
		WebElement cart2 = webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
		cart2.click();
		Thread.sleep(2000);
		
		Alert alertDell = webDriver.switchTo().alert();
		alertDell.accept();
		Thread.sleep(1500);
		
		WebElement home2 = webDriver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a"));
		home2.click();
		Thread.sleep(2000);
		
		WebElement cart = webDriver.findElement(By.xpath("//*[@id=\"cartur\"]"));
		cart.click();
		Thread.sleep(2000);
		
		WebElement deleteDell = webDriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[4]/a"));
		deleteDell.click();
		Thread.sleep(2000);
		
		WebElement placeOrder = webDriver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
		placeOrder.click();
		Thread.sleep(2000);
		
		WebElement orderName = webDriver.findElement(By.xpath("//*[@id=\"name\"]"));
		orderName.sendKeys("Edin Dzeko");
		Thread.sleep(1000);
		
		WebElement orderCountry = webDriver.findElement(By.xpath("//*[@id=\"country\"]"));
		orderCountry.sendKeys("Italy");
		Thread.sleep(1000);
		
		WebElement orderCity = webDriver.findElement(By.xpath("//*[@id=\"city\"]"));
		orderCity.sendKeys("Milano");
		Thread.sleep(1000);
		
		WebElement orderCreditCard = webDriver.findElement(By.xpath("//*[@id=\"card\"]"));
		orderCreditCard.sendKeys("STA_CE_MI_KARTICA_LOL");
		Thread.sleep(1000);
		
		WebElement orderMonth = webDriver.findElement(By.xpath("//*[@id=\"month\"]"));
		orderMonth.sendKeys("DRUGI");
		Thread.sleep(1000);
		
		WebElement orderYear = webDriver.findElement(By.xpath("//*[@id=\"year\"]"));
		orderYear.sendKeys("DVIJE_DVAJES_DRUGA");
		Thread.sleep(1000);
		
		WebElement orderPurchase = webDriver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
		orderPurchase.click();
		Thread.sleep(1000);

		WebElement message = webDriver.findElement(By.cssSelector("body > div.sweet-alert.showSweetAlert.visible > h2"));
		String messageText = message.getText();
		
		
		WebElement confirmPurchase = webDriver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button"));
		confirmPurchase.click();
		Thread.sleep(1000);
		
		assertNotEquals("Thank you for your purchase!", messageText);
	}

}
