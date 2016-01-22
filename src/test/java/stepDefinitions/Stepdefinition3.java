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

public class Stepdefinition3 {

	private WebDriver driver;
	private String URL = "http://localhost/mounika/booking.html";

	@Given("^User is in Booking Page on \"([^\"]*)\"$")
	public void user_is_in_Booking_Page_on(String browser) throws Throwable {

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

	@When("^User select departure city in booking page$")
	public void user_select_departure_city_in_booking_page() throws Throwable {

		Select departure = new Select(driver.findElement(By.xpath(".//*[@id='depart']/select")));

		departure.selectByValue("New York");

		Thread.sleep(1000);
	}

	@When("^User select departure date$")
	public void user_select_departure_date() throws Throwable {

		driver.findElement(By.id("datepicker")).sendKeys("29/01/2016");

		Thread.sleep(1000);
	}

	@When("^User select arrival city$")
	public void user_select_arrival_city() throws Throwable {

		Select arrival = new Select(driver.findElement(By.xpath(".//*[@id='arrive']/select")));

		arrival.selectByVisibleText("Sydney");

		Thread.sleep(1000);
	}

	@When("^User select return date$")
	public void user_select_return_date() throws Throwable {

		driver.findElement(By.id("datepicker1")).sendKeys("31/01/2016");

		Thread.sleep(1000);
	}

	@When("^User enter number of passengers$")
	public void user_enter_number_of_passengers() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='passengers']/input")).sendKeys("3");

		Thread.sleep(1000);
	}

	@When("^User select round trip$")
	public void user_select_round_trip() throws Throwable {

		driver.findElement(By.id("tripcheckbox")).click();

		Thread.sleep(1000);
	}

	@When("^User select Seating Preference$")
	public void user_select_Seating_Preference() throws Throwable {

		driver.findElement(By.id("aisle")).click();

		Thread.sleep(1000);
	}

	@When("^User select type of ticket$")
	public void user_select_type_of_ticket() throws Throwable {

		driver.findElement(By.id("business")).click();

		Thread.sleep(1000);
	}

	@When("^User Click on confirm button$")
	public void user_Click_on_confirm_button() throws Throwable {

		driver.findElement(By.id("confirm")).click();

		Thread.sleep(1000);

	}

	@Then("^User successfully go to payment page$")
	public void user_successfully_go_to_payment_page() throws Throwable {

		System.out.println("User successfully go to payment page");

		driver.quit();
	}
}
