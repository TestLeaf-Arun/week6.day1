package runner;
import io.cucumber.testng.CucumberOptions;
import steps.BaseClassLeaftaps;

@CucumberOptions(features = "src/test/java/features",
				 glue = "steps",
				 monochrome = true,
				 publish = true)

public class CucumberRunnerLeaftaps extends BaseClassLeaftaps {

}