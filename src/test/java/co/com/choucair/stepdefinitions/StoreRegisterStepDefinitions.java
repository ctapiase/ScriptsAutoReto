package co.com.choucair.stepdefinitions;

import co.com.choucair.models.UserLoombokData;
import co.com.choucair.questions.CaptureTxt;
import co.com.choucair.questions.Validate;
import co.com.choucair.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.choucair.utils.GlobalData.ACTOR;
import static co.com.choucair.utils.GlobalData.URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

public class StoreRegisterStepDefinitions {

    @Given("the user are on home page")
    public void theUserAreOnHomePage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }

    @When("attempts to sign up")
    public void attemptsToSignUp(DataTable data) {
            OnStage.theActorInTheSpotlight().attemptsTo(Register.onTheSite(UserLoombokData.setData(data).get(0)));
    }


    @Then("^the system should display the message (.*)$")
    public void theSystemShouldDisplayTheMessageSignUpSuccessful(String msg) {
        OnStage.theActorInTheSpotlight().should(seeThat(CaptureTxt.popUp(), equalToIgnoringWhiteSpace(msg)));
    }

    @When("attempts to log in")
    public void attemptsToLogIn(DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(LogIn.onTheSite(UserLoombokData.setData(data).get(0)));
    }
    @Then("the system should display in the Home Page the message {string}")
    public void theSystemShouldDisplayInTheHomePageTheMessage(String msg) {
        OnStage.theActorInTheSpotlight().should(seeThat(Validate.messageWelcome(msg), equalToIgnoringWhiteSpace(msg)));
    }


}
