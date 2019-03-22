/**
 * 
 */
package com.epam.dao;

import java.util.ArrayList;
import java.util.List;

import com.epam.enums.AccountType;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;
import com.epam.models.Users;
import com.epam.services.GenerateAccountNumber;

/**
 * The Class AccountDaoImpl.
 *
 * @author Avinash_Kamat
 */
public class AccountDaoImpl implements AccountDao {

  /** The account list. */
  private static List<Account> accountList = new ArrayList<Account>();

  /* (non-Javadoc)
   * @see com.epam.dao.AccountDao#saveAccount(com.epam.models.Account)
   */
  @Override
  public void saveAccount(Account account) {
    accountList.add(account);
  }

  /* (non-Javadoc)
   * @see com.epam.dao.AccountDao#removeAccount(com.epam.models.Account)
   */
  @Override
  public void removeAccount(Account account) throws UserAccountNotFoundException {
    account.setAccountType(AccountType.DISABLED);
  }

  /* (non-Javadoc)
   * @see com.epam.dao.AccountDao#updateAccount(long, com.epam.models.Account)
   */
  @Override
  public void updateAccount(long accountNumber, Account account)
      throws UserAccountNotFoundException {
    for (Account tempAccount : accountList) {
      if (tempAccount.getAccountNumber() == accountNumber) {
        accountList.remove(tempAccount);
        accountList.add(account);
        return;
      }
    }
    throw new UserAccountNotFoundException("Account number does not exist");
  }

  /* (non-Javadoc)
   * @see com.epam.dao.AccountDao#getAccountDetails(long)
   */
  @Override
  public Account getAccountDetails(long accountNumber) throws UserAccountNotFoundException {
    for (Account account : accountList) {
      if (account.getAccountNumber() == (accountNumber)) {
        return account;
      }
    }
    throw new UserAccountNotFoundException("Account number does not exist");

  }

  /* (non-Javadoc)
   * @see com.epam.dao.AccountDao#getAllAccounts()
   */
  @Override
  public List<Account> getAllAccounts() {
    return accountList;
  }

}
