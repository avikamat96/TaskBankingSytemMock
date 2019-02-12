/**
 * Class to test create account functionality of BankApp
 * 
 */
package com.epam.rd.banktest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.epam.rd.banktest.mock.AccountDaoMockImpl;
import com.epam.rd.enums.AccountType;
import com.epam.rd.enums.Gender;
import com.epam.rd.exceptions.UserAccountNotFoundException;
import com.epam.rd.exceptions.UserInformationNotValidException;
import com.epam.rd.model.Account;
import com.epam.rd.model.Users;
import com.epam.rd.services.AccountValidatorService;


/**
 * The Class AccountDaoTest.
 *
 * @author Avinash_Kamat
 */
public class AccountDaoTest {

  private static Users user;
  private static AccountDaoMockImpl accountDao = new AccountDaoMockImpl();
  private static Account account;
  private AccountValidatorService validatorService = new AccountValidatorService();

  /**
   * Should create account when.
   * 
   * @throws UserInformationNotValidException
   */
  @Test
  public void shouldCreateAccountWhenGivenCorrectParameters() throws UserInformationNotValidException {
    user = new Users("Avinash", 22, Gender.MALE);
    if (validatorService.validate(user)) {
      accountDao.createAccount(user, AccountType.SAVINGS);
    }
    Users tempUser = account.getOwner();
    assertEquals("Avinash", tempUser.getName());
  }

  /**
   * Gets the account details test.
   *
   * @return the account details test
   * @throws UserAccountNotFoundException
   * @throws UserInformationNotValidException
   */
  @Test
  public void shouldReturnUserNameWhenGivenAccountNumber() throws UserInformationNotValidException {
    Users tempUser = new Users("Avi", 21, Gender.MALE);
    String expected = "Avi";
    if (validatorService.validate(tempUser)) {
      accountDao.createAccount(tempUser, AccountType.SAVINGS);
    }
    assertEquals(expected, account.getOwner().getName());
  }

  /**
   * Delete account test.
   *
   * @throws UserAccountNotFoundException     the user account not found exception
   * @throws UserInformationNotValidException
   */
  @Test()
  public void shouldDeleteAccountWhenGivenAccountNumber()
      throws UserAccountNotFoundException, UserInformationNotValidException {
    String name = "Avinash Kamat";
    user = new Users("Avinash",22,Gender.MALE);
    if (new AccountValidatorService().validate(user)) {
      accountDao.createAccount(user, AccountType.SAVINGS);
    }
    assertTrue(accountDao.deleteAccount(account.getAccountNumber()));
  }

  /**
   * Update account test.
   * 
   * @throws UserInformationNotValidException
   * @throws UserAccountNotFoundException
   */
  @Test
  public void shouldUpdateUserNameWhenGivenAccountNumber()
      throws UserInformationNotValidException, UserAccountNotFoundException {
    String expected = "Avinash Kamat";
    user = new Users("Avinash",22,Gender.MALE);
    if (new AccountValidatorService().validate(user)) {
      accountDao.createAccount(user, AccountType.SAVINGS);
    }
    account.getOwner().setName(expected);
    accountDao.updateAccount(account.getAccountNumber(), account);
    assertEquals(expected, account.getOwner().getName());
  }

  /**
   * User account validator service test.
   * 
   * @throws UserInformationNotValidException
   */
  @Test
  public void shouldReturnTrueWhenGivenValidUserDetails() throws UserInformationNotValidException {
    user = new Users("Avinash",22,Gender.MALE);
    AccountValidatorService validatorService = new AccountValidatorService();
    validatorService.validate(user);
  }

  /**
   * User account number generator test.
   *
   * @throws UserInformationNotValidException the user information not valid
   *                                          exception
   */
  @Test
  public void shouldGenerateAccountNumberWhenGivenCorrectParameters() throws UserInformationNotValidException {
    user = new Users("Avinash",22,Gender.MALE);
    if (new AccountValidatorService().validate(user)) {
      accountDao.createAccount(user, AccountType.SAVINGS);
    }
    assertNotNull(account.getAccountNumber());
  }

}
