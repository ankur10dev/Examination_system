<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.exam.util.dbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
<style type="text/css">
body {
	margin: 20px;
}

.usercontainer {
	border: 2px solid red;
	padding: 10px;
	width: 500px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark">
		<div class="container">
			<a class="navbar-brand text-dark" href="#">
			<i class="text-danger font-weight-bold  lead">Welcome : </i><i class="text-white">${username}</i> </a>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link text-dark btn btn-primary"
					href="logout">LogOut</a></li>
			</ul>
		</div>
	</nav>

	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="header">
		<h1 class="text-center font-italic text-secondary">General Instructions</h1>
	</div>
	<div class="ins" style="font-size:1.2em">
		<ul>
			<li class="justify-text-left">Total duration of examination is 10 minutes</li>
			<li>The clock will be set at the server. The countdown timer in
				the top right corner of screen will display the remaining time
				available for you to complete the examination. When the timer
				reaches zero, the examination will end by itself. You will not be
				required to end or submit your examination.</li>
			<li>The Question Palette displayed on the right side of screen
				will show the status of each question using one of the following
				symbols:</li>
		</ul>
	</div>
				
		</div>
	
	</div>
	
	<div class="row mt-3">
		<div class="col-md-4"></div>
		<div class="col-md-3">
			<div>
		<h4 class="text-muted"> Please Select Subject<sup class="text-danger">*</sup></h4>
		
		<%
			Connection con = dbConnection.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from tbl_subjects");
		%>
		<form action="startexam" method="get">


			<select id="" class="form-control" name="selectedsubject">
				<%
					while (rs.next()) {
				%>
				<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
				<%
					}
				%>
			</select> 
			
			<button class="btn btn-danger text-center ml-5 mt-3" type="submit" value="Start Exam">Start Exam</button>
			 
		</form>
	</div>
			
		
		</div>
	</div>
	
	
</body>
</html>