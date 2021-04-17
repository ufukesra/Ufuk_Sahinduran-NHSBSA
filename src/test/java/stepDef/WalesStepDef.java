package stepDef;

import cucumber.api.java.en.*;
import pages.Wales;
import java.util.Map;

public class WalesStepDef {
    Wales wales =new Wales();


    @Given("Navigate landing page and verify it then click start button")
    public void navigate_landing_page_and_verify_it_then_click_start_button() {
        wales.verifyLandingPageandClickStart();
    }

    @Given("Select {string} as country where you live")
    public void select_as_country_where_you_live(String country) {

        wales.selectWalesInCountries(country);
    }

    @When("I put my following Circumstances into Checker tool")
    public void i_put_my_following_Circumstances_into_Checker_tool(Map<String, String> circumstances) {
        wales.inputDateOfBirth(circumstances);

    }

    @Then("I should get a result of whether I will get help or not")
    public void i_should_get_a_result_of_whether_I_will_get_help_or_not() {

        wales.verifyCheckCompletedAndPrintResult();
    }

    @When("click next button")
    public void click_next_button() {
        wales.clickNextButtonwithoutSelectingCountry();
    }

    @Then("verify error text {string} and error type {string}")
    public void verify_error_text_and_error_type(String errorText, String errorType) {

        wales.verifyErrorMessage(errorText,errorType);

    }

}
