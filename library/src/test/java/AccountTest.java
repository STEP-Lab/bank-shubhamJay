import com.thoughtworks.step.bank.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
  private Account account;

  @BeforeEach
  void setUp() {
    account = new Account("yogi",123,1000);
  }

  @Test
  public void checkBalance() {
    assertThat(account.getBalance(),is(1000.0));
  }

  @Test
  public void checkAccountNumber() {
    assertThat(account.getAccountNumber(),is(123));
  }
  @Test
  public void checkAccountName() {
    assertThat(account.getName(),is("yogi"));
  }
}
