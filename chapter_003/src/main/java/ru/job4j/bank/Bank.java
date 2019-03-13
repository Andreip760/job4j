package ru.job4j.bank;

import java.util.*;
/**
 * Class represents the bank transactions system.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 13.03.2019
 */
public class Bank {
    private final Map<User, List<Account>> userAccounts = new HashMap<>();
    /**
     * Adding the new user.
     * @param user User.
     */
    public void addUser(User user) {
        this.userAccounts.putIfAbsent(user, new ArrayList<>());
    }
    /**
     * Deleting user.
     * @param user User.
     */
    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }
    /**
     * Adding an account to the existing user
     * @param passport User's passport.
     * @param account Account.
     */
    public void addAccountToUser(String passport, Account account) {
        User user = findUser(passport);
        if (user != null && this.userAccounts.get(user).indexOf(account) < 0) {
            this.userAccounts.get(user).add(account);
        }
    }
    /**
     * Deleting user's account.
     * @param passport User's passport.
     * @param account Account to delete.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = findUser(passport);
        if (user != null) {
            this.userAccounts.get(user).remove(account);
        }
    }
    /**
     * Getting user's accounts.
     * @param passport User's passport.
     * @return Accounts.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        User user = findUser(passport);
        if (user != null) {
            result = this.userAccounts.get(user);
        }
        return result;
    }
    /**
     * Transferring money between accounts.
     * @param srcPassport Source user passport.
     * @param srcRequisite Source account requisites.
     * @param destPassport Target user passport.
     * @param destRequisite Target account requisites.
     * @param amount Amount to transfer.
     * @return Operation result.
     */
    public boolean transferMoney(
            final String srcPassport,
            final String srcRequisite,
            final String destPassport,
            final String destRequisite,
            final double amount
    ) {
        boolean result = false;
        User srcUser = findUser(srcPassport);
        User destUser = findUser(destPassport);
        if (srcUser != null && destUser != null) {
            Account srcAccount = findAccount(srcUser, srcRequisite);
            Account dstAccount = findAccount(destUser, destRequisite);
            if (srcAccount != null && dstAccount != null && srcAccount.getValue() >= amount) {
                srcAccount.withdraw(amount);
                dstAccount.supply(amount);
                result = true;
            }
        }
        return result;
    }
    /**
     * Finding an user by its passport.
     * @param passport Passport.
     * @return Found user or null.
     */
    private User findUser(final String passport) {
        User result = null;
        for (User user : this.userAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }
    /**
     * Finding an user's account by its requisites.
     * @param user User.
     * @param requisites Account requisites.
     * @return Found account or null.
     */
    private Account findAccount(final User user, final String requisites) {
        Account result = null;
        for (Account account : this.userAccounts.get(user)) {
            if (account.getRequisites().equals(requisites)) {
                result = account;
                break;
            }
        }
        return result;
    }
}
