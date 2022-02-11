package automation.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/feature/EndToEndTest.feature"},
        glue = {"automation.steps","automation.hooks"},
        tags = "@Smoke",
        plugin = {"pretty"}
)


public class SmokeTest {
}
