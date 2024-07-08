package co.com.choucair.tasks;

import co.com.choucair.models.UserLoombokData;
import co.com.choucair.userinterfaces.LogInForm;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class LogInF implements Task {
    UserLoombokData userLoombokData;

    public LogInF(UserLoombokData userLoombokData) {
        this.userLoombokData = userLoombokData;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userLoombokData.getUsername()).into(LogInForm.USERNAME),
                Enter.theValue(userLoombokData.getPassword()).into(LogInForm.PASSWORD)
        );
    }

    public static LogInF onTheSite (UserLoombokData userLoombokData){
        return Instrumented.instanceOf(LogInF.class).withProperties(userLoombokData);
    }
}
