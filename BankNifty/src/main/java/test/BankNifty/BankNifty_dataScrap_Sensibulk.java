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

public class BankNifty_dataScrap_Sensibulk{
	static final String DB_URL = "jdbc:mysql://localhost:3306/banknifty";
	static final String USER = "root";
	static final String PASS = "root";
	@Test/*(retryAnalyzer=Analyzer.retry.class)*/
	public void banknifty() throws Exception{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nithin\\workspace\\BankNifty\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 

		String Curr_time=null;
		String baseUrl = "https://web.sensibull.com/option-chain?expiry=2021-09-30&tradingsymbol=BANKNIFTY";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);*/
/*		PreparedStatement stmt=conn.prepareStatement("insert into t2 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  
*/

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
			
		

			//Call options data
			call_Options.add("35,600.00");
			call_Options.add("35,800.00");
			call_Options.add("36,000.00");
			call_Options.add("36,200.00");
			call_Options.add("36,400.00");
			call_Options.add("36,600.00");
			call_Options.add("36,800.00");
			call_Options.add("37,000.00");
			call_Options.add("37,200.00");
			call_Options.add("37,400.00");
			call_Options.add("37,600.00");
			call_Options.add("37,800.00");
			call_Options.add("38,000.00");
			call_Options.add("38,200.00");
			call_Options.add("38,400.00");
			call_Options.add("38,600.00");
			call_Options.add("38,800.00");
			call_Options.add("39,000.00");
			call_Options.add("39,200.00");
			call_Options.add("39,400.00");
			call_Options.add("39,600.00");
			call_Options.add("39,800.00");
			call_Options.add("40,000.00");
			call_Options.add("40,200.00");
			call_Options.add("40,400.00");
		








			//Put options data
		
			put_Options.add("35600");
			put_Options.add("35800");
			put_Options.add("36000");
			put_Options.add("36200");
			put_Options.add("36400");
			put_Options.add("36600");
			put_Options.add("36800");
			put_Options.add("37000");
			put_Options.add("37200");
			put_Options.add("37400");
			put_Options.add("37600");
			put_Options.add("37800");


			for(int k=0;k<put_Options.size();k++){

				String val1=driver.findElement(By.xpath("//*[text()='"+put_Options.get(k)+"']//following::td[1]")).getText();
				String val=val1.substring(1,9);
				val =val.replaceAll("[-+^,]*", " ");
				val =val.replaceAll("\\s","");
				System.out.println(put_Options.get(k)+"Pe --"+val);
				float data = Float.parseFloat(val);
				put_options_data.add(data);
				// price point logic
		

			}
			
			System.out.println("--------------------------------");
			
			for(int j=0;j<call_Options.size();j++){
				// current value logic
				String val1=driver.findElement(By.xpath("//*[text()='"+call_Options.get(j)+"']//preceding::td[1]")).getText();
				String  val=val1.substring(1,9);
				val =val.replaceAll("[-+^,]*", " ");
				val =val.replaceAll("\\s","");
				System.out.println(call_Options.get(j)+"CE --"+val);
				float data = Float.parseFloat(val);
				call_options_data.add(data);
				// price point logic
				

			}

			System.out.println("Put valus"+put_options_data.size());
			System.out.println("call values" +call_options_data.size());

	


			call_options_data.clear();
			put_options_data.clear();
			call_Options.clear();
			put_Options.clear();










		}
	}}