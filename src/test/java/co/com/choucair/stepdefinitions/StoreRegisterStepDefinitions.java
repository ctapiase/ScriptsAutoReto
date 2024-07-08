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

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
        OnStage.theActorInTheSpotlight().wasAbleTo(EnterOnRegister.registerPage());
    }

    @When("the user enters the registration form data")
    public void theUserEntersTheRegistrationFormData(DataTable data) {
            OnStage.theActorInTheSpotlight().attemptsTo(Register.onTheSite(UserLoombokData.setData(data).get(0)));
    }


    @Then("^the system should display the message (.*)$")
    public void theSystemShouldDisplayTheMessageSignUpSuccessful(String msg) {
        OnStage.theActorInTheSpotlight().should(seeThat(CaptureTxt.popUp(), equalToIgnoringWhiteSpace(msg)));
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
        OnStage.theActorInTheSpotlight().wasAbleTo(EnterOnLogin.enter());
    }
    @When("the user enters the login form data")
    public void theUserEntersTheLoginFormData(DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(LogIn.onTheSite(UserLoombokData.setData(data).get(0)));
    }
    @Then("the system should display in the Home Page the message {string}")
    public void theSystemShouldDisplayInTheHomePageTheMessage(String msg) {
        OnStage.theActorInTheSpotlight().should(seeThat(Validate.messageWelcome(msg), equalToIgnoringWhiteSpace(msg)));
    }

    @When("the user enters the login form fail data")
    public void theUserEntersTheLoginFormFailData(DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(LogInF.onTheSite(UserLoombokData.setData(data).get(0)));
    }


}
