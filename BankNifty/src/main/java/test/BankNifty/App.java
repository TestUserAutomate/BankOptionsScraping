package test.BankNifty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nithin\\workspace\\BankNifty\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		String baseUrl = "https://groww.in/indices/nifty-bank";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Option Chain']")).click();
		Thread.sleep(4000); 
		driver.findElement(By.xpath("//*[@class='se55Input']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='se55DropdownPara '])[1]")).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)", "");
		String sptPrice=driver.findElement(By.xpath("//*[@class='optc56SpotPriceText']")).getText();
		sptPrice =sptPrice.substring(12,19);
		System.out.println("SpotPrice :"+sptPrice);
		
		
		 
			  
		String Ce_35000=driver.findElement(By.xpath("//*[text()='37,000.00']//preceding::td[1]")).getText();
		String Ce_35000_val=Ce_35000.substring(1,9);
        Ce_35000_val =Ce_35000_val.replaceAll("[-+^,]*", "");
        System.out.println(Ce_35000_val);
        Ce_35000_val =Ce_35000_val.replaceAll("\\s","");
        System.out.println(Ce_35000_val);
        String Ce_point=Ce_35000.substring(7,14);
        System.out.println("adss "+Ce_point);
       if(Ce_point.contains("+")){
    	   String replaceAll = Ce_point.replaceAll("[-+^,]*", "");
    	   					replaceAll=Ce_point.replaceAll("\\s","");
    	   float data = Float.parseFloat(replaceAll);
    	   System.out.println(data);
    	  
    	   System.out.println("Final data" +data);
       }
       if(Ce_point.contains("-")){
    	   String replaceAll = Ce_point.replaceAll("[-+^,]*", "");
    	   					replaceAll=Ce_point.replaceAll("\\s","");
    	   float data = Float.parseFloat(replaceAll);
    	   System.out.println("bsbs"+data);
       }
    
        

	
}}

