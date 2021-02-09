package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver = null;
	
	
	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.gecko.driver", "C:/Gecko driver/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {

		driver.navigate().to("https://google.com");
	}

	@When("user enters text in search box")
	public void user_enters_text_in_search_box() {

		driver.findElement(By.name("q")).sendKeys("mail.bg");
	}

	@And("hits enter")
	public void hits_enter() {

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@And("user clicks on home page")
	public void user_clicks_on_home_page() {

		driver.findElement(By.className("l")).sendKeys(Keys.ENTER);
	}

	@Then("user clicks on new registartion")
	public void user_clicks_on_new_registartion() {

		driver.findElement(By.className("signup-link")).sendKeys(Keys.ENTER);
		driver.quit();
	}

}
