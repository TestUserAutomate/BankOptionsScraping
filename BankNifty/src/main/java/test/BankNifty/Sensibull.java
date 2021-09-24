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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class Sensibull 
{
	public static void main( String[] args ) throws InterruptedException
	{
		ArrayList<Float> call_options_data = new ArrayList<Float>();
		ArrayList<Float> put_options_data = new ArrayList<Float>();
		ArrayList<String> list_Strike_price=new ArrayList<String>();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nithin\\workspace\\BankNifty\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		String baseUrl = "https://web.sensibull.com/option-chain?expiry=2021-09-30&tradingsymbol=BANKNIFTY";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		for(int i =4;i<472;i=i+8){

			String a = "(//*[@class='rt-td'])[";
			String b = "]";
			String text = driver.findElement(By.xpath(a+i+b)).getText();
			list_Strike_price.add(text);


		}

		/*for(String az :list_Strike_price){
			System.out.println(az);

		}*/

		Thread.sleep(5000);
		driver.navigate().to("https://web.sensibull.com/option-chain?expiry=2021-09-30&tradingsymbol=BANKNIFTY");
		System.out.println("Execution------------");
		for(int z=0;z<10;z++){
			String spot_price=null;
			String IV=null;
			spot_price=driver.findElement(By.xpath("//*[@class='style__TickerButtonText-sc-r8xy9h-3 ignxRV']")).getText();
			spot_price =spot_price.substring(14,22);
			/*float spt_price = Float.parseFloat(spot_price);*/
			IV = driver.findElement(By.xpath("//*[@class='style__AtmIVWrapper-sc-1myo97d-30 csGaLk']")).getText();
			
			/*float ImpliedV = Float.parseFloat(IV);*/
			
			for(int j=0;j<list_Strike_price.size();j++){
				String val = driver.findElement(By.xpath("//*[text()='"+list_Strike_price.get(j)+"']//preceding::div[3]")).getText();
				val =val.replaceAll("[-+^%,]*", " ");
				val =val.replaceAll("\\s","");
				if(val.length()<=2){
					val="0.00";
									}
				float data = Float.parseFloat(val);
				call_options_data.add(data);
				System.out.println(list_Strike_price.get(j)+" CE --"+data);
														}
			System.out.println("-------------------------------------------------------------");
			for(int j=0;j<list_Strike_price.size();j++){
				String val = driver.findElement(By.xpath("//*[text()='"+list_Strike_price.get(j)+"']//following::div[2]")).getText();
				val =val.replaceAll("[-+^%,]*", " ");
				val =val.replaceAll("\\s","");
				if(val.length()<=2){
					val="0.00";
									}
				float data = Float.parseFloat(val);
				put_options_data.add(data);
				System.out.println(list_Strike_price.get(j)+" PE--"+data);
														}
			
			System.out.println(spot_price);
			System.out.println(IV);
			Thread.sleep(30000);
			System.out.println(z+"inserted");
			/*driver.navigate().refresh();*/

		}
	}}

