<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
<c:when test="${!empty empList }">
<table border="1" bgcolor="cyan" align="center">
<tr> <th>eno</th> <th>ename</th> <th>Salary</th> <th>isVacentied</th></tr>

<c:forEach var="emp" items="${empList }">
<tr>
<td>${emp.eNo }</td>
<td>${emp.eName }</td>
<td>${emp.empSlary }</td>
<td>${emp.isVanccinated }</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color: red; text-align: centre;"> Employess Not found </h1>
</c:otherwise>
</c:choose>