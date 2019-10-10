package ch.alika.cukes.shopping;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"not @pending"},
        plugin = {"pretty"},
        features = "classpath:features",
        snippets = SnippetType.CAMELCASE)
public class RunDoneCucumberTest {
}
