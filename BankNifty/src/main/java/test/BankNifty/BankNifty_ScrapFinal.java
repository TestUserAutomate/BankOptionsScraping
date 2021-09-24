package test.BankNifty;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BankNifty_ScrapFinal{
	static final String DB_URL = "jdbc:mysql://localhost:3306/banknifty";
	static final String USER = "root";
	static final String PASS = "root";
	public static void main(String args[]) throws Exception{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nithin\\workspace\\BankNifty\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 

		String Curr_time=null;
		String baseUrl = "https://groww.in/indices/nifty-bank";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement stmt=conn.prepareStatement("insert into temp_values values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  


		Thread.sleep(5000);

		for(int i =1;i<700;i++){

			ArrayList<Float> call_options_data = new ArrayList<Float>();
			ArrayList<Float> put_options_data = new ArrayList<Float>();
			ArrayList <String> call_Options = new ArrayList<String>();
			ArrayList <String> put_Options = new ArrayList<String>();
			DateFormat dfor = new SimpleDateFormat("dd-MM HH:mm");
			Date obj = new Date();
			Curr_time = dfor.format(obj);
			System.out.println(Curr_time);
			driver.findElement(By.xpath("//*[text()='Option Chain']")).click();
			Thread.sleep(4000); 
			driver.findElement(By.xpath("//*[@class='se55Input']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@class='se55DropdownPara '])[1]")).click();
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,550)", "");
			String sptPrice=driver.findElement(By.xpath("//*[@class='optc56SpotPriceText']")).getText();
			sptPrice =sptPrice.substring(12,19);
			float spotprice = Float.parseFloat(sptPrice);


			//Call options data
			call_Options.add("35,000.00");
			call_Options.add("35,200.00");
			call_Options.add("35,400.00");
			call_Options.add("35,600.00");
			call_Options.add("35,800.00");
			call_Options.add("36,000.00");
			call_Options.add("36,200.00");
			call_Options.add("36,400.00");
			call_Options.add("36,500.00");
			call_Options.add("36,600.00");
			call_Options.add("36,800.00");
			call_Options.add("37,000.00");
			call_Options.add("37,200.00");
			call_Options.add("37,400.00");
			call_Options.add("37,500.00");
			call_Options.add("37,600.00");
			call_Options.add("37,800.00");
			call_Options.add("38,000.00");
			call_Options.add("38,200.00");
			call_Options.add("38,400.00");
			call_Options.add("38,500.00");
			call_Options.add("38,600.00");
			call_Options.add("38,800.00");
			call_Options.add("39,000.00");
			call_Options.add("39,200.00");
			call_Options.add("39,400.00");
			call_Options.add("39,500.00");
			call_Options.add("39,600.00");
			call_Options.add("39,800.00");
			call_Options.add("40,000.00");
			call_Options.add("40,200.00");
			call_Options.add("40,400.00");
			call_Options.add("40,500.00");
			call_Options.add("40,600.00");
			call_Options.add("40,800.00");
			call_Options.add("41,000.00");








			//Put options data
			put_Options.add("31,000.00");
			put_Options.add("31,500.00");
			put_Options.add("32,000.00");
			put_Options.add("32,500.00");
			put_Options.add("33,000.00");
			put_Options.add("33,500.00");
			put_Options.add("34,000.00");
			put_Options.add("34,200.00");
			put_Options.add("34,400.00");
			put_Options.add("34,600.00");
			put_Options.add("34,800.00");
			put_Options.add("35,000.00");
			put_Options.add("35,200.00");
			put_Options.add("35,400.00");
			put_Options.add("35,500.00");
			put_Options.add("35,600.00");
			put_Options.add("35,800.00");
			put_Options.add("36,000.00");
			put_Options.add("36,200.00");
			put_Options.add("36,400.00");
			put_Options.add("36,500.00");
			put_Options.add("36,600.00");
			put_Options.add("36,800.00");
			put_Options.add("37,000.00");
			put_Options.add("37,200.00");
			put_Options.add("37,400.00");
			put_Options.add("37,500.00");
			put_Options.add("37,600.00");
			put_Options.add("37,800.00");
			put_Options.add("38,000.00");


			for(int k=0;k<put_Options.size();k++){

				String val1=driver.findElement(By.xpath("//*[text()='"+put_Options.get(k)+"']//following::td[1]")).getText();
				String val=val1.substring(1,9);
				val =val.replaceAll("[-+^,]*", " ");
				val =val.replaceAll("\\s","");
				System.out.println(val);
				float data = Float.parseFloat(val);
				put_options_data.add(data);
				// price point logic


			}
			for(int j=0;j<call_Options.size();j++){
				// current value logic
				String val1=driver.findElement(By.xpath("//*[text()='"+call_Options.get(j)+"']//preceding::td[1]")).getText();
				String  val=val1.substring(1,9);
				val =val.replaceAll("[-+^,]*", " ");
				val =val.replaceAll("\\s","");
				System.out.println(val);
				float data = Float.parseFloat(val);
				call_options_data.add(data);
				// price point logic
				

			}

			System.out.println("Put valus"+put_options_data.size());
			System.out.println("call values" +call_options_data.size());

			// Writing the intant time and spot price of Bank Nifty
			stmt.setNString(1,Curr_time);
			stmt.setDouble(2, spotprice);




			// put values db insert
			for(int put_val=3;put_val<=32;put_val++){
				stmt.setFloat(put_val,put_options_data.get(put_val-3));
			}


			// call values db insert

			for(int call_val=33;call_val<=68;call_val++){
				stmt.setFloat(call_val,call_options_data.get(call_val-33));
			}



			stmt.executeUpdate();  
			System.out.println(i+" records inserted");  


			Thread.sleep(60000);
			driver.navigate().refresh();



			call_options_data.clear();
			put_options_data.clear();
			call_Options.clear();
			put_Options.clear();










		}
	}}