/**
 * 
 */
package com.epam.rd.banktest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.epam.rd.banktest.mock.AccountDaoMockImpl;
import com.epam.rd.banktest.mock.TransactionDaoMockImpl;
import com.epam.rd.dao.AccountDao;
import com.epam.rd.enums.AccountType;
import com.epam.rd.enums.Gender;
import com.epam.rd.exceptions.InsufficientBalanceException;
import com.epam.rd.exceptions.UserAccountNotFoundException;
import com.epam.rd.exceptions.UserInformationNotValidException;
import com.epam.rd.model.Account;
import com.epam.rd.model.Users;
import com.epam.rd.services.AccountValidatorService;

/**
 * @author Avinash_Kamat
 *
 */
class TransactionDaoTest {

  @Test
  public void shouldDepositMoneyWhenGivenAccountNumber() throws UserInformationNotValidException, UserAccountNotFoundException {
    Account tempAccount = new Account();
    AccountDaoMockImpl accountDao = new AccountDaoMockImpl();
    double amount = 50000.00;
    double expected = 50100.00;
    long accountNumber = 0;
    Users tempUser = new Users("Avinash", 22, Gender.MALE);
    if (new AccountValidatorService().validate(tempUser)) {
      accountNumber = accountDao.createAccount(tempUser, AccountType.SAVINGS);
    }
    tempAccount = accountDao.getAccountDetails(accountNumber); 
    tempAccount.setAccountBalance(100.00);
    TransactionDaoMockImpl transactionDao = new TransactionDaoMockImpl();
    transactionDao.depositMoney(tempAccount.getAccountNumber(), amount);
    assertEquals(expected, tempAccount.getAccountBalance());
  }

  @Test
  public void shouldWithdrawMoneyWhenGivenAccountNumber()
      throws UserInformationNotValidException, InsufficientBalanceException, UserAccountNotFoundException {
    Account tempAccount = new Account();
    long accountNumber = 0;
    AccountDaoMockImpl accountDao = new AccountDaoMockImpl();
    double amount = 50000.00;
    double expected = 100.00;
    Users tempUser = new Users("Avinash", 22, Gender.MALE);

    if (new AccountValidatorService().validate(tempUser)) {
      accountNumber = accountDao.createAccount(tempUser, AccountType.SAVINGS);
    }
    tempAccount = accountDao.getAccountDetails(accountNumber);
    tempAccount.setAccountBalance(50100.00);
    TransactionDaoMockImpl transactionDao = new TransactionDaoMockImpl();
    transactionDao.withdrawMoney(tempAccount.getAccountNumber(), amount);
    assertEquals(expected, tempAccount.getAccountBalance());
  }

}
