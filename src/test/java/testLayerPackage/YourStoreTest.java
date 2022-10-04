package testLayerPackage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import basePackage.BaseClass;
import pomPackage.YourStorePOM;
import testDataDriven.ExcelReader;
import utilityPackage.ListenersClass;
@Listeners(ListenersClass.class)
public class YourStoreTest extends BaseClass{
/*4.To call methods in the test cases, create object 
	and declare it globally*/
	YourStorePOM signup;
SoftAssert Assert=new SoftAssert();
//1. create constructor of the RegisterTest class
public YourStoreTest() {
//2.Read all properties of the BaseClass(to call the constructor of parent class)
super();
}

@BeforeMethod
//3.Calling preMethod from the BaseClass
public void preSetup() {
//3.Calling preMethod from the BaseClass	
	preMethod();
	YourStoreURL();
signup=new YourStorePOM();
}
@AfterMethod
public void closeBrowser() {
driver.quit();
}

/*
Assignment: 1

Steps to Automate:
1. Launch the Browser
2. Open url
3. Click on button 'Register'
4. Enter the user details and register as a new user
5. Login as a new user
6. Add 2 products > access the both products price
7. Navigate to the shopping cart > match the prices

*/

@Test(priority=1)
public void AssignmentOne() throws InterruptedException {
signup.clickMyAccount();
signup.clickRegister();
signup.typeFname("John");
signup.typeLname("Doe");
signup.typeEmail("johndo@gmail.com");
signup.typePhone("94476854477");
signup.typePsswd("johnDoe@2022");
signup.typeCnfrmPswd("johnDoe@2022");
signup.clickAgree();
signup.clickContinue();
signup.mouseHoverOnLaptopNotebooks();
signup.verifyMacIsTheExpensiveLaptop();
signup.cartTotalVerification();
//Thread.sleep(3000);
}
//first commit
//second commit
/*
Assignment: 2

Steps to Automate:
1. Launch the Browser
2. Open url
3. Click on buttons 'My Account' > 'Login'
4. Fetch the login details from the excel sheet using @DataProvider
5. Confirm the UI throws the validation message when Login fails
*/

//fetching excel data using the DataProvider annotation
@DataProvider
public Object[][] LoginPageTest(){
/*To read data from the excel, we call the readExcelData method
by passing the sheet name in the excel file and store it in a variable*/
Object result[][]=ExcelReader.readExcelData("testData");
return result;
}
@Test(priority=2, dataProvider="LoginPageTest")
public void AssignmentTwo(String eAdd,String pswd) throws InterruptedException {
	signup.clickMyAccount(); 
	signup.clickLogin();
	signup.typeEmail(eAdd);
	signup.typePsswd(pswd);
	signup.clickLoginPageLoginButton();
	Thread.sleep(1000);
	signup.verifyLoginFailures();
}

@Test(enabled=false)//for test purpose
public void test() {

}

}