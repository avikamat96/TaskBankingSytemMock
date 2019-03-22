package com.epam.exceptions;

/**
 * The Class UserAccountNotFoundException.
 *
 * @author Avinash_Kamat
 */
public class UserAccountNotFoundException extends Exception {

  /**
   * Instantiates a new user account not found exception.
   *
   * @param message the message
   */
  public UserAccountNotFoundException(String message) {
    super(message);
  }

}
