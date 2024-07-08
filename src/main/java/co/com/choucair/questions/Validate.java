package co.com.choucair.questions;

import co.com.choucair.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Validate implements Question <String>{
    private String msgValidation;

    public Validate (String msgValidation) {
        this.msgValidation = msgValidation;
    }
    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.TXT_USER, isVisible()).forNoMoreThan(10).seconds()
        );
        return Text.of(HomePage.TXT_USER).answeredBy(actor);
    }

    public static Validate messageWelcome(String msgValidation){
        return new Validate(msgValidation);
    }
}
