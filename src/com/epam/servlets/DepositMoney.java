package com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.enums.AccountType;
import com.epam.exceptions.InvalidAccountAccessException;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;
import com.epam.services.AccountService;
import com.epam.services.TransactionService;

/**
 * Servlet implementation class DepositMoney.
 */
@WebServlet("/DepositMoney")
public class DepositMoney extends HttpServlet {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new deposit money.
   *
   * @see HttpServlet#HttpServlet()
   */
  public DepositMoney() {
    super();
  }

  /* (non-Javadoc)
   * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.getWriter().println("Invalid Access");
  }

  /**
   * Do post.
   *
   * @param request the request
   * @param response the response
   * @throws ServletException the servlet exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    TransactionService transactionService = new TransactionService();
    AccountService accountService = new AccountService();
    HttpSession session = request.getSession();
    long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
    try {
      Account account = accountService.getAccountDetails(accountNumber);
      if (account.getAccountType() != AccountType.DISABLED) {
        account = transactionService.depositMoney(accountNumber,
            Math.abs(Double.parseDouble(request.getParameter("depositAmount"))));
        session.setAttribute("view_account", account);
        request.getRequestDispatcher("showProfile.jsp").forward(request, response);
      } else {
        throw new InvalidAccountAccessException("Account is disabled. Cannot deposit money");
      }
    } catch (UserAccountNotFoundException e) {
      response.getWriter().println(e.getMessage());
    } catch (InvalidAccountAccessException e) {
      response.getWriter().println(e.getMessage());
    }
  }

}
