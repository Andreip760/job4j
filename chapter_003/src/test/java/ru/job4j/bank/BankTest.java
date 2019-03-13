package ru.job4j.bank;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 13.03.2019
 */
public class BankTest {
    private final Bank bank = new Bank();
    private final User firstUser = new User("Ivan", "12345");
    private final Account firstAccount = new Account(100D, "Account1");
    private final Account secondAccount = new Account(200D, "Account2");
    /**
     * Creating the first user and its accounts.
     */
    @Before
    public void init() {
        this.bank.addUser(this.firstUser);
        this.bank.addAccountToUser("12345", this.firstAccount);
        this.bank.addAccountToUser("12345", this.secondAccount);
    }
    /**
     * Receiving the first user accounts
     */
    @Test
    public void whenAddUserAndTwoAccountsThenSeeUserAccounts() {
        List<Account> result = this.bank.getUserAccounts("12345");
        assertThat(result, is(Arrays.asList(firstAccount, secondAccount)));
    }
    /**
     * Trying to add an account with the same requisites as the first.
     */
    @Test
    public void whenAddAccountsWithSameReqsThenSeeStartUserAccounts() {
        this.bank.addAccountToUser("12345", new Account(1D, "Account1"));
        List<Account> result = this.bank.getUserAccounts("12345");
        assertThat(result, is(Arrays.asList(firstAccount, secondAccount)));
    }
    /**
     * Adding an user with the same name but different passport.
     */
    @Test
    public void whenAddSameUserNameThenSeeBothUsersAccounts() {
        User secondUser = new User(this.firstUser.getName(), "45678");
        Account account = new Account(10D, "AddUserAccount");
        this.bank.addUser(secondUser);
        this.bank.addAccountToUser(secondUser.getPassport(), account);
        List<Account> firstResult = this.bank.getUserAccounts(firstUser.getPassport());
        List<Account> secondResult = this.bank.getUserAccounts(secondUser.getPassport());
        assertThat(firstResult.get(0).getRequisites(), is(firstAccount.getRequisites()));
        assertThat(secondResult.get(0).getRequisites(), is(account.getRequisites()));
    }
    /**
     * Deleting the user.
     */
    @Test
    public void whenAddDeleteFirstThenEmptyAccounts() {
        this.bank.deleteUser(this.firstUser);
        List<Account> result = this.bank.getUserAccounts("12345");
        assertThat(result, is(Collections.EMPTY_LIST));
    }
    /**
     * Deleting the user's account.
     */
    @Test
    public void whenDeleteAccountFromUserThenWithoutDeleted() {
        this.bank.deleteAccountFromUser("12345", firstAccount);
        List<Account> result = this.bank.getUserAccounts("12345");
        assertThat(result, is(Arrays.asList(secondAccount)));
    }
    /**
     * Transferring between user's own accounts and amount is correct.
     */
    @Test
    public void whenTransferToOwnAccountAndAmountCorrectThenTrue() {
        boolean result = this.bank.transferMoney(
                this.firstUser.getPassport(),
                this.firstAccount.getRequisites(),
                this.firstUser.getPassport(),
                this.secondAccount.getRequisites(),
                50D);
        assertThat(result, is(true));
        assertThat(this.bank.getUserAccounts(this.firstUser.getPassport()).get(0).getValue(), is(50D));
        assertThat(this.bank.getUserAccounts(this.firstUser.getPassport()).get(1).getValue(), is(250D));
    }
    /**
     * Transferring to another user.
     */
    @Test
    public void whenTransferToAnotherThenTrue() {
        User secondUser = new User("Anna", "45678");
        Account account = new Account(0, "AnnaAccount1");
        this.bank.addUser(secondUser);
        this.bank.addAccountToUser(secondUser.getPassport(), account);
        boolean result = this.bank.transferMoney(
                this.firstUser.getPassport(),
                this.secondAccount.getRequisites(),
                secondUser.getPassport(),
                account.getRequisites(),
                150D);
        assertThat(result, is(true));
        assertThat(this.bank.getUserAccounts(this.firstUser.getPassport()).get(0).getValue(), is(100D));
        assertThat(this.bank.getUserAccounts(secondUser.getPassport()).get(0).getValue(), is(150D));
    }
    /**
     * Transferring from wrong user's passport
     */
    @Test
    public void whenFromWrongUserPassportThenFalse() {
        boolean result = this.bank.transferMoney(
                "14785",
                this.firstAccount.getRequisites(),
                this.firstUser.getPassport(),
                this.secondAccount.getRequisites(),
                10D);
        assertThat(result, is(false));
    }
    /**
     * Transferring to wrong user's passport
     */
    @Test
    public void whenToWrongUserPassportThenFalse() {
        boolean result = this.bank.transferMoney(
                this.firstUser.getPassport(),
                this.firstAccount.getRequisites(),
                "78945",
                this.secondAccount.getRequisites(),
                10D);
        assertThat(result, is(false));
    }
    /**
     * Transferring from wrong requisites.
     */
    @Test
    public void whenFromWrongRequisitesThenFalse() {
        boolean result = this.bank.transferMoney(
                this.firstUser.getPassport(),
                "aaa",
                this.firstUser.getPassport(),
                this.secondAccount.getRequisites(),
                10D);
        assertThat(result, is(false));
    }
    /**
     * Transferring to wrong user's requisites.
     */
    @Test
    public void whenToWrongRequisitesThenFalse() {
        boolean result = this.bank.transferMoney(
                this.firstUser.getPassport(),
                this.firstAccount.getRequisites(),
                this.firstUser.getPassport(),
                "aaa",
                10D);
        assertThat(result, is(false));
    }
    /**
     * Transferring incorrect amount.
     */
    @Test
    public void whenTransferIncorrectAmountAmountThenFalse() {
        boolean result = this.bank.transferMoney(
                this.firstUser.getPassport(),
                this.firstAccount.getRequisites(),
                this.firstUser.getPassport(),
                this.secondAccount.getRequisites(),
                150D);
        assertThat(result, is(false));
    }
}
