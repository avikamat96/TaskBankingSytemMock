/**
 * 
 */
package com.epam.rd.dao;

import com.epam.rd.exceptions.InsufficientBalanceException;
import com.epam.rd.exceptions.UserAccountNotFoundException;

/**
 * The Interface TransactionDao.
 *
 * @author Avinash_Kamat
 */
public interface TransactionDao {

    /**
     * Withdraw money.
     *
     * @param accountNumber the account number
     * @param amount        the amount
     * @throws UserAccountNotFoundException the user account not found exception
     * @throws InsufficientBalanceException the insufficient balance exception
     */
    void withdrawMoney(long accountNumber, double amount)
	    throws UserAccountNotFoundException, InsufficientBalanceException;

    /**
     * Deposit money.
     *
     * @param accountNumber the account number
     * @param amount        the amount
     * @throws UserAccountNotFoundException the user account not found exception
     */
    void depositMoney(long accountNumber, double amount) throws UserAccountNotFoundException;
}
