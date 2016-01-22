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

public class Stepdefinition4 {

	private WebDriver driver;
	private String URL = "http://localhost/mounika/payment.html";

	@Given("^User is in payment Page on \"([^\"]*)\"$")
	public void user_is_in_payment_Page_on(String browser) throws Throwable {

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

	@When("^User enter a credit card number in booking page$")
	public void user_enter_a_credit_card_number_in_booking_page() throws Throwable {

		driver.findElement(By.id("ccnum")).sendKeys("5234567890");

		Thread.sleep(1000);
	}

	@When("^User enter a name on card$")
	public void user_enter_a_name_on_card() throws Throwable {

		driver.findElement(By.id("ccname")).sendKeys("TestTriangle");

		Thread.sleep(1000);
	}

	@When("^User select expiry date$")
	public void user_select_expiry_date() throws Throwable {

		Select expiry = new Select(driver.findElement(By.id("ccmonth")));

		Thread.sleep(1000);

		expiry.selectByVisibleText("December");

		Thread.sleep(1000);

		Select date = new Select(driver.findElement(By.id("ccyear")));

		date.selectByVisibleText("2018");

		Thread.sleep(1000);
	}

	@When("^User select cvc number$")
	public void user_select_cvc_number() throws Throwable {

		driver.findElement(By.id("ccvc")).sendKeys("534");

		Thread.sleep(1000);
	}

	@When("^User Click on paynow button$")
	public void user_Click_on_paynow_button() throws Throwable {

		driver.findElement(By.id("paynow")).click();

		Thread.sleep(1000);

	}

	@Then("^User successfully go to conformation page$")
	public void user_successfully_go_to_conformation_page() throws Throwable {

		driver.quit();

		System.out.println("User successfully go to conformation page");
	}
}
