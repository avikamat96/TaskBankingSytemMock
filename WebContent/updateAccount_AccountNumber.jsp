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
	<form class="form-vertical" role="form"
		action="UpdateAccountGetAccountNumber" method="post">

		<div class="form-group">
			<label for="accountNumber" class="col-sm-2 control-label">Enter
				Account Number</label>

			<div class="col-sm-10">
				<input type="number" class="form-control" id="accountNumber"
					placeholder="Enter Acccount Number" name="accountNumber" required="required">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</div>
	</form>
</body>
</html>