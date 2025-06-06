<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
	function validations() {
		
		var email = document.getElementById("useremail").value;		
		var password = document.getElementById("userpassword").value;
		
		if(email === ""){
			alert("Please enter your email");
			return false;
		}
		else if(password === ""){
			alert("Please enter your password");
			return false;
		}
		return true;		
	}
	
	function submitForm(){
		if(validations()){
			document.getElementById("loginForm").submit();
		}	
	}
</script>

</head>
<body>
	<%@include file="Header.jsp"%>
	<hr>
	<h1>User Login</h1>
	<hr>
	<form id="loginForm" action="./UserAuthentication" method="post">

		Email:<input type="email" id="useremail" name="useremail"> <br>

		Password:<input type="password" id="userpassword" name="userpassword">
		<br>

		<button type="button" onclick="submitForm()">Login</button>

	</form>


	<hr>
	<%@include file="Footer.jsp"%>
</body>
</html>