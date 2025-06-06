<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
	function validations() {
		var name = document.getElementById("username").value;
		var email = document.getElementById("useremail").value;
		var mobile = document.getElementById("usermobile").value;
		var password = document.getElementById("userpassword").value;
		var confirmpassword= document.getElementById("userconfirmpassword").value;
		if(name === ""){
			alert("Please enter your name");
			return false;
		}
		else if(email === ""){
			alert("Please enter your email");
			return false;
		}
		else if(mobile === "" || mobile.length < 10){
			alert("Please enter your mobile");
			return false;
		}
		else if(password === "" || password.length < 8){
			alert("Please enter your password. Must have atleast 8 chars");
			return false;
		}else if(confirmpassword === "" || confirmpassword.length <8){
			alert("Please enter your confirmpassword. Must have atleast 8 chars");
			return false;
		}else if(password !== confirmpassword){
			alert("Password and confirmpassword are not the same");
			return false;
		}
		return true;		
	}
	
	function submitForm(){
		if(validations()){
			document.getElementById("registrationForm").submit();
		}	
	}
</script>

</head>
<body>
	<%@include file="Header.jsp"%>
	<hr>
	<h1>User Registration</h1>
	<hr>
	<form id="registrationForm" action="./UserRegistration" method="post">
		Name: <input type="text" id="username" name="username"> <br>
		Email:<input type="email" id="useremail" name="useremail"> <br>
		Mobile:<input type="tel" id="usermobile" name="usermobile"> <br>
		Password:<input type="password" id="userpassword" name="userpassword">
		<br> Confirm Password:<input type="password"
			id="userconfirmpassword">

		<button type="button" onclick="submitForm()">Register</button>

	</form>

	<hr>
	<%@include file="Footer.jsp"%>
</body>
</html>