package co.com.choucair.tasks;

import co.com.choucair.models.UserLoombokData;
import co.com.choucair.userinterfaces.SingUpForm;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.assertj.core.api.Assertions.assertThat;

public class Register implements Task {
    UserLoombokData userLoombokData;

    public Register(UserLoombokData userLoombokData) {
        this.userLoombokData = userLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userLoombokData.getUsername()).into(SingUpForm.TXT_USER),
                Enter.theValue(userLoombokData.getPassword()).into(SingUpForm.TXT_PASS)

        );
    }

    public static Register onTheSite(UserLoombokData userLoombokData){
        return Instrumented.instanceOf(Register.class).withProperties(userLoombokData);
    }
}
