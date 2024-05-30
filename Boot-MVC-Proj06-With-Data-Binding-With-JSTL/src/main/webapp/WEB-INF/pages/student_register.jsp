<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color: blue; text-align: center;">Student Registaration
	Form</h1>
<frm:form action="register" method="POST" modelAttribute="std">
	<table border="0" bgcolor="cyan" align="center">
		<tr>
			<td>Student Id::</td>
		<td> <frm:input path="sid"/></td>
		</tr>
		<tr>
			<td>Student Name::</td>
			<td><frm:input path="sname"/></td>
		</tr>
		<tr>
			<td>Student Adderess::</td>
			<td><frm:input path="address"/></td>
		</tr>
			<tr>
			<td>Student Avg::</td>
			<td><frm:input path="avg"/></td>
		</tr>
		<tr>
		<td> <input type="submit" value ="register"/></td>
		<td><input type ="reset" value ="cancel"/></td>
		
		</tr>
		
		
	</table>

</frm:form>