<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
	String driverName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/employee";

	String userId = "root";
	String password = "root";

	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<tr>
				<td><h3 style="color: rebeccapurple;">Hi Welcome,Successfully Logged In</h3></td>
			</tr>
			
<h2 align="center">
	<font><strong>Retrieve data from database in jsp</strong></font>
</h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>

	</tr>
	<tr bgcolor="#A52A2A">

		<td><b>username</b></td>
		<td><b>Password</b></td>
		<td><b>Name</b></td>

	</tr>
	<%
		try {
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement = connection.createStatement();
			String sql = "SELECT * FROM customer";

			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
	%>
	<tr bgcolor="#DEB887">


		<td><%=resultSet.getString("username")%></td>
		<td><%=resultSet.getString("password")%></td>
		<td><%=resultSet.getString("name")%></td>

	</tr>

	<%
		}

		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
	
</table>
<tr>
				<td><a href="loginMain.jsp"><input type="submit" name="Submit" value="Logout"></a></td>
			</tr>
			
