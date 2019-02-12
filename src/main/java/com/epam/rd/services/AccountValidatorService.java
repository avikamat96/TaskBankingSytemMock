package com.epam.rd.services;

import com.epam.rd.exceptions.UserInformationNotValidException;
import com.epam.rd.model.Users;

/**
 * The Class AccountValidatorService.
 *
 * @author Avinash_Kamat
 */
public class AccountValidatorService {

  /**
   * Validate.
   *
   * @param user the user
   * @return true, if successful
   * @throws UserInformationNotValidException the user information not valid
   *                                          exception
   */
  public boolean validate(Users user) throws UserInformationNotValidException {
    boolean isInformationValid = true;
    if (user.getName().isEmpty() || user.getAge() < 15) {
      throw new UserInformationNotValidException("User information is not valid");
    }
    return isInformationValid;
  }

}
