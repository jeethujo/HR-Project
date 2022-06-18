package utilityPackage;
import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import basePackage.BaseClass;
public class ListenersClass extends BaseClass implements ITestListener {
public void onTestFailure(ITestResult result) {
    System.out.println("Test failed-screenshot captured");
		    //getScreenshot(); | Surround with try/catch
		try {
			getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
}
	
