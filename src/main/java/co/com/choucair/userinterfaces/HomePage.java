package co.com.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target SING_UP_BUTTON = Target.the("button login").located(By.id("signin2"));
    public static final Target LOGIN_BUTOON = Target.the("button login").located(By.id("login2"));
    public static final Target TXT_USER = Target.the("texto usuario").locatedBy("//*[@id='nameofuser']");

}
