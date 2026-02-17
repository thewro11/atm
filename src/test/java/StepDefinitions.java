
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.tfog.atm.Atm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions {
  private Atm atm;

  @Given("start the ATM machine")
  public void start_the_atm_machine() throws Exception {
    atm = new Atm();
  }

  @Then("user with bank account id {string} should be able to log in")
  public void user_with_bank_account_id_should_be_able_to_log_in(String bankAccountId) {
    assertDoesNotThrow(() -> {
      atm.login(bankAccountId);
    });
  }
}
