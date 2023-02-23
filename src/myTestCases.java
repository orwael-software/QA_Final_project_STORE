import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class myTestCases extends parameters {

	@Test 
	public void Check_The_Title () {
		String myActualTitle = driver.getTitle();
		MySoftAssert.assertEquals(myActualTitle, ExpectedTitle);
		MySoftAssert.assertAll();
		
	}
	
	@Test()
	public void check_the_image_drawer() {
		
		List<WebElement> myimage = driver.findElements(By.className("img-fluid"));
		boolean myimageCheck1 = myimage.get(0).getAttribute("src") == myimage.get(1).getAttribute("src");
		boolean myimageCheck2 = myimage.get(1).getAttribute("src") == myimage.get(2).getAttribute("src");
		boolean myimageCheck3 = myimage.get(2).getAttribute("src") == myimage.get(0).getAttribute("src");

		MySoftAssert.assertEquals(myimageCheck1, false ,"image 1 with image 2");
		MySoftAssert.assertEquals(myimageCheck2, false ,"image 2 with image 3");
		MySoftAssert.assertEquals(myimageCheck3, false ,"image 3 with image 1");

		MySoftAssert.assertAll();
		
	}
	
	@Test()
	public void Validation_the_contact_from_information() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		String email  = RandomStringUtils.randomAlphabetic(10)+ "@gmail.com";
		String name_of_emails [] = {"a1@gmail.jo","a9gmail.com","uu887@gmail","king@gmail.com"};
		Random Email_index = new Random();
		int index = Email_index.nextInt(4);
		driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).sendKeys(name_of_emails[index]);
		Thread.sleep(1000);
		String myvalue = driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).getAttribute("value");
		System.out.println(myvalue);
		String regex = "^[A-Za-z0-9+_.-]+@(.+)+.(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name_of_emails[index]);
		System.out.println("*******************");
		System.out.println(name_of_emails[index] + " is valid email : " + matcher.matches());
		System.out.println("*******************");
//		boolean mycheckprocessfortheemail = matcher.matches();
//		MySoftAssert.assertEquals(mycheckprocessfortheemail, true , "the email structure is not matching the correct one");
//		MySoftAssert.assertAll();
	}
}
