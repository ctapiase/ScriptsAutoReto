package co.com.choucair.tasks;

import co.com.choucair.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class EnterOnLogin implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.LOGIN_BUTOON)
        );
    }

    public static EnterOnLogin enter(){
        return Tasks.instrumented(EnterOnLogin.class);
    }
}
