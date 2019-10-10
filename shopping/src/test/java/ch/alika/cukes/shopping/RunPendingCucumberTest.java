package ch.alika.cukes.shopping;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@pending"},
        plugin = {"progress"},
        features = "classpath:features",
        snippets = SnippetType.CAMELCASE)
public class RunPendingCucumberTest {
}
