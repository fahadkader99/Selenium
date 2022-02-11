package automation.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/feature/SauceDemo_TestNG_UI_Framework2.feature"},
        glue = {"automation.steps","automation.hooks"},
        tags = "@Regression",
        plugin = {"pretty"}
)


public class RegressionTest {
}
