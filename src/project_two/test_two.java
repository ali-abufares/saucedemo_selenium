package project_two;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.dockerjava.api.model.Driver;

import dev.failsafe.internal.util.Assert;

public class test_two {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void MybeforeTest() {
		driver.get("https://www.saucedemo.com/");

	}

	@Test
	public void MYtest() throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		// vary bad //driver.findElement(By.tagName("input")).click();
		// driver.findElement(By.id("login-button")).click();

		driver.findElement(By.cssSelector("input[data-test=\"login-button\"]")).click();
		// driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		List<WebElement> Addchartelement = driver.findElements(By.className("btn_primary"));
		for (int i = 0; i < Addchartelement.size(); i++) {
			Addchartelement.get(i).click();

		}
		//Thread.sleep(6000);
		driver.findElement(By.className("shopping_cart_link")).click();

		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("ali");
		driver.findElement(By.id("last-name")).sendKeys("abufares");
		driver.findElement(By.id("postal-code")).sendKeys("0796407631");

		driver.findElement(By.id("continue")).click();
		
	 String total=driver.findElement(By.className("summary_total_label")).getText();
	// System.out.println(total);
		String[] new_total=total.split("\\$");
		SoftAssert asert=new SoftAssert();
		asert.assertEquals(new_total[1], "140.34");
		String actual_url= driver.getCurrentUrl();
		String current_url="https://www.saucedemo.com/checkout-step-two.html";
		asert.assertEquals(actual_url, current_url);
		asert.assertAll();
		
		
		
		
//		driver.findElement(By.id("finish")).click();
//		String complet_pross_text = driver.findElement(By.className("complete-header")).getText();
//		
//
//		Boolean to_check_maseg=complet_pross_text.contains("Thank you ");
//		//System.out.println(to_check_maseg);
//
//		SoftAssert asert = new SoftAssert();
//		//asert.assertEquals(complet_pross_text, "Thank you for your order!");
//		asert.assertEquals(to_check_maseg, false);
//				asert.assertAll();
	}

	@AfterTest
	public void My_AferTest() {
	}

}
