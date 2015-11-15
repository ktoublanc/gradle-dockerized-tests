import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by kevin on 08/11/2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:build/cucumber", "json:build/cucumber-json.json"})
public class RunnerTest {

}
