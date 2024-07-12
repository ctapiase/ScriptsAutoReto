package co.com.choucair.tasks;

import co.com.choucair.models.UserLoombokData;
import co.com.choucair.userinterfaces.HomePage;
import co.com.choucair.userinterfaces.SingUpForm;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Register implements Task {
    UserLoombokData userLoombokData;

    public Register(UserLoombokData userLoombokData) {
        this.userLoombokData = userLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.SING_UP_BUTTON),
                Enter.theValue(userLoombokData.getUsername()).into(SingUpForm.TXT_USER),
                Enter.theValue(userLoombokData.getPassword()).into(SingUpForm.TXT_PASS)

        );
        actor.remember("registro","si");
    }

    public static Register onTheSite(UserLoombokData userLoombokData){
        return Instrumented.instanceOf(Register.class).withProperties(userLoombokData);
    }
}
