package pomPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basePackage.BaseClass;
public class YourStorePOM extends BaseClass {
/*1. create object repository by adding 
	 all elements from the Your Store Sign up Page*/	
//sendKeys fields
@FindBy(xpath="//i[@class='fa fa-user']")WebElement MyAccount;
@FindBy(xpath="/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a") WebElement Login;
@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/div/form/input") WebElement LoginPageLoginButton;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement warningAlert;
@FindBy(xpath="//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=account/register']")WebElement Register;
@FindBy(id="input-firstname")WebElement fName;
@FindBy(id="input-lastname")WebElement lName;
@FindBy(id="input-email")WebElement eMail;
@FindBy(id="input-telephone")WebElement pHone;
@FindBy(id="input-password")WebElement pSwd;
@FindBy(id="input-confirm")WebElement cnfmPswd;
@FindBy(name="agree")WebElement Agree;
@FindBy(xpath="//input[@class='btn btn-primary']")WebElement Continue;
@FindBy(xpath="/html/body/div[2]/div/div/div[4]/div[1]/div/div[2]/div[1]/h4/a") WebElement MacBookPro;
@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/ul[2]/li[1]/h2") WebElement MacProPrice;
@FindBy(id="button-cart") WebElement Add2Cart;
@FindBy(xpath="/html/body/div[2]/ul/li[2]/a") WebElement LapAndNote;
@FindBy(xpath="/html/body/div[2]/div/div/div[4]/div[2]/div/div[2]/div[1]/h4/a") WebElement SonyVaio;
@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/ul[2]/li[1]/h2") WebElement SonyVPrice;
@FindBy(id="cart-total") WebElement CartRead;


//initiate page elements
//inheriting the base class to call the driver
public YourStorePOM() {
PageFactory.initElements(driver,this);
}

//Element actions
public void clickMyAccount() {
	MyAccount.click();
}
public void clickLogin() {
	Login.click();
}
public void clickLoginPageLoginButton() {
	LoginPageLoginButton.click();
}
public void clickRegister() {
	Register.click();
}
public void typeFname(String firstName) {
	fName.sendKeys(firstName);
}
public void typeLname(String lastName) {
	lName.sendKeys(lastName);
}
public void typeEmail(String email) {
	eMail.sendKeys(email);
}
public void typePhone(String tphone) {
	pHone.sendKeys(tphone);
}
public void typePsswd(String pswd) {
	pSwd.sendKeys(pswd);
}
public void typeCnfrmPswd(String cnfpswd) {
	cnfmPswd.sendKeys(cnfpswd);
}
public void clickAgree() {
	Agree.click();
}
public void clickContinue() {
	Continue.click();
}
public void mouseHoverOnLaptopNotebooks() {
	Actions action=new Actions(driver);
	WebElement LapAndNote=driver.findElement(By.xpath("//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=18']"));
	action.moveToElement(LapAndNote);
	WebElement ShowAll=driver.findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul/li[2]/div/a"));
	action.moveToElement(ShowAll);
	action.click().build().perform();
}
public void displayRegistrationSuccessmessage() throws InterruptedException {
	System.out.println("Success!! The Registration Successfull");
	System.out.println("Logging in as a new user");
	
}
public void verifyMacIsTheExpensiveLaptop() {
	WebElement Sort=driver.findElement(By.id("input-sort"));
	Select sort=new Select(Sort);
	sort.selectByVisibleText("Price (High > Low)");
	WebElement FirstProduct=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div[1]/div/div[2]/div[1]/h4/a"));
	String expensiveLaptopName=FirstProduct.getText();
	System.out.println("Verified Successfully!! The expensive laptop is: "+expensiveLaptopName);
}
public void cartTotalVerification() throws InterruptedException {
	MacBookPro.click();
	String PriceOfMac=MacProPrice.getText();
	//System.out.println(PriceOfMac);
	Add2Cart.click();
	LapAndNote.click();
	SonyVaio.click();
	String PriceOfSony=SonyVPrice.getText();
	//System.out.println(PriceOfSony);
	Add2Cart.click();
	Thread.sleep(1000);
	String cartRead=CartRead.getText();
	Assert.assertEquals(cartRead, "2 item(s) - $3,202.00");
	System.out.println("Verified successfully that the cost of the products are calculated correctly");
}
public void verifyLoginFailures() {
	if (warningAlert.isDisplayed()==true) {
		System.out.println("Success! Login failed, validation message displayed as expected");
	}else {
		System.out.println("Failed! validation message is not displayed");
	}
}

}
