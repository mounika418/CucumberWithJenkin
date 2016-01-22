package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinition2 {

	private WebDriver driver;
	private String URL = "http://localhost/mounika/information.html";

	@Given("^User is in Signup Page on \"([^\"]*)\"$")
	public void user_is_in_Signup_Page_on(String browser) throws Throwable {

		if (browser.equalsIgnoreCase("FF")) {

			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//Drivers//IEDriverServer.exe");

			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("GC")) {

			System.setProperty("webdriver.chrome.driver",

					System.getProperty("user.dir") + "//Drivers//chromedriver.exe");

			driver = new ChromeDriver();
		}

		driver.get(URL);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(1000);
	}

	@When("^User enter forename in signup page$")
	public void user_enter_forename_in_signup_page() throws Throwable {

		driver.findElement(By.id("forenames")).sendKeys("Test");

		Thread.sleep(1000);
	}

	@When("^User enter surname$")
	public void user_enter_surname() throws Throwable {

		driver.findElement(By.id("surename")).sendKeys("Triangle");

		Thread.sleep(1000);
	}

	@When("^User select gender$")
	public void user_select_gender() throws Throwable {

		driver.findElement(By.id("radiof")).click();

		Thread.sleep(1000);
	}

	@When("^User enter address$")
	public void user_enter_address() throws Throwable {

		driver.findElement(By.id("address1")).sendKeys("H.No 1-68/4&5, Arunodaya Colony, Blue Dart Courier Building");

		Thread.sleep(1000);

		driver.findElement(By.id("address2")).sendKeys("Madhapur");

		Thread.sleep(1000);
	}

	@When("^User enter city$")
	public void user_enter_city() throws Throwable {

		driver.findElement(By.id("city")).sendKeys("Hyderabad");

		Thread.sleep(1000);

	}

	@When("^User enter postal code$")
	public void user_enter_postal_code() throws Throwable {

		driver.findElement(By.id("postalcode")).sendKeys("500081");

		Thread.sleep(1000);
	}

	@When("^User enter Telephone$")
	public void user_enter_Telephone() throws Throwable {

		driver.findElement(By.id("telephone")).sendKeys("9494634250");

		Thread.sleep(1000);
	}

	@When("^User select country$")
	public void user_select_country() throws Throwable {

		Select country = new Select(driver.findElement(By.xpath(".//*[@id='form']/form/select")));

		Thread.sleep(1000);

		country.selectByVisibleText("India");

		Thread.sleep(1000);
	}

	@When("^User Click on Submit button$")

	public void user_Click_on_Submit_button() throws Throwable {

		driver.findElement(By.xpath("//input[@id='submit']")).click();

		Thread.sleep(1000);
	}

	@Then("^User successfully go to Booking page$")

	public void user_successfully_go_to_Booking_page() throws Throwable {

		System.out.println("User successfully go to booking page");

		driver.quit();
	}
}
