<%@page import="com.exam.util.dbConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Students</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
	
	
	
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">

<style type="text/css">
body {
	margin: 10px;
	background-image: url("adminpageimage.jpg");
	background-repeat: no-repeat;
	background-size: 1600px 1000px;
}
.rad {
	border-radius: 7px;
}
table {
	width: 50%;
}
</style>
</head>
<body>

	<div class="row">
		<div class="col-4">
			<div class="d-flex flex-column flex-shrink-0 p-3 text-bg-dark rad"
				style="width: 280px; height: 590px">
				<a href="/"
					class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
					<svg class="bi pe-none me-2" width="40" height="32">
                <use xlink:href="#bootstrap"></use>
            </svg> <span class="fs-4">Admin Functions</span>
				</a>

				<!-- active -->
				<hr>
				<ul class="nav nav-pills flex-column mb-auto list-group">



					
					<a href="showstudents.jsp"
						class="list-group-item list-group-item-action mt-3 list-group-item-success text-center"
						aria-current="page"> Registered Students </a>

					<a href="addsubject.jsp"
						class="list-group-item list-group-item-action mt-2 list-group-item-success text-center">
						Add Subjects </a>
					<a href="showsubjects.jsp"
						class="list-group-item list-group-item-action mt-2 list-group-item-success text-center">
						Show Subject </a>
					<a href="addquestions.html" class="list-group-item  text-center list-group-item-action mt-2 list-group-item-success">
							 Add Questions
					</a>
					<a href="showquestions.jsp" class="list-group-item  text-center list-group-item-action mt-2 list-group-item-success">
							 View Questions
					</a>
					<a href="adminShowResults.jsp" class="list-group-item  text-center list-group-item-action mt-2 list-group-item-success">
							 View Scores
					</a>
					<a href="feedbackpage.jsp" class="list-group-item  text-center list-group-item-action mt-2 list-group-item-success">
							 View Feedbacks
					</a>
					
					
					

				
				</ul>
				<hr>
			</div>

		</div>

		<div class="col-8">



			<nav class="navbar navbar-expand-sm bg-dark"
				style="margin-left: -9em;">
				<div class="container">
					<a class="navbar-brand text-dark" href="#"> <i
						class="text-warning font-weight-bold  lead">Welcome : </i><i
						class="text-white">${username}</i>
					</a>
					<ul class="navbar-nav">
						<li class="nav-item"><a
							class="nav-link text-dark btn btn-primary" href="logout">LogOut</a></li>
					</ul>
				</div>
			</nav>
			
			
			<!--Table-->
			
			<h1 class="text-white ml-5">View Results</h1>
			
			<div class="row">
			
				<div class="col-8">
				
						<%
Connection con = dbConnection.getConnection();
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from tbl_results"); %>
<table class="table table-striped table-dark  table-hover">
<thead class="text-center font-italic thead-dark" style="font-size:1.2em">
<th>Student ID</th>
<th>Name</th>
<th>Marks</th>
</thead >
<tbody class="text-center ">
<%while(rs.next()){
%>
<tr>
<td><%=rs.getInt(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
</tr>
<%} %>
</tbody>
</table>
				
				
				</div>
			
			</div>
			
			
			
				
	
	<!--Table End  -->

		</div>

	</div>



</body>
</html>