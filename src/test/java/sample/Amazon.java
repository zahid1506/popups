package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Amazon {
	WebDriver driver;
@BeforeMethod
@Parameters({"browser","url"})
public void bm(String browser,String url){
if(browser.equalsIgnoreCase("chrome")){
		
		System.setProperty("webdriver.chrome.driver","C:/Users/Aritra/Desktop/selenium essentials/browser driver/chromedriver.exe");
	     driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.firefox.marionette","C:/Users/zahid/Desktop/selenium essentials/browser driver/geckodriver.exe");
		driver=new FirefoxDriver();
	}
driver.get(url);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
@Test
public void test1(){
	System.out.println("t1 passed");
}
@AfterMethod
public void configam(){
driver.quit();	
}
}
