import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parameters {
	public WebDriver driver;
	String MyURL = "https://www.demoblaze.com/index.html#";
	SoftAssert MySoftAssert = new SoftAssert();
	String ExpectedTitle = "STORE";
	@BeforeTest
	public void pre_my_test() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(MyURL);
	}


}
