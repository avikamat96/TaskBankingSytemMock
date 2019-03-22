package com.epam.services;

/**
 * The Class GenerateAccountNumber.
 *
 * @author Avinash_Kamat
 */
public class GenerateAccountNumber {

  private static final long USER_ACCOUNT_NUMBER = 1L;

  private static long tempUserAccountNumber = USER_ACCOUNT_NUMBER;

  /**
   * Instantiates a new generate account number.
   */
  private GenerateAccountNumber() {

  }

  /**
   * Generate account number.
   *
   * @return the long
   */
  public static long generateAccountNumber() {
    tempUserAccountNumber++;
    return tempUserAccountNumber;
  }

}
