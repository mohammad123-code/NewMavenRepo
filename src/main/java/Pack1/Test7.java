package Pack1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class Test7 {
	public static ExtentReports extent;
	public static ExtentTest logger;
	@BeforeMethod
	public void Extest() {
		ExtentHtmlReporter rep= new ExtentHtmlReporter("C:\\Users\\mohammad.Anzaf\\eclipse-workspace\\jvhg\\Report\\extentReport.html");
		 extent = new ExtentReports();
        extent.attachReporter(rep);	
	}
//This is frist code
	@org.testng.annotations.Test
	
	public void FristCase()  throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("app", "C:\\Users\\mohammad.Anzaf\\Downloads\\app-release.apk");
		/*cap.setCapability("", "");
		cap.setCapability("", "");*/
		
		AndroidDriver<WebElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='IGNORE']"))).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='English']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='CONTINUE']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Get started']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter mobile number']")).sendKeys("9889989889");;
		driver.findElement(By.xpath("//android.widget.TextView[@text='CONTINUE']")).click();
		logger= extent.createTest("Pass Test", "Login");
	}
	
	@AfterMethod
	public void close() {
		extent.flush();
		extent.close();
		//this is second code
	}
	
}
