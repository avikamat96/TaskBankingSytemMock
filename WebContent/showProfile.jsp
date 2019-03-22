<%@page import="com.epam.models.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<%
	  if (session.getAttribute("isUserLoggedIn") == null) {
	    request.getRequestDispatcher("login.jsp").forward(request, response);
	  }
	  Account account = (Account) session.getAttribute("account");
	%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="dashboard.jsp">BANK</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="createAccount.jsp">Create Account</a></li>
				<li><a href="updateAccount_AccountNumber.jsp">Update
						Account</a></li>
				<li><a href="accountDetails_accountNumber.jsp">View Account</a></li>
				<li><a href="listAllAccounts.jsp">View All Account</a></li>
				<li><a href="deleteAccount_AccountNumber.jsp">Delete
						Account</a></li>
				<li><a href="depositMoney.jsp">Deposit </a></li>
				<li><a href="withdrawMoney.jsp">Withdrawal</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Logout"><strong>Logout</strong></a></li>
			</ul>

		</div>
		</div>
	</nav>
	<table class="table table-bordered">
		<tr>
			<th>Name</th>
			<td><%=account.getOwner().getName()%></td>
		</tr>
		<tr>
			<th>Age</th>
			<td><%=account.getOwner().getAge()%></td>
		</tr>
		<tr>
			<th>Gender</th>
			<td><%=account.getOwner().getGender()%></td>
		</tr>
		<tr>
			<th>Account Type</th>
			<td><%=account.getAccountType()%></td>
		</tr>
		<tr>
			<th>Account Number</th>
			<td><%=account.getAccountNumber()%></td>
		</tr>
		<tr>
			<th>Account Balance</th>
			<td><%=account.getAccountBalance()%></td>
		</tr>
	</table>
	<form class="form-vertical" role="form" action="dashboard.jsp" method="post" >
    <div class="form-group" align="center">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">OK</button>
			</div>
		</div>

	</form>
</body>
</html>