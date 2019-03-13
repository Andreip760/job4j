package ru.job4j.bank;
/**
 * Class for user's bank account.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 13.03.2019
 */
public class Account {
    private double value;
    private final String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    /**
     * Getting value of the account.
     * @return Value;
     */
    public double getValue() {
        return this.value;
    }
    /**
     * Getting requisites.
     * @return Requisites.
     */
    public String getRequisites() {
        return this.requisites;
    }
    /**
     * Withdrawing money from the account.
     * @param amount Amount.
     */
    public void withdraw(double amount) {
        this.value -= amount;
    }

    /**
     * Supplementing the account
     * @param amount Amount.
     */
    public void supply(double amount) {
        this.value += amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return getRequisites().equals(account.getRequisites());
    }

    @Override
    public int hashCode() {
        return requisites.hashCode();
    }
}
