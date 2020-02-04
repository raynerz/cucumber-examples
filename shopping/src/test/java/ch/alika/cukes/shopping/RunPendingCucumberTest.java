package ch.alika.cukes.shopping;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@pending"},
        plugin = {"progress"},
        features = "classpath:features",
        strict = true,
        snippets = CAMELCASE)
public class RunPendingCucumberTest {
}
