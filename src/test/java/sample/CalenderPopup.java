package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalenderPopup {
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
	public void test(){
		driver.findElement(By.id("hp-widget__depart")).click();
		String date="//td[@data-year='2018' and @data-month='10']/a[text()='18']";
		int monthcount=0;
		while(monthcount<24){
			try
			{
				driver.findElement(By.xpath(date)).click();
			
				break;
				
			}
			catch(Throwable t){
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				monthcount++;
			}
		}
		
		
	}
}
