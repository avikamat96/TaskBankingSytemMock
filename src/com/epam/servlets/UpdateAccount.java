package com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.enums.AccountType;
import com.epam.enums.Gender;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;
import com.epam.models.Users;
import com.epam.services.AccountService;

/**
 * Servlet implementation class UpdateAccount.
 */
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new update account.
   *
   * @see HttpServlet#HttpServlet()
   */
  public UpdateAccount() {
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
    String userName = request.getParameter("updatedUserName");
    int userAge = Integer.parseInt(request.getParameter("updatedUserAge"));
    Gender userGender = Gender.valueOf(request.getParameter("updatedUserGender").toUpperCase());
    AccountType accountType = AccountType
        .valueOf(request.getParameter("updatedUserAccountType").toUpperCase());
    long accountNumber = Long.parseLong(request.getParameter("updatedUserAccountNumber"));
    HttpSession session = request.getSession();
    Users user = new Users(userName, userAge, userGender);
    Account account = new Account();
    account.setOwner(user);
    account.setAccountType(accountType);
    account.setAccountNumber(accountNumber);
    AccountService accountService = new AccountService();
    try {
      accountService.updateAccount(accountNumber, account);
      session.setAttribute("account", account);
      request.getRequestDispatcher("showProfile.jsp").forward(request, response);
    } catch (UserAccountNotFoundException e) {
      response.getWriter().println(e.getMessage());
    }

  }

}
