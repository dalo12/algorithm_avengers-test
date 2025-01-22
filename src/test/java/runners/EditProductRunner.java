package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"src/test/resources/features/editproduct.feature"},
        glue= {"steps"},
        monochrome=true
)

public class EditProductRunner {
}
