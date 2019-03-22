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
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<form class="form-vertical card" role="form" action="CreateAccount"
					method="post">

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name"
								placeholder="Enter Name" name="userName" required="required"><br>
						</div>
					</div>

					<div class="form-group">
						<label for="age" class="col-sm-2 control-label">Age</label>

						<div class="col-sm-10">
							<input type="number" class="form-control" id="age"
								placeholder="Enter Age" name="userAge" required="required"><br>
						</div>
					</div>

					<div class="form-group">
						<label for="gender" class="col-sm-2 control-label">Select
							Gender</label>
						<div class="col-sm-10">
							<select class="form-control" id="gender" name="userGender">
								<option>Male</option>
								<option>Female</option>
							</select> <br>
						</div>
					</div>

					<div class="form-group">
						<label for="accountType" class="col-sm-2 control-label">
							Account Type</label>
						<div class="col-sm-10">
							<select class="form-control" id="accountType" name="accountType">
								<option>Savings</option>
								<option>Current</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<br>
							<button type="submit" class="btn btn-success form-control">Create
								Account</button>
						</div>
					</div>

				</form>
			</div>

		</div>
	</div>
</body>
</html>