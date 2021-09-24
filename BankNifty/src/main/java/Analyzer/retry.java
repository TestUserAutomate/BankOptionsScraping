package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer{

	int counter =0;
	int retry_limit =5;
	@Override
	public boolean retry(ITestResult result) {
		
		if(counter<retry_limit){
			counter++;
			return true;
								}
			return false;
						}

}
