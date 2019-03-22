package com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.dao.AccountDaoImpl;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.services.AccountService;

/**
 * Servlet implementation class DeleteAccount.
 */
@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new delete account.
   *
   * @see HttpServlet#HttpServlet()
   */
  public DeleteAccount() {
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
    try {
      long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
      AccountService accountService = new AccountService();
      accountService.deleteAccount(accountNumber);
      request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    } catch (UserAccountNotFoundException e) {
      response.getWriter().println(e.getMessage());
    }

  }

}
