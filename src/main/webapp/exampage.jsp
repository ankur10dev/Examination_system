<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"
	integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/3f5992c71f.js"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css" />

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<style type="text/css">
.time {
	margin: 10px;
	line-height: 2em;
	background-color: red;
	color: white;
	font-size: 20px;
	text-align: center;
	border-radius: 5px;
	line-height: 2em;
	padding: 5px;
}

</style>
</head>
<body>

	

	<c:choose>
		<c:when test="${not empty username}">
			<%-- <%@include file="top_menu.jsp"%>--%>
			<!-- <div class="float-right time">
				Time left = <span id="timer"></span>
			</div> -->
			<c:choose>
				<c:when test="${not empty question}">



					<div class="container mt-5">

						<div class="row" id="result_div" style="display: none;">
							<div class="col-4"></div>
							<div class="col-4">
								<div class="card">
									<div class="card-header text-center">
										PLEASE PROVIDE US A FEEDBACK <span
											class="material-symbols-outlined mt-1">
											sentiment_satisfied </span>
									</div>
									<div class="card-body">
										<form action="feedback" method="get">

											<label for="name" class="form-label">Please Enter
												Your Name</label> <input type="text" class="form-control"
												name="userName" placeholder="@John"> 
											
											<div >
												<textarea style="height: 176px;" name="feedbacktext" cols="40"
													 class="form-contol mt-2" placeholder="Describe your experience.."></textarea>
											</div>
											
											<button class="btn btn-success mt-2" type="submit">Submit</button>
										</form>
										
										<a href="/resultPage" class="btn btn-primary mt-3">View Result</a>
									</div>
								</div>

							</div>
						</div>







						<div id="quest_div">
							<!-- action="./getNextQuestion" -->
							<form class="form-group" method="post">
								<!-- onsubmit="getNextQuest()" -->
								<div class="d-flex justify-content-center align-items-center"
									style="display: flex; justify-content: center; align-items: center; height: 70vh; width: 85vw;">

									<div class="exam w-75 p-2"
										style="box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;">
										<h3 class="border w-100 " style="padding: 2rem 2.3rem;">
											<p class="text-secondary"
												style="font-size: 20px; line-height: 35px" id="question">
												<span class="text-primary"
													style="font-weight: bolder; padding-right: 20px; font-size: 1.5rem;">Question:-</span>${question.getQuestion()}
											</p>
											<div class="" style="margin: 1rem 2rem;">
												<div
													class="form-check form-check d-flex align-items-center  mb-2">
													<input class="form-check-input" type="radio"
														name="flexRadioDefault" id="flexRadioDefault1"
														value="${question.getOption1()}"> <label
														class="form-check-label" id="opt1" for="flexRadioDefault1">
														${question.getOption1()} </label>
												</div>
												<div
													class="form-check form-check d-flex align-items-center mb-2">
													<input value="${question.getOption2()}"
														class="form-check-input" type="radio"
														name="flexRadioDefault" id="flexRadioDefault2"> <label
														class="form-check-label" id="opt2"
														for="flexRadioDefault2 "> ${question.getOption2()}
													</label>
												</div>
												<div
													class="form-check form-check d-flex align-items-center  mb-1">
													<input value="${question.getOption3()}"
														class="form-check-input" type="radio"
														name="flexRadioDefault" id="flexRadioDefault3"> <label
														class="form-check-label" id="opt3" for="flexRadioDefault3">
														${question.getOption3()} </label>
												</div>
												<div
													class="form-check form-check d-flex align-items-center  mb-1">
													<input value="${question.getOption4()}"
														class="form-check-input" type="radio"
														name="flexRadioDefault" id="flexRadioDefault4"> <label
														class="form-check-label" id="opt4" for="flexRadioDefault4">
														${question.getOption4()} </label>
												</div>
												<div style="margin-top: 1rem; text-align: end;">
													<input id="nextBtn" onclick="getNextQuest()" type="button"
														value="Next" class="btn btn-success fs-5 fw-bolder"
														id="btn" style="border-bottom: 2px solid;">
												</div>
											</div>
										</h3>
									</div>

								</div>
							</form>
						</div>
					</div>

				</c:when>
				<c:otherwise>
					<%-- <c:if test="${not empty msg}">
						<div class="d-flex align-items-center justify-content-center"
							style="height: 550px;">
							<div class="p-2 m-2">
								<p class="alert alert-danger">${msg}</p>
								<c:remove var="msg" scope="session" />
							</div>

						</div>


					</c:if> --%>
				</c:otherwise>
			</c:choose>

		</c:when>
		<c:otherwise>
			<%="Your Session Exprired, plz <a href='http://localhost:9080/examapplication/'>login</a>"%>
		</c:otherwise>
	</c:choose>

	<div>
		<c:if test="${not empty msg}">
			 <%-- <p class="alert alert-success">${msg}</p>  --%>
			 <script type="text/javascript">
				swal({
  						title: "Good job!",
 					 text: "FeedBack registerd",
 					 icon: "success",
					}).then(function() {
						/* $('#result_div').show(); */
					    window.location = "http://localhost:8080/examapplication/userViewResultPage.jsp"; 
					});
				
				</script> 
				<c:remove var="msg" scope="session" />
		</c:if>
	</div>

</body>
<script>
	function getNextQuest() {

		var selectedVal = "";
		var selected = $("input[name='flexRadioDefault']:checked").val();
		if (selected.length > 0) {
			selectedVal = selected;
		}

		/*alert(selectedVal);*/
		$.ajax({
			url : "./startexam",
			type : "POST",

			data : {
				flexRadioDefault : selectedVal

			},
			success : function(result) {
				/*alert(result);*/
				console.log(result);
				if (result == 'END') {
					$('#quest_div').hide();
					$('#result_div').show();

				} else {
					/* alert(result); */

					var obj = JSON.parse(result);
					/*  alert(obj.question);  */
					$("#question").text(obj.question);
					$("#opt1").text(obj.option1);
					$("#flexRadioDefault1").val(obj.option1);
					$("#opt2").text(obj.option2);
					$("#flexRadioDefault2").val(obj.option2);
					$("#opt3").text(obj.opt3);
					$("#flexRadioDefault3").val(obj.option3);
					$("#opt4").text(obj.option4);
					$("#flexRadioDefault4").val(obj.option4);
					$("input:radio").removeAttr("checked");

				}

			},
			//If there was no response from the server
			error : function(jqXHR, textStatus, errorThrown) {
				alert(error);
			}
		});

	}

	/* document.getElementById('timer').innerHTML =
	 00 + ":" + 10;
	 startTimer();


	 function startTimer() {
	 var presentTime = document.getElementById('timer').innerHTML;
	 var timeArray = presentTime.split(/[:]+/);
	 var m = timeArray[0];
	 var s = checkSecond((timeArray[1] - 1));
	 if(s==59){m=m-1}
	 if(m<0){
	 return
	 }
	
	 document.getElementById('timer').innerHTML =
	 m + ":" + s;
	 console.log(m)
	 setTimeout(startTimer, 1000);
	 var time = $('#timer').val();
	 console.log(time);
	
	 }

	 function checkSecond(sec) {
	 if (sec < 10 && sec >= 0) {sec = "0" + sec}; // add zero in front of numbers < 10
	 if (sec < 0) {sec = "59"};
	 return sec;
	 } */
	/* $(document).ready(function() {
	 $('#btn').click(function() {
	 alert("Hello");
	 var selectedVal = "";
	 var selected = $("input[type='radio'][name='flexRadioDefault']:checked");
	 if (selected.length > 0) {
	 selectedVal = selected.val();
	 }
	 alert(selectedVal)
	
	
	 $('#flexRadioDefault1').text('Dolly Duck');	

	 });
	 }); */
</script>
</html>
