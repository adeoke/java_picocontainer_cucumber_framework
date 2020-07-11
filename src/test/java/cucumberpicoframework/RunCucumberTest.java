package cucumberpicoframework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Cucumber test runner annotation
@RunWith(Cucumber.class)
//default options for running the tests
@CucumberOptions(
        plugin = {"pretty",
        "html:target/ApplicationTestReports/html",
        "json:target/ApplicationTestReports/report.json",
        "junit:target/ApplicationTestReports/report/report.xml"},
        //define the feature file location from src root
        features = "src/test/java/cucumberpicoframework/features",
        //specify the location of step definitions from the top level package,
        //and also the hooks file
        glue = {"cucumberpicoframework/steps", "cucumberpicoframework/hooks"}

)
public class RunCucumberTest {
}
