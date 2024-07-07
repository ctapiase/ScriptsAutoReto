package co.com.choucair.tasks;

import co.com.choucair.models.UserLoombokData;
import co.com.choucair.userinterfaces.LogInForm;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LogIn implements Task {
    UserLoombokData userLoombokData;

    public LogIn(UserLoombokData userLoombokData) {
        this.userLoombokData = userLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userLoombokData.getUsername()).into(LogInForm.USERNAME),
                Enter.theValue(userLoombokData.getPassword()).into(LogInForm.PASSWORD),
                Click.on(LogInForm.BTN_LOGIN)
        );
    }

    public static LogIn onTheSite (UserLoombokData userLoombokData){
        return Instrumented.instanceOf(LogIn.class).withProperties(userLoombokData);
    }
}
