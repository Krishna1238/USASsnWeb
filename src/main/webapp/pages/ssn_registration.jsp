<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
	<center>Enrollment For SSN(Social Security Number)</center>
</title>

<!-- Implementing Date picker using Jquery -->

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			maxDate : new Date()
		});
	});
</script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js">
	
</script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js">
	
</script>




<style>
.error {
	color: red;
	font-style: italic;
}
</style>
<h1>
	<center>
		<font color="green">Enrolllment For SSN(Social Security Number)</font>
	</center>
</h1>

</head>
<body bgcolor="red">

	<h1>
		<center>${generatedSsn}</center>
	</h1>

	<form:form id="ssnreg" action="submitSsnForm" method="POST"
		modelAttribute="ssnModelAttribute" enctype="multipart/form-data">

		<table>
			<tr>
				<th>First Name :</th>
				<td><form:input path="firstName" /> <form:errors
						path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<th>Last Name :</th>
				<td><form:input path="lastName" /> <form:errors path="lastName"
						cssClass="error" /></td>
			</tr>
			<tr>
				<th>Date Of Birth :</th>
				<td><form:input path="dob" id="datepicker" /> <form:errors
						path="dob" cssClass="error" /></td>
			</tr>
			<tr>
				<th>Gender :</th>
				<td><form:radiobuttons path="gender" items="${gender}" /> <form:errors
						path="gender" cssClass="error" /></td>
			</tr>
			<tr>
				<th>Phone Number</th>
				<td><form:input path="phNo" id="mobile" /> <!--  --> <form:errors
						path="phNo" cssClass="error" /></td>

			</tr>


			<tr>
				<th>Select State :</th>
				<td><form:select path="state" id="state" items="${stateList}" />
					<form:errors path="state" cssClass="error" /></td>
			</tr>

			<tr>
				<th>Select Photo:</th>
				<td><form:label path="image" /> <input type="file" name="image">
					<form:errors path="image" cssClass="error" /></td>
			</tr>
		</table>
		<input type="reset" value="RESET">
		<input type="submit" value="SUBMIT">
	</form:form>
	<br>
	<br>
	<a href="viewAllSsn">View All SSN </a>

	<script type="text/javascript" src="jquery/ssn.js"></script>

</body>
</html>