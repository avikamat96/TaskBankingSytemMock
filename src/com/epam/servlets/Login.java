package com.epam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login.
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new login.
   *
   * @see HttpServlet#HttpServlet()
   */
  public Login() {
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
    long accountNumber = Long.parseLong(request.getParameter("Employee id"));
    String password = request.getParameter("Account Password");
    HttpSession session = request.getSession();
    if (accountNumber == 1111 && password.equals("1111")) {
      session.setAttribute("isUserLoggedIn",true);
      RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
      dispatcher.forward(request, response);
    }
    else {
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
  }

}
