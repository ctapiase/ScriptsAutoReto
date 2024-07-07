package co.com.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;


public class LogInForm {
    public static final Target USERNAME = Target.the("campo username").locatedBy("//input[@id='loginusername']");
    public static final Target PASSWORD = Target.the("campo password").locatedBy("//input[@id='loginpassword']");
    public static final Target BTN_LOGIN = Target.the("boton login").locatedBy("(//button[@class='btn btn-primary'])[3]");
}
