package co.com.choucair.questions;

import co.com.choucair.interactions.Capture;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CaptureTxt implements Question<String> {
    String message;
    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(Capture.popUp());
        message = actor.recall("Message");
        return message;
    }

    public static CaptureTxt popUp() {
        return new CaptureTxt();
    }
}
