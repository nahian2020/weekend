import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class title {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String pageurl = "https://www.fedex.com/login/web/jsp/logon.jsp";
	 driver.get(pageurl);
	 String title3= driver.getTitle();
	 System.out.println(title3);
	}

}
