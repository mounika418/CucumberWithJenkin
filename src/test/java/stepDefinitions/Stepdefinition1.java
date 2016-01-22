package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinition1 {

	private WebDriver driver;
	private String URL = "http://localhost/mounika/index.html";

	@Given("^User is in Home Page on \"([^\"]*)\"$")
	public void user_is_in_Home_Page_on(String browser) throws Throwable {

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

	@When("^User Click on Checkbox$")
	public void user_Click_on_Checkbox() throws Throwable {

		driver.findElement(By.id("checkbox")).click();

		Thread.sleep(1000);
	}

	@When("^User Click on Next button$")
	public void user_Click_on_Next_button() throws Throwable {

		driver.findElement(By.id("next")).click();

		Thread.sleep(1000);
	}

	@Then("^User successfully go to Signup page$")

	public void user_successfully_go_to_Signup_page() throws Throwable {

		System.out.println("User successfully go to signup page");

		driver.quit();
	}
}
