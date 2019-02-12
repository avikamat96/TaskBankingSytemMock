/**
 * 
 */
package com.epam.rd.banktest.mock;

import com.epam.rd.dao.AccountDao;
import com.epam.rd.dao.TransactionDao;
import com.epam.rd.exceptions.InsufficientBalanceException;
import com.epam.rd.exceptions.UserAccountNotFoundException;
import com.epam.rd.model.Account;

/**
 * The Class TransactionDaoMockImpl.
 *
 * @author Avinash_Kamat
 */
public class TransactionDaoMockImpl implements TransactionDao {

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.rd.dao.TransactionDao#withdrawMoney(long, double)
   */
  @Override
  public void withdrawMoney(long accountNumber, double amount)
      throws UserAccountNotFoundException, InsufficientBalanceException {
    Account account = new Account();
    AccountDao accountDao = new AccountDaoMockImpl();
    account = accountDao.getAccountDetails(accountNumber);
    Double getCurrentBalance = account.getAccountBalance();
    if (getCurrentBalance - amount >= 0) {
      account.setAccountBalance(getCurrentBalance - amount);
    } else {
      throw new InsufficientBalanceException("Insufficient balance");
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.rd.dao.TransactionDao#depositMoney(long, double)
   */
  @Override
  public void depositMoney(long accountNumber, double amount) throws UserAccountNotFoundException {
    Account account = new Account();
    AccountDao accountDao = new AccountDaoMockImpl();
    account = accountDao.getAccountDetails(accountNumber);
    account.setAccountBalance(account.getAccountBalance() + amount);
  }

}
