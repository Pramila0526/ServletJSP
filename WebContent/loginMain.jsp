<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginRegistration" method="post">
		<table
			style="border=1; background-color: DarkSalmon; width=400; align=center">
			<tr>
			<td></td>
			</tr>
			<tr>
				<td><h3 style="color: darkslategray;">Welcome To Login Page!!</h3></td>
			</tr>
			<tr>
				<td><h3 style="color: darkslategray;">${successMessage}</h3></td>
			</tr>
			
			<tr>
				<td><h3 style="color: darkslategray;">${message}</h3></td>
			</tr>
			
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username">
				</td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" name="Submit" value="Login"></td>
				<td><a href="registeration.jsp">Registration</a></td>
			</tr>
			
		</table>
	</form>
</body>
</html>