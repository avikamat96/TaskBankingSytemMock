package com.epam.rd.banktest.mock;

import java.util.ArrayList;
import java.util.List;

import com.epam.rd.dao.AccountDao;
import com.epam.rd.enums.AccountType;
import com.epam.rd.exceptions.UserAccountNotFoundException;
import com.epam.rd.model.Account;
import com.epam.rd.model.Users;
import com.epam.rd.services.AccountValidatorService;
import com.epam.rd.services.GenerateAccountNumber;

/**
 * The Class AccountDaoMockImpl.
 *
 * @author Avinash_Kamat
 */
public class AccountDaoMockImpl implements AccountDao {

  private static List<Account> accountList = new ArrayList<Account>();

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.rd.dao.AccountDao#createAccount(com.epam.rd.model.Users,
   * com.epam.rd.enums.AccountType, com.epam.rd.model.Account)
   */
  @Override
  public long createAccount(Users user, AccountType accountType) {
    Account account=new Account();
    long userAccountNumber = GenerateAccountNumber.generateAccountNumber();
    account.setAccountType(accountType);
    account.setAccountNumber(userAccountNumber);
    account.setOwner(user);
    accountList.add(account);
    return account.getAccountNumber();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.rd.dao.AccountDao#deleteAccount(long)
   */
  @Override
  public boolean deleteAccount(long accountNumber) throws UserAccountNotFoundException {
    for (Account account : accountList) {
      if (account.getAccountNumber() == (accountNumber)) {
        accountList.remove(account);
        return true;
      }
    }
    throw new UserAccountNotFoundException("Account number does not exist");
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.rd.dao.AccountDao#updateAccount(long,
   * com.epam.rd.model.Account)
   */
  @Override
  public void updateAccount(long accountNumber, Account account) throws UserAccountNotFoundException {
    for (Account tempAccount : accountList) {
      if (tempAccount.getAccountNumber() == accountNumber) {
        accountList.remove(tempAccount);
        accountList.add(account);
        return;
      }
    }
    throw new UserAccountNotFoundException("Account number does not exist");
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.rd.dao.AccountDao#getAccountDetails(long)
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
}
