package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"src/test/resources/features/newproduct"},
        glue= {"steps/newproduct"},
        monochrome=true
)
public class NewProductRunner {
}