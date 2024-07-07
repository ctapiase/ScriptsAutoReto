package co.com.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;


public class SingUpForm {
    public static final Target TXT_USER = Target.the("campo username").locatedBy("//input[@id='sign-username']");
    public static final Target TXT_PASS = Target.the("campo password").locatedBy("//input[@id='sign-password']");
    public static final Target SING_UP = Target.the("boton registrar").locatedBy("(//button[@class='btn btn-primary'])[2]");
}
