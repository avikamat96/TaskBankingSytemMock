package com.epam.rd.services;

/**
 * The Class GenerateAccountNumber.
 *
 * @author Avinash_Kamat
 */
public class GenerateAccountNumber {

  private static final long USER_ACCOUNT_NUMBER = 10000000L;
  
  private static long tempUserAccountNumber = USER_ACCOUNT_NUMBER;
  
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
