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
public class App2 
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
		
		
		  ArrayList<String> list=new ArrayList<String>();
		  list.add("35,000.00");
		  list.add("37,500.00");
		  list.add("38,500.00");
		  list.add("39,500.00");
		  for(int i =0;i<list.size();i++){
		String val=driver.findElement(By.xpath("//*[text()='"+list.get(i)+"']//preceding::td[1]")).getText();
		String val1=val.substring(7,11);
		if(val1.contains("-")){
			System.out.println("Contains minus");
			String temp_val = val.substring(8, 17);
			temp_val =temp_val.replaceAll("[-+^,(]*", " ");
			temp_val =temp_val.replaceAll("\\s","");
			System.out.println(temp_val);
			System.out.println("-----------------");
        float float_val = Float.parseFloat(temp_val);
        	 float_val = - float_val;
        System.out.println(list.get(i)+" -- "+float_val);
			
		}else{
			
			String temp_val = val.substring(8, 17);
			temp_val =temp_val.replaceAll("[-+^,(]*", " ");
			temp_val =temp_val.replaceAll("\\s","");
			System.out.println(temp_val + "---"+temp_val.length());
			float temp_float =Float.parseFloat(temp_val);
				if(temp_float>1000.0f){
					System.out.println("Temp float greater than 1000");
					String temp = Float.toString(temp_float);
					temp = temp.substring(1);
					System.out.println(temp);
				}
			 float float_val = Float.parseFloat(temp_val);
       /* System.out.println(list.get(i)+" -- "+float_val);*/
			
			
			
			
		}
		
			
		
	

	}
}}

