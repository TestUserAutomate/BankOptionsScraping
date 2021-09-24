package test.BankNifty;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Bank_nifty_Optimised {
	static final String DB_URL = "jdbc:mysql://localhost:3306/banknifty";
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) throws InterruptedException, SQLException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nithin\\workspace\\BankNifty\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 

		String Curr_time=null;
		String baseUrl = "https://groww.in/indices/nifty-bank";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement stmt=conn.prepareStatement("insert into banknifty_values values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  


		Thread.sleep(5000);
