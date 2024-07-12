package co.com.choucair.interactions;


import co.com.choucair.userinterfaces.LogInForm;
import co.com.choucair.userinterfaces.SingUpForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Capture implements Interaction {
    WebDriver driver = ThucydidesWebDriverSupport.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    String alertText;

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (actor.recall("registro") != null) {
            actor.attemptsTo(
                    DoubleClick.on(SingUpForm.SING_UP)

            );
        }
        if (actor.recall("login") != null) {
            actor.attemptsTo(
                    DoubleClick.on(LogInForm.BTN_LOGIN)
            );
        }

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alertText = alert.getText();
        alert.accept();
        actor.remember("Message", alertText);
    }

    public static Capture popUp() {
        return new Capture();
    }
}
