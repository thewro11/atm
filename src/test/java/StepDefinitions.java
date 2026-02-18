
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.tfog.atm.Atm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
  private Atm atm;

  @Given("start the ATM machine")
  public void start_the_atm_machine() throws Exception {
    atm = new Atm();
  }

  @When("user logs in with bank account id {string}")
  public void user_logs_in_with_bank_account_id(String bankAccountId) throws Exception {
    atm.login(bankAccountId);
  }

  @Then("user should deposit {double}THB into their bank account successfully")
  public void user_should_deposit_into_their_bank_account_successfully(double money) {
    assertDoesNotThrow(() -> {
      atm.deposit(money);
    });
  }

  @Then("user should not deposit {double}THB into their bank account")
  public void user_should_not_deposit_into_their_bank_account(double money) {
    assertThrows(Exception.class, () -> {
      atm.deposit(money);
    });
  }

  @Then("user with bank account id {string} should be able to log in")
  public void user_with_bank_account_id_should_be_able_to_log_in(String bankAccountId) {
    assertDoesNotThrow(() -> {
      atm.login(bankAccountId);
    });
  }

  @Then("user should not withdraw {double}THB from their bank account")
  public void user_should_not_withdraw_into_their_bank_account(double money) {
    assertThrows(Exception.class, () -> {
      atm.withdraw(money);
    });
  }

  @Then("user should withdraw {double}THB from their bank account successfully")
  public void user_should_withdraw_into_their_bank_account_successfully(double money) {
    assertDoesNotThrow(() -> {
      atm.withdraw(money);
    });
  }

}
