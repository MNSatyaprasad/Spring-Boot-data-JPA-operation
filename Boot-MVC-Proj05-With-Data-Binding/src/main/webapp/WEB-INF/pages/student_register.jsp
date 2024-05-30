<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<h1 style="color: red; text-align: center;">Student Registartion
	form</h1>

<form action="register" method="POST">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Student Number</td>
			<td><input type="number" name="sid"></td>
		</tr>

		<tr>
			<td>Student Name</td>
			<td><input type="text" name="sname"></td>
		</tr>
		<tr>
			<td>Student Address</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td>Student Avg</td>
			<td><input type="text" name="avg"></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" value="Register"></td>
		<td colspan="1"><input type="button" value="cancel"></td>
		</tr>
	</table>

</form>