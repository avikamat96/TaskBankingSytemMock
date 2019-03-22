package com.epam.models;

import com.epam.enums.AccountType;

/**
 * The Class Account.
 *
 * @author Avinash_Kamat
 */
public class Account {

  Users user;
  long accountNumber;
  AccountType accountType;
  double accountBalance;

  /**
   * Instantiates a new account.
   */
  public Account() {
  }

  /**
   * Instantiates a new account.
   *
   * @param user the user
   */
  public Account(Users user) {
    this.user = user;
  }

  /**
   * Gets the account number.
   *
   * @return the accountNumber
   */
  public long getAccountNumber() {
    return accountNumber;
  }

  /**
   * Sets the account number.
   *
   * @param accountNumber the accountNumber to set
   */
  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  /**
   * Gets the account type.
   *
   * @return the accountType
   */
  public AccountType getAccountType() {
    return accountType;
  }

  /**
   * Sets the account type.
   *
   * @param accountType the accountType to set
   */
  public void setAccountType(AccountType accountType) {
    this.accountType = accountType;
  }

  /**
   * Gets the account balance.
   *
   * @return the accountBalance
   */
  public double getAccountBalance() {
    return accountBalance;
  }

  /**
   * Sets the account balance.
   *
   * @param accountBalance the accountBalance to set
   */
  public void setAccountBalance(Double accountBalance) {
    this.accountBalance = accountBalance;
  }

  /**
   * Sets the owner.
   *
   * @param user the new owner
   */
  public void setOwner(Users user) {
    this.user = user;
  }

  /**
   * Gets the owner.
   *
   * @return the owner
   */
  public Users getOwner() {
    return user;
  }

}
