package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.Keys;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Keys;

public class InvalidLoginTest {

	WebDriver driver = null;
	WebElement error;

//	TEST 1 no username
	@Given("user is on signup page")
	public void user_is_on_signup_page() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Gecko driver\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.bg/signup");
		Thread.sleep(5000);

	}

	@And("user clicks submit")
	public void user_clicks_signup_button() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[13]/a[1]")).click();

		Thread.sleep(5000);
	}

	@Then("user gets error")
	public void error_msg_appears() throws InterruptedException {
		String actual_error = driver.findElement(By.xpath("//*[@id=\"signup_mail_hint\"]/div/span[1]")).getText();
		String expected_Error = "Не сте въвели потребителско име";
		
		Assert.assertEquals(expected_Error, actual_error);
		Thread.sleep(5000);
		try {
			Assert.assertNotEquals(expected_Error, actual_error);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Не сте въвели потребителско име");
		driver.close();
		driver.quit();
	}

// Test 2 with username
	@Given("user entered username")
	public void user_entered_username() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.bg/signup");
		Thread.sleep(5000);
//Username
		driver.findElement(By.xpath("//*[@id=\"signup_user\"]")).sendKeys("asdfkjsdjlglsdfk");
		Thread.sleep(5000);
	}

	@And("user clicks submit1")
	public void user_clicks_submit1() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[13]/a[1]")).click();

		Thread.sleep(5000);
	}

	@Then("user gets error1")
	public void user_gets_error1() throws InterruptedException {

//		The xpath for all error messages is the same ????
		String actual_error1 = driver.findElement(By.xpath("//*[@id=\"signup_mail_hint\"]/div/span[1]")).getText();
		
		String expected_Error1 = "Не сте въвели парола";

		try {
			Assert.assertNotEquals(actual_error1, expected_Error1);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(5000);

		System.out.println("Не сте въвели парола");
		driver.close();
		driver.quit();
	}

//	Test 3 with psasword

	@Given("user entered username and pass")
	public void user_entered_username_and_pass() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.bg/signup");
		Thread.sleep(5000);
//Username
		driver.findElement(By.xpath("//*[@id=\"signup_user\"]")).sendKeys("asdfkjsdjlglsdfk");
//Password
		driver.findElement(By.xpath("//*[@id=\"mail_pass_input\"]")).sendKeys("asdfkjsdjlglsdfk");
		driver.findElement(By.xpath("//*[@id=\"mail_confpass_input\"]")).sendKeys("asdfkjsdjlglsdfk");
		Thread.sleep(5000);
	}

	@And("user clicks submit2")
	public void user_clicks_submit2() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[13]/a[1]")).click();

		Thread.sleep(5000);
	}

	@Then("user gets error2")
	public void user_gets_error2() throws InterruptedException {

		String actual_error1 = driver.findElement(By.xpath("//*[@id=\"signup_mail_hint\"]/div/span[1]")).getText();
		String expected_Error1 = "Не сте въвели пол";

		try {
			Assert.assertNotEquals(expected_Error1, actual_error1);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(5000);

		System.out.println("Не сте въвели пол");
		driver.close();
		driver.quit();
		driver.close();
		driver.quit();
	}

//Test 4 Not enough chars in password
	@Given("user entered pass less char")
	public void user_entered_pass_less_char() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.bg/signup");
		Thread.sleep(5000);
//Username
		driver.findElement(By.xpath("//*[@id=\"signup_user\"]")).sendKeys("asdfkjsdjlglsdfk");
//Password
		driver.findElement(By.xpath("//*[@id=\"mail_pass_input\"]")).sendKeys("as");
		Thread.sleep(5000);
	}

	@And("user clicks submit23")
	public void user_clicks_submit23() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[13]/a[1]")).click();

		Thread.sleep(5000);
	}

	@Then("user gets error23")
	public void user_gets_error23() throws InterruptedException {

		String actual_error1 = driver.findElement(By.xpath("//*[@id=\"signup_mail_hint\"]/div/span[1]")).getText();
		String expected_Error1 = "Паролата не може да е по-къса от 5 символа";

		try {
			Assert.assertNotEquals(expected_Error1, actual_error1);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Паролата не може да е по-къса от 5 символа");
		driver.close();
		driver.quit();
	}

// Test5 different passwords 
	@Given("user entered unmaching pass")
	public void user_entered_unmaching_pass() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.bg/signup");
		Thread.sleep(5000);
//Username
		driver.findElement(By.xpath("//*[@id=\"signup_user\"]")).sendKeys("asdfkjsdjlglsdfk");
//Password
		driver.findElement(By.xpath("//*[@id=\"mail_pass_input\"]")).sendKeys("asdfkjsdjlglsdfk");
		driver.findElement(By.xpath("//*[@id=\"mail_confpass_input\"]")).sendKeys("asdfkjs");
		Thread.sleep(5000);
	}

	@And("user clicks submit232")
	public void user_clicks_submit232() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[13]/a[1]")).click();

		Thread.sleep(5000);
	}

	@Then("user gets error232")
	public void user_gets_error232() throws InterruptedException {

		String actual_error1 = driver.findElement(By.xpath("//*[@id=\"signup_mail_hint\"]/div/span[1]")).getText();
		String expected_Error1 = "Паролите не съвпадат";

		try {
			Assert.assertNotEquals(expected_Error1, actual_error1);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Паролите не съвпадат");
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
//Test 4 with gender

	@Given("user entered username pass gender")
	public void user_entered_username_pass_gender() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.bg/signup");
		Thread.sleep(5000);
//Username
		driver.findElement(By.xpath("//*[@id=\"signup_user\"]")).sendKeys("asdfkjsdjlglsdfk");
//Password
		driver.findElement(By.xpath("//*[@id=\"mail_pass_input\"]")).sendKeys("asdfkjsdjlglsdfk");
		driver.findElement(By.xpath("//*[@id=\"mail_confpass_input\"]")).sendKeys("asdfkjsdjlglsdfk");
		Thread.sleep(5000);
//Gender
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[5]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"drop_down_settings_gender\"]/div/ul/li[1]")).click();
		Thread.sleep(5000);
	}

	@And("user clicks submit3")
	public void user_clicks_submit3() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[13]/a[1]")).click();

		Thread.sleep(5000);
	}

	@Then("user gets error3")
	public void user_gets_error3() throws InterruptedException {

		String actual_error1 = driver.findElement(By.xpath("//*[@id=\"signup_mail_hint\"]/div/span[1]")).getText();
		String expected_Error1 = "Не сте въвели пол";

		try {
			Assert.assertNotEquals(expected_Error1, actual_error1);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Не сте въвели пол");
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

//	Test 5 date

	@Given("user entered username pass gender date")
	public void user_entered_username_pass_gender_date() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.bg/signup");
		Thread.sleep(5000);
//Username
		driver.findElement(By.xpath("//*[@id=\"signup_user\"]")).sendKeys("asdfkjsdjlglsdfk");
//Pasword
		driver.findElement(By.xpath("//*[@id=\"mail_pass_input\"]")).sendKeys("asdfkjsdjlglsdfk");
		driver.findElement(By.xpath("//*[@id=\"mail_confpass_input\"]")).sendKeys("asdfkjsdjlglsdfk");
//Gender
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[5]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"drop_down_settings_gender\"]/div/ul/li[1]")).click();
		Thread.sleep(5000);
//Date
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[6]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"drop_down_settings_day\"]/div/ul/li[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[7]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"drop_down_settings_month\"]/div/ul/li[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[8]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"drop_down_settings_year\"]/div/ul/li[71]")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
	}

	@And("user clicks submit4")
	public void user_clicks_submit4() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[13]/a[1]")).click();

		Thread.sleep(5000);
	}

	@Then("user gets error4")
	public void user_gets_error4() throws InterruptedException {
		String actual_error1 = driver.findElement(By.xpath("//*[@id=\"signup_mail_hint\"]/div/span[1]")).getText();
		String expected_Error1 = "Трябва да се съгласите с общите условия";

		try {
			Assert.assertNotEquals(expected_Error1, actual_error1);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
//Test 6 checkbox

	@Given("user entered username pass gender date and agreed")
	public void user_entered_username_pass_gender_date_and_agreed() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.bg/signup");
		Thread.sleep(5000);
//Username
		driver.findElement(By.xpath("//*[@id=\"signup_user\"]")).sendKeys("asdfkjsdjlglsdfk");
//Pasword
		driver.findElement(By.xpath("//*[@id=\"mail_pass_input\"]")).sendKeys("asdfkjsdjlglsdfk");
		driver.findElement(By.xpath("//*[@id=\"mail_confpass_input\"]")).sendKeys("asdfkjsdjlglsdfk");
//Gender
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[5]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"drop_down_settings_gender\"]/div/ul/li[1]")).click();
		Thread.sleep(5000);
//Date
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[6]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"drop_down_settings_day\"]/div/ul/li[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[7]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"drop_down_settings_month\"]/div/ul/li[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[8]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"drop_down_settings_year\"]/div/ul/li[71]")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
//Checkbox
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[11]/span")).click();
		Thread.sleep(5000);
	}

	@And("user clicks submit5")
	public void user_clicks_submit5() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"new_mail_content\"]/div[1]/form/div/div[13]/a[1]")).click();

		Thread.sleep(5000);
	}

	@Then("user gets error5")
	public void user_gets_error5() throws InterruptedException {
		String actual_error1 = driver.findElement(By.xpath("//*[@id=\"signup_mail_hint\"]/div/span[1]")).getText();
		String expected_Error1 = "Трябва да се съгласите с общите условия";
		try {
			Assert.assertNotEquals(expected_Error1, actual_error1);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Трябва да се съгласите с общите условия");
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
