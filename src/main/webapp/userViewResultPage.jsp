<%@page import="com.exam.util.dbConnection"%>
<%@page import="com.exam.dao.GetUserDetailsDao"%>
<%@page import="com.exam.bean.RegisterBean"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Students</title>
<style type="text/css">
table {
	width: 50%;
}
</style>
</head>
<body>
	<h1>Your Result Is :</h1>
	<%
		Connection con = dbConnection.getConnection();
	GetUserDetailsDao details = new GetUserDetailsDao();
	RegisterBean rb = details.getDetails((String) session.getAttribute("username"));
	Integer Id = rb.getId();
	String FullName = rb.getFullname();
	PreparedStatement pstmt = con.prepareStatement("select * from tbl_results where name = ?");
	pstmt.setString(1, FullName);
	ResultSet rs = pstmt.executeQuery();
	%>
	<table border=1>
		<thead>
			<th>Your Username</th>
			<th>Your Score</th>
		</thead>
		<tbody>
			<%
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getInt(3)%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>