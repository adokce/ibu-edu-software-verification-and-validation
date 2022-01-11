package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumIntroTest {
	private static WebDriver webDriver;
//	private static String baseUrl = "https://mistral.ba";

	private static String baseUrl = "https://phptravels.net/";

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
		
		WebElement toursLink = webDriver.findElement(By.cssSelector("body > header > div.header-menu-wrapper.padding-right-100px.padding-left-100px > div > div > div > div > div.main-menu-content > nav > ul > li:nth-child(4) > a"));
		toursLink.click();
		
		Thread.sleep(1000);
		
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("window.scrollBy(0,250)");
		
		WebElement dubaiTourLink = webDriver.findElement(By.cssSelector("body > section.destination-area.section--padding > div > div.row.padding-top-50px > div:nth-child(2) > a > div > div.card-img"));
		dubaiTourLink.click();
		
		WebElement
		
		Thread.sleep(3000);
		
	}
	
	/*
	@Test
	void test() throws InterruptedException{
		webDriver.get(baseUrl);
		// navigate
		
		WebElement workElement = webDriver.findElement(By.cssSelector("#mega-menu-item-971 > a"));
		workElement.click();
		
		
		WebElement title2 = webDriver.findElement(By.cssSelector("#post-777 > div > h2.has-text-align-center.no-margin.aos-init.aos-animate > strong > span"));
		
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 200)","");
		

		Thread.sleep(3000);
		
		
		assertEquals("We are a Product Development as a Service company.",title2);
		

	}
	*/
	
	/*

@Test
  void testYearlyRevenue2() {
    University burch = new University("Burch","BiH",2010,10,2,999);
    
    assertFalse(burch.yearlyRevenue()==100);
  }
	 */
	
	/*
	 package main;

public class University {
  public String name;
  public String country;
  public int founding_year;
  public int num_of_students;
  public int yearly_tuition;
  public int webometrics_rank;
  
  public University(String n, String c, int fy, int nos, int yt, int wr) {
    name = n;
    country = c;
    founding_year = fy;
    num_of_students = nos;
    yearly_tuition = yt;
    webometrics_rank = wr;
  }
  
  public int yearlyRevenue() {
    return this.num_of_students*this.yearly_tuition;
  }
}
	 */
}
