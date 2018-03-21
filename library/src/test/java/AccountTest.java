import com.thoughtworks.step.bank.Account;
import com.thoughtworks.step.bank.InvalidAccNumException;
import com.thoughtworks.step.bank.LowBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AccountTest {
  private Account account;

  @Before
  public void setUp() throws InvalidAccNumException {
    account = new Account("yogi","1234-1234",1000);
  }

  @Test
  public void checkAccNumFormat() throws InvalidAccNumException {
    account = new Account("yogi","1234-1234",1000);
  }

  @Test(expected = InvalidAccNumException.class)
  public void checkInvalidAccNum() throws InvalidAccNumException {
    account = new Account("yogi","123",1000);
  }

    @Test
  public void checkBalance() {
    assertThat(account.getBalance(),is(1000.0));
  }

  @Test
  public void checkAccountNumber() {
    assertThat(account.getAccountNumber(),is("1234-1234"));
  }
  @Test
  public void checkAccountName() {
    assertThat(account.getName(),is("yogi"));
  }

  @Test
  public void checkCashWithdraw() throws LowBalanceException {
    assertThat(account.withdraw(500),is(500));
    assertThat(account.getBalance(),is(500.0));
  }

  @Test(expected = LowBalanceException.class)
  public void checkInvalidCashWithdraw() throws LowBalanceException {
    account.withdraw(2000);
  }

  @Test
  public void checkCanDebit() {
    assertTrue(account.canDebit(1000));
  }

  @Test
  public void checkCanNotDebit() {
    assertFalse(account.canDebit(2000));
  }
}
