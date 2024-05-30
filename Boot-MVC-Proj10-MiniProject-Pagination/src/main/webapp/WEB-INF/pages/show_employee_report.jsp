<%@ page isELIgnored="false"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<div class ="container">
<c:choose>
	<c:when test="${!empty empData.getContent()}">
		<h1 style="color: red; text-align: center;">Employees Report </h1>
		<table border="1" class="table">
			<tr class="table-danger">
				<th>Emp No</th>
				<th>Emp Name</th>
				<th>Emp Job</th>
				<th>Emp Dept</th>
				<th>Emp addts</th>
				<th>Emp Salary</th>
				<th> Emp Edit</th>
				<th> Emp Delete</th>
			</tr>
			<c:forEach var="emp" items="${empData.getContent()}">
				<tr class ="table-success">
					<td>${emp.eid }</td>
					<td>${emp.name }</td>
					<td>${emp.job }</td>
					<td>${emp.dept }</td>
					<td>${emp.addrs }</td>
					<td>${emp.salary }</td>
					<td><a href="emp_edit?no=${emp.eid }"> <img
							src="images/edit.png" width="50px" height="30px" align="middle"></a>
					</td>
					<td><a href="emp_delete?no=${emp.eid }"
					onclick="return confirm('Are you sure you want to delete this Employee?');"><img
							src="images/delete.png" width="50px" height="30px" align="middle"></a></td>
				</tr>
			</c:forEach>
		</table>
		<p style="text-align: center;">
		<c:if test ="${empData.hasPrevious() }">
		 <a href="emp_report?page=${empData.getPageable().getPageNumber()-1 }">previous</a>	&nbsp;	&nbsp;
		</c:if>
		<c:if test="${empData.isFirst() }">
		<a href="emp_report?page=0"> First</a>&nbsp;&nbsp;
		</c:if>
		<c:forEach var ="i" begin="1" end="${empData.getTotalPages() }" step="1">
			[<a href ="emp_report?page=${i-1}">${i}</a>] &nbsp;	&nbsp;			
		</c:forEach>
		<c:if test="${empData.isLast()}">
			<a href="emp_report?page=${empData.getTotalPages()-1 }">Last</a>&nbsp;	&nbsp;	
		</c:if>
		<c:if test="${empData.hasNext() }">
		<a href="emp_report?page=${empData.getPageable().getPageNumber()+1 }">Next</a>
		</c:if>
		</p>
		
	</c:when>
	<c:otherwise>
		<h1 style="color: green; text-align: center;">Employees Not Found</h1>
	</c:otherwise>
</c:choose>

<c:if test="${!empty resultMsg }">
<h2 style="color: green; text-align: center;">${resultMsg}</h2>
</c:if>

<h4 style="color: blue; text-align: center;">
	<a href="emp_add"> <img src="images/add.png" width="50px"height="50px" align="center"> Add Employee</a>
</h4>
&nbsp; &nbsp;
<br>
<h4 style="color: blue; text-align: center;">
	<a href="./"> <img src="images/home.png" width="40px" height="50px"align="center"> Home</a>
</h4>
</div>