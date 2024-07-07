package co.com.choucair.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/store_register.feature",
        glue = "co.com.choucair.stepdefinitions",
        tags = "@Logino",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class StoreRegisterRunner {
}
