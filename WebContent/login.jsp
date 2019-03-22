<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script  src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	 integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	 crossorigin="anonymous"></script>

<style type="text/css">
@import "bourbon";

body {
	background: #eee !important;
}

.wrapper {
	margin-top: 100px;
	margin-bottom: 100px;
}

.form-signin {
	max-width: 400px;
	padding: 15px 35px 45px;
	margin: 0 auto;
	background-color: #fff;
	border: 1px solid rgba(0, 0, 0, 0.1);
	.
	form-signin-heading
	,
	.checkbox
	{
	margin-bottom
	:
	30px;
}

.form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	@
	include
	box-sizing(border-box);
	&:
	focus
	{
	z-index
	:
	2;
}

}
input[type="text"] {
	margin-bottom: -1px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

input[type="password"] {
	margin-bottom: 20px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
#submitButton{
margin-top: 50px;
}
}
</style>
</head>
<body>
	<div class="wrapper">
		<form class="form-signin" method="post" action="Login">
			<h2 class="form-signin-heading">Welcome to Bank</h2>
			<input type="text" class="form-control" name="Employee id"
				placeholder="Employee ID" required="required" autofocus="" /> <input
				type="password" class="form-control" name="Account Password"
				placeholder="Password" required="required" />
			<button id="submitButton" class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		</form>
	</div>
</body>
</html>