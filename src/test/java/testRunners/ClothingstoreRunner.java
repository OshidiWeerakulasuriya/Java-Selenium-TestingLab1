package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber.html"}, 
		tags = "@tag1 or @tag2 or @tag3",
        features = "C:/Users/oshid/Documents/RTU/S2/Testing and software quality/Practical task/lab1/SeleniumTests/src/test/java/features/ClothingStoreRegistrationAndLogin.feature",
        glue = "testRunners.stepDefinitions")

                           
public class ClothingstoreRunner {

}
