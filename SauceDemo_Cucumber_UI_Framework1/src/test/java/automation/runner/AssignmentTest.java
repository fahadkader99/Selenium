package automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/feature/HomeAssignment_1.feature","src/test/resources/feature/HomeAssignment_2.feature","src/test/resources/feature/HomeAssignment_3.feature"},
        glue = {"automation.steps","automation.hooks"},
        tags = "@Assignment",
        plugin = {"pretty"}
)
public class AssignmentTest {
}
