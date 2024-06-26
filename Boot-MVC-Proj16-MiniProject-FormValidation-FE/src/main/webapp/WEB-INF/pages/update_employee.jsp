<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color: red; text-align: center;">Update Employee</h1>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script language="javaScript" src="js/validation.js"></script>
<frm:form modelAttribute="emp" onsubmit="return doValidation(this)">
	<p style="color: red; align-content: center;">
		<frm:errors path="*" />
	</p>
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Employee Number</td>
			<td><frm:input path="eid" readonly="true" /></td>
		</tr>
		<tr>
			<td>Employee Name</td>
			<td><frm:input path="name"/><span id="nameErr"></span></td>
		</tr>
		<tr>
			<td>Employee Designation</td>
			<td><frm:input path="job" /><span id="jobErr"></span></td>
		</tr>
		<tr>
			<td>Employee Department</td>
			<td><frm:input path="dept"/><span id="deptErr"></span></td>
		</tr>
		<tr>
			<td>Employee Adderess</td>
			<td><frm:input path="addrs" /></td>
		</tr>
		<tr>
			<td>Employee Salary</td>
			<td><frm:input path="salary" /><span id="salErr"></span></td>
		</tr>
		<tr>
			<td><input type="submit" value="Update"></td>
			<td><input type="reset" value="cancel"></td>
		</tr>
	</table>


</frm:form>
