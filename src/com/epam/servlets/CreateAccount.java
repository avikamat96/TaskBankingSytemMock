package com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.enums.AccountType;
import com.epam.enums.Gender;
import com.epam.exceptions.UserInformationNotValidException;
import com.epam.models.Account;
import com.epam.models.Users;
import com.epam.services.AccountService;
import com.epam.services.AccountValidatorService;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class CreateAccount.
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new creates the account.
   *
   * @see HttpServlet#HttpServlet()
   */
  public CreateAccount() {
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
    String userName = request.getParameter("userName");
    int userAge = Integer.parseInt(request.getParameter("userAge"));
    Gender userGender = request.getParameter("userGender").toLowerCase().equals("male")
        ? Gender.MALE
        : Gender.FEMALE;
    AccountType accountType = request.getParameter("accountType").toLowerCase().equals("savings")
        ? AccountType.SAVINGS
        : AccountType.CURRENT;
    Users user = new Users(userName, userAge, userGender);
    HttpSession session = request.getSession();
    AccountService accountService = new AccountService();
    AccountValidatorService validatorService = new AccountValidatorService();
    try {
      if (validatorService.validate(user)) {
        Account account = accountService.createAccount(user, accountType);
        session.setAttribute("account", account);
        request.getRequestDispatcher("showProfile.jsp").forward(request, response);
      }
    } catch (UserInformationNotValidException e) {
      response.getWriter().println(e.getMessage());
    }

  }

}
