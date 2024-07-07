package co.com.choucair.interactions;


import co.com.choucair.userinterfaces.LogInForm;
import co.com.choucair.userinterfaces.SingUpForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.*;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class Capture implements Interaction {
    private String alertText;
    WebDriver driver = ThucydidesWebDriverSupport.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Actions actions = new Actions(driver);
    @Override
    public <T extends Actor> void performAs(T actor) {


        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alertText = alert.getText();
        actor.remember("Message", alertText);
        System.out.println(alertText);
    }

    public static Capture popUp() {
        return new Capture();
    }
}
