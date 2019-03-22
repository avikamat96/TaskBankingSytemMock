/**
 * 
 */
package com.epam.services;

import com.epam.exceptions.InsufficientBalanceException;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;

/**
 * The Class TransactionService.
 *
 * @author Avinash_Kamat
 */
public class TransactionService {

 
  /**
   * Withdraw money.
   *
   * @param accountNumber the account number
   * @param amount the amount
   * @return the account
   * @throws UserAccountNotFoundException the user account not found exception
   * @throws InsufficientBalanceException the insufficient balance exception
   */
  public Account withdrawMoney(long accountNumber, double amount)
      throws UserAccountNotFoundException, InsufficientBalanceException {
    AccountService accountService = new AccountService();
    Account account = accountService.getAccountDetails(accountNumber);
    Double getCurrentBalance = account.getAccountBalance();
    if (getCurrentBalance - amount >= 0) {
      account.setAccountBalance(getCurrentBalance - amount);
      return account;
    } else {
      throw new InsufficientBalanceException("Insufficient balance");
    }
    

  }

  /**
   * Deposit money.
   *
   * @param accountNumber the account number
   * @param amount the amount
   * @return the account
   * @throws UserAccountNotFoundException the user account not found exception
   */
  public Account depositMoney(long accountNumber, double amount) throws UserAccountNotFoundException {
    AccountService accountService = new AccountService();
    Account account = accountService.getAccountDetails(accountNumber);
    account.setAccountBalance(account.getAccountBalance() + amount);
    return account;
  }

}
