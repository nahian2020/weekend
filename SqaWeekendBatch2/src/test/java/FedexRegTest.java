import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FedexRegTest {
	static WebDriver driver;
	
	@BeforeMethod
	public void fedexPageSetUP() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String pageurl = "https://www.fedex.com/login/web/jsp/logon.jsp";
		driver.get(pageurl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
// page validation
	}
	@Test(priority = 1)
	public void pageValidation() {
		String eReult = "FedEx | Login Page";
		String aResult = driver.getTitle();
		Assert.assertEquals(aResult, eReult);
		System.out.println(aResult);
	}
	//page sign up validation
	@Test(priority = 2)
	public void fedexPageSignup() {
//	  WebElement signup =driver.findElement(By.xpath("//a[@class='smallpurpleheader']"));
//	  signup.click();
		By signup = By.xpath("//a[@class='smallpurpleheader']");
	By fname = By.name("firstName");
		By lname = By.name("lastName");
		By emailid = By.name("email");
		By confirmemailid = By.name("retypeEmail");
		By address = By.name("address1");
		By city = By.name("city");
		By state = By.name("state");
		By zipcode = By.name("zip");
		By phonenumber = By.name("phone");
		By userId = By.name("loginId");
		By userPassword = By.name("password");
		By reUserpass = By.name("retypePassword");
		By secretQ = By.name("reminderAnswer");
		
		By termNcondition = By.xpath("//input[@type='checkbox']");
		By completeRegistration = By.xpath("//input[@class='buttonpurple']']");
		
		getElement(signup).click();
		getElement(fname).sendKeys("Nahian");
		getElement(lname).sendKeys("Faruqe");
		getElement(emailid).sendKeys("nahianqa2020@gmail.com");
		getElement(confirmemailid).sendKeys("nahianqa2020@gmail.com");
		getElement(address).sendKeys("28 fairview");
		getElement(city).sendKeys("albany");
		getElement(state).sendKeys("NY");
		getElement(zipcode).sendKeys("12535");
		getElement(phonenumber).sendKeys("5185679998");
		getElement(userId).sendKeys("nsawmi");
		getElement(userPassword).sendKeys("Emba9071");
		getElement(reUserpass).sendKeys("Emba9071");
		getElement(secretQ).sendKeys("NYC");
		WebElement secQuestion=driver.findElement(By.id("reminderQuestion"));
		WebElement country=driver.findElement(By.name("country"));
		doSelectValueFromDropdown(secQuestion, "What is your place of birth?");
		doSelectValueFromDropdown(country, "Albania");
		getElement(termNcondition).click();
		//getElement(completeRegistration).click();
		
		}
		
		//@Test(priority =3)
		//public void footerlinkvalidation(){
			
		//}
		
			
		
		
		
		
	

	@AfterMethod
	public void teardown() {

///driver.quit();

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static  void doSelectValueFromDropdown(WebElement element ,String value)
	{
//WebElement secQuestion=driver.findElement(By.id("reminderQuestion"));
// WebElement country=driver.findElement(By.name("country"));
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
}
}
