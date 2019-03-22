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
	<%
	  Account account = (Account) session.getAttribute("update_account");
	%>

	<form class="form-vertical" role="form" action="UpdateAccount"
		method="post">

		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name</label>

			<div class="col-sm-10">
				<input type="text" class="form-control" id="name"
					value="<%=account.getOwner().getName()%>" placeholder="Name"
					name="updatedUserName" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="age" class="col-sm-2 control-label">Age</label>

			<div class="col-sm-10">
				<input type="number" class="form-control" id="age"
					value="<%=account.getOwner().getAge()%>" placeholder="Age"
					name="updatedUserAge" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="gender" class="col-sm-2 control-label">Gender</label>
			<div class="col-sm-10">
				<input type=text class="form-control" id="gender"
					value=<%=account.getOwner().getGender()%> placeholder="Gender"
					readonly="readonly"><input type="hidden"
					value=<%=account.getOwner().getGender()%> name="updatedUserGender">
			</div>
		</div>
		<div class="form-group">
			<label for="accountType" class="col-sm-2 control-label">Account Type</label>
			<div class="col-sm-10">
				<input type=text class="form-control" id="accountType"
					value=<%=account.getAccountType()%> readonly="readonly"> <input
					type="hidden" value=<%=account.getAccountType()%>
					name="updatedUserAccountType">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-10">
				<input type="hidden" class="form-control" id="accountNumber"
					value=<%=account.getAccountNumber()%> disabled="disabled"> <input
					type="hidden" value=<%=account.getAccountNumber()%>
					name="updatedUserAccountNumber">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</div>
	</form>


	<%-- <form action="UpdateAccount" method="post">
		<div class="form-group">
			<label for="name">Name</label> <input type=text
				value="<%=account.getOwner().getName()%>" name="updatedUserName"  >
		</div>
		<br> <br>
		<div class="form-group">
			<label for="Age">Age</label> <input type=text
				value=<%=account.getOwner().getAge()%> name="updatedUserAge">
		</div>
		<br> <br>
		<div class="form-group">
			<label for="Gender">Gender</label> <input type=text
				value=<%=account.getOwner().getGender()%> name="updatedUserGender">
		</div>
		<br> <br>
		<div class="form-group">
			<label for="AccountType">Account Type</label> <input type=text
				value=<%=account.getAccountType()%> disabled="disabled"> <input
				type="hidden" value=<%=account.getAccountType()%>
				name="updatedUserAccountType">
		</div>
		<br> <br>
		<div class="form-group">
			<label for="AccountNumber">Account Number</label> <input type=text
				value=<%=account.getAccountNumber()%> disabled="disabled"> <input
				type="hidden" value=<%=account.getAccountNumber()%>
				name="updatedUserAccountNumber">
		</div>
		<br> <br> <input type="submit" value="submit">
	</form> --%>
</body>
</html>