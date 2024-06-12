<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: red; text-align: center;">Register Employee</h1>

<frm:form modelAttribute="emp">
<%-- <p style="color: red;align-content: center;">
<frm:errors path="*"/>
</p> --%>
	<table border="1" bgcolor="cyan" align="center">
		<tr>
			<td>Employee Name::</td>
			<td><frm:input path="name" /><frm:errors path="name"/></td>
		</tr>
		<tr>
			<td>Employee Designation</td>
			<td><frm:input path="job" /><frm:errors path="job"/></td>
		</tr>
		<tr>
			<td>Employee Department</td>
			<td><frm:input path="dept" /><frm:errors path="dept"/></td>
		</tr>
		<tr>
			<td>Employee Address</td>
			<td><frm:input path="addrs" /></td>
		</tr>
		<tr>
			<td>Employee Salary</td>
			<td><frm:input path="salary" /><frm:errors path="salary"/></td>
		</tr>
		<tr>
		<td> <input type="submit" value="Register"></td>
		<td>  <input type="reset" value="Cancel"></td>
		</tr>
	</table>

</frm:form>