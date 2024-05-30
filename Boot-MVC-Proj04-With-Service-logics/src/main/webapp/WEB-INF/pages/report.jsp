<%@ page isELIgnored="false" import="java.util.*"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${!empty emp }">
<b>Employee Information :: ${emp.eNo }, ${emp.eName }, ${emp.empSlary }, ${emp.isVanccinated }</b>
</c:if>