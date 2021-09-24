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
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImpliedVolatility {
	static final String DB_URL = "jdbc:mysql://localhost:3306/banknifty";
	static final String USER = "root";
	static final String PASS = "root";





	@Test(retryAnalyzer=Analyzer.retry.class)
	public void ImpliedVolatility() throws Exception{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nithin\\workspace\\BankNifty\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 

		String Curr_time=null;
		String baseUrl = "https://www.edelweiss.in/market/nse-option-chain/optidx~banknifty~2021-09-30";
		driver.get(baseUrl);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='wzrk-cancel']")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement stmt=conn.prepareStatement("insert into Iv_opt values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  

		for(int i=1;i<700;i++){
			ArrayList <String> put_Options = new ArrayList<String>();
			ArrayList<Float> call_options_data = new ArrayList<Float>();
			ArrayList<Float> put_options_data = new ArrayList<Float>();
			ArrayList <String> call_Options = new ArrayList<String>();
			DateFormat dfor = new SimpleDateFormat("dd-MM HH:mm");
			Date obj = new Date();
			Curr_time = dfor.format(obj);
			System.out.println(Curr_time);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,650)", "");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@gtmdir-key='showall'])[1]")).click();
			Thread.sleep(60000);


			call_Options.add("35,000");
			call_Options.add("35,200");
			call_Options.add("35,400");
			call_Options.add("35,600");
			call_Options.add("35,800");
			call_Options.add("36,000");
			call_Options.add("36,200");
			call_Options.add("36,400");
			call_Options.add("36,600");
			call_Options.add("36,800");
			call_Options.add("37,000");
			call_Options.add("37,200");
			call_Options.add("37,400");
			call_Options.add("37,600");
			call_Options.add("37,800");
			call_Options.add("38,000");
			call_Options.add("38,200");
			call_Options.add("38,400");
			call_Options.add("38,600");
			call_Options.add("38,800");
			call_Options.add("39,000");
			call_Options.add("39,200");
			call_Options.add("39,400");
			call_Options.add("39,600");
			call_Options.add("39,800");
			call_Options.add("40,000");
			call_Options.add("40,200");
			call_Options.add("40,400");
			call_Options.add("40,600");
			call_Options.add("40,800");
			call_Options.add("41,000");



			//Put options data
			put_Options.add("31,000");
			put_Options.add("31,500");
			put_Options.add("32,000");
			put_Options.add("32,500");
			put_Options.add("33,000");
			put_Options.add("33,500");
			put_Options.add("34,000");
			put_Options.add("34,200");
			put_Options.add("34,400");
			put_Options.add("34,600");
			put_Options.add("34,800");
			put_Options.add("35,000");
			put_Options.add("35,200");
			put_Options.add("35,400");
			put_Options.add("35,600");
			put_Options.add("35,800");
			put_Options.add("36,000");
			put_Options.add("36,200");
			put_Options.add("36,400");
			put_Options.add("36,600");
			put_Options.add("36,800");
			put_Options.add("37,000");
			put_Options.add("37,200");
			put_Options.add("37,400");
			put_Options.add("37,600");
			put_Options.add("37,800");

			for(int k=0;k<put_Options.size();k++){

				String val1=driver.findElement(By.xpath("//*[text()='"+put_Options.get(k)+"']//following::td[3]")).getText(); 
				System.out.println(val1);
				if(val1.length()>6){
					System.out.println("insdie" +val1);
					float temp =(float) 0.0;
					put_options_data.add(temp);
					
				}else{
				float opt_val =Float.parseFloat(val1);
				put_options_data.add(opt_val);
				}
			}

			for(int k=0;k<call_Options.size();k++){

				String val2=driver.findElement(By.xpath("//*[text()='"+call_Options.get(k)+"']//preceding::td[3]")).getText();
				System.out.println(val2);
				if(val2.length()>6){
					System.out.println("Inside"+val2);
					float temp = 0.0f;
					put_options_data.add(temp);

				}else{
					float opt_val =Float.parseFloat(val2);
					call_options_data.add(opt_val);

				}

			}

			stmt.setNString(1,Curr_time);



			// put values db insert
			for(int put_val=2;put_val<=27;put_val++){
				stmt.setFloat(put_val,put_options_data.get(put_val-2));
			}


			// call values db insert

			for(int call_val=28;call_val<=58;call_val++){
				stmt.setFloat(call_val,call_options_data.get(call_val-28));
			}



			stmt.executeUpdate();  
			System.out.println(i+" records inserted");  



			driver.navigate().refresh();



			call_options_data.clear();
			put_options_data.clear();
			call_Options.clear();
			put_Options.clear();

			Thread.sleep(5000);
		}
	}

}
