package sample;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WindowHandlesPopUP {
	WebDriver driver;
	@BeforeMethod
	//@Parameters({"browser","url"})
	public void configbm(){
		
		System.setProperty("webdriver.chrome.driver","C:/Users/Aritra/Desktop/selenium essentials/browser driver/chromedriver.exe");
	     driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	}

	@Test
	public void sampleMulWindow(){
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone x",Keys.ENTER);
		driver.findElement(By.xpath("//h2[contains(text(),'Apple iPhone X (Silver, 256GB)')]")).click();
		Set<String> sel=driver.getWindowHandles();
		Iterator<String> it=sel.iterator();
		/*String Parentid=it.next();
		String Childid=it.next();*/
		for(int i=1;i<sel.size(); i++){
			driver.switchTo().window(it.next());
			String actTitle=driver.getTitle();
			if(actTitle.equals("Apple iPhone X (Silver, 256GB): Amazon.in: Electronics"));
			break;
		}
		//driver.switchTo().window(Parentid);
		WebElement atc=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",atc);
	}
}
