package co.com.choucair.questions;

import co.com.choucair.interactions.Capture;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CaptureTxt implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(Capture.popUp());
        String Message = actor.recall("Message");
        System.out.println("Question" + Message);
        return Message;
    }

    public static CaptureTxt popUp() {
        return new CaptureTxt();
    }
}
