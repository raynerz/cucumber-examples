package ch.alika.cukes.shopping;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"not @pending"},
        plugin = {"pretty"},
        features = "classpath:features",
        strict = true,
        snippets = CAMELCASE)
public class RunDoneCucumberTest {

}
