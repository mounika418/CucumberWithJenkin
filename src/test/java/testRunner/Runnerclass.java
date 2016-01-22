package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",glue={"stepDefinitions"}, format = { "pretty", "html:target/Report/", "json:target/Report/cucumber.json" }, tags = {
		"@homepage,@signuppage,@bookingpage,@paymentpage" }, monochrome = true)

public class Runnerclass {

}
