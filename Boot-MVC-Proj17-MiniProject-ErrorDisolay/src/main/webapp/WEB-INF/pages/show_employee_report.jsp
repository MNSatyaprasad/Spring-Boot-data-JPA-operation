<%@ page isELIgnored="false"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty empList}">
		<h1 style="color: red; text-align: center;">Employees Report </h1>
		<table border="1" bgcolor="orange" align="center">
			<tr style="color: red;">
				<th>Emp No</th>
				<th>Emp Name</th>
				<th>Emp Job</th>
				<th>Emp Dept</th>
				<th>Emp addts</th>
				<th>Emp Salary</th>
				<th> Emp Edit</th>
				<th> Emp Delete</th>
			</tr>
			<c:forEach var="emp" items="${empList}">
				<tr style="color: blue;">
					<td>${emp.eid }</td>
					<td>${emp.name }</td>
					<td>${emp.job }</td>
					<td>${emp.dept }</td>
					<td>${emp.addrs }</td>
					<td>${emp.salary }</td>
					<td><a href="emp_edit?no=${emp.eid }"> <img
							src="images/edit.png" width="30px" height="30px" align="center"></a>
					</td>
					<td><a href="emp_delete?no=${emp.eid }"
					onclick="return confirm('Are you sure you want to delete this Employee?');"><img
							src="images/delete.png" width="30px" height="30px" align="center"></a></td>

				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: green; text-align: center;">Employees Not Found</h1>
	</c:otherwise>
</c:choose>
<centre>
<h4 style="color: blue; text-align: center;">
	<a href="emp_add"> <img src="images/add.png" width="50px"
		height="50px" align="center"> Add Employee
	</a>
</h4>
&nbsp; &nbsp; <br>
<br>
<h4 style="color: blue; text-align: center;">
	<a href="./"> <img src="images/home.png" width="40px" height="50px"
		align="center"> Home
	</a>
</h4>
</centre>

<h2 style="color: green; text-align: center;">${resultMsg}</h2>