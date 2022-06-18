package basePackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilityPackage.TimeUtils;
import org.openqa.selenium.Dimension;
public class BaseClass {
// using properties method to connect with Config.properties class
// using static we can access from different classes
// Fetching Properties and saving in 'Config' variable
public static Properties Config = new Properties();
// declaring driver globally
public static WebDriver driver;

// Step 1
/*Creating constructor for the base class to pass 
  the path of the Config.properties */
public BaseClass() {
try {
	FileInputStream file = new FileInputStream("C:\\Users\\jeeth\\eclipse-workspace\\AssignmentYourStore\\src\\test\\java\\environmentVariables\\Config.Properties");
	Config.load(file);
	} 
catch (FileNotFoundException e) {
		e.printStackTrace();
		} 
catch (IOException a) {
		a.printStackTrace();
		}
	}

//Step 2: Store common commands that will be used by child classes
public static void preMethod() {
String browserName = Config.getProperty("Browser");
if (browserName.equals("Firefox")) {
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	driver = new FirefoxDriver();
	}
	else if (browserName.equals("Chrome")) {
		    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
	}
	else if (browserName.equals("Edge")) {
	    System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		driver = new EdgeDriver();
}


//driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(TimeUtils.elementTimeout,TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(TimeUtils.webpageTimeout, TimeUnit.SECONDS);
}

public static void YourStoreURL() {
driver.get(Config.getProperty("URL"));
}
public static void LoginURL() {
driver.get(Config.getProperty("URL1"));
}

//Step 3: Screenshot method 
public static void getScreenshot() throws IOException{
Date currentdate=new Date();
String screenshotfilename=currentdate.toString().replace(" ", "-").replace(":", "-");
File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenshotfilename+".png"));
}
}

	 
