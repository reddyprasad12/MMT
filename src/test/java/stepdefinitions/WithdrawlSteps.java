package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.java.en.*;

public class WithdrawlSteps {
    @Given("I have a balance of ${int} in my account")
    public void i_have_a_balance_of_$_in_my_account(Integer int1) {
        System.out.println(int1);
    }
    @When("I request ${int}")
    public void i_request_$(Integer int1) {
        System.out.println(int1);

    }
    @Then("${int} should be dispensed")
    public void $_should_be_dispensed(Integer int1) {
        System.out.println(int1);

    }

}
