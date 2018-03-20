import com.thoughtworks.step.bank.Account;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
  @Test

  public void checkBalance() {
    Account account = new Account("yogi",123,1000);
    assertThat(account.getBalance(),is(1000.0));
  }
}
