/**
 * 
 */
package com.epam.rd.dao;

import com.epam.rd.enums.AccountType;
import com.epam.rd.exceptions.UserAccountNotFoundException;
import com.epam.rd.model.Account;
import com.epam.rd.model.Users;

/**
 * The Interface AccountDao.
 *
 * @author Avinash_Kamat
 */
public interface AccountDao {

  /**
   * Creates the account.
   *
   * @param user    the user
   * @param savings the savings
   * @param account the account
   */
  long createAccount(Users user, AccountType savings);

  /**
   * Delete account.
   *
   * @param accountNumber the account number
   * @return true, if successful
   * @throws UserAccountNotFoundException the user account not found exception
   */
  boolean deleteAccount(long accountNumber) throws UserAccountNotFoundException;

  /**
   * Update account.
   *
   * @param accountNumber the account number
   * @param account       the account
   * @throws UserAccountNotFoundException the user account not found exception
   */
  void updateAccount(long accountNumber, Account account) throws UserAccountNotFoundException;

  /**
   * Gets the account details.
   *
   * @param accountNumber the account number
   * @return the account details
   * @throws UserAccountNotFoundException the user account not found exception
   */
  Account getAccountDetails(long accountNumber) throws UserAccountNotFoundException;

}
