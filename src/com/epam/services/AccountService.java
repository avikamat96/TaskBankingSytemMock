/**
 * 
 */
package com.epam.services;

import com.epam.enums.AccountType;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;
import com.epam.models.Users;
import com.epam.dao.AccountDaoImpl;

/**
 * The Class AccountService.
 *
 * @author Avinash_Kamat
 */
public class AccountService {

  /**
   * Creates the account.
   *
   * @param user the user
   * @param accountType the account type
   * @return the account
   */
  public Account createAccount(Users user, AccountType accountType) {
    AccountDaoImpl accountDao = new AccountDaoImpl();
    long userAccountNumber = GenerateAccountNumber.generateAccountNumber();
    Account account = new Account();
    account.setAccountType(accountType);
    account.setAccountNumber(userAccountNumber);
    account.setOwner(user);
    account.setAccountBalance(0.00);
    accountDao.saveAccount(account);
    return account;
  }

  /**
   * Delete account.
   *
   * @param accountNumber the account number
   * @throws UserAccountNotFoundException the user account not found exception
   */
  public void deleteAccount(long accountNumber) throws UserAccountNotFoundException{
    AccountDaoImpl accountDao = new AccountDaoImpl();
    Account account = accountDao.getAccountDetails(accountNumber);
    accountDao.removeAccount(account);
  }
  
  /**
   * Update account.
   *
   * @param accountNumber the account number
   * @param account the account
   * @throws UserAccountNotFoundException the user account not found exception
   */
  public void updateAccount(long accountNumber, Account account)
      throws UserAccountNotFoundException {
    AccountDaoImpl accountDao = new AccountDaoImpl();
    accountDao.updateAccount(accountNumber,account);
  }
  
  /**
   * Gets the account details.
   *
   * @param accountNumber the account number
   * @return the account details
   * @throws UserAccountNotFoundException the user account not found exception
   */
  public Account getAccountDetails(long accountNumber) throws UserAccountNotFoundException {
       AccountDaoImpl accountDao = new AccountDaoImpl();
       return accountDao.getAccountDetails(accountNumber);
  }

}
