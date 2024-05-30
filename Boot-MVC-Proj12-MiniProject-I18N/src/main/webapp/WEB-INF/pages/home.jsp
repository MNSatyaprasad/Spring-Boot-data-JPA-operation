<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h1 style="color: red;text-align: center;"> <sp:message code="home.title"/> </h1>

<br><br>
<a href="register"><h2 style="color: blue; text-align: center;"> <sp:message code="home.link"/></h2></a>
<br>
<h3 style="color: black; text-align: center;"> Current Active :: ${pageContext.response.locale}</h3>

<fmt:setLocale value="${pageContext.response.locale}"/>
<jsp:useBean id="dt" class="java.util.Date"/>
<fmt:formatDate var="fdt" value="${dt}" type="date" dateStyle="LONG"/>
<b> formated Date :: ${fdt }</b> <br>
<fmt:formatDate var="ftime" value="${dt}" type="time" timeStyle="Long"/>
<b> Formatted Time :: ${ftime}</b> <br>
<fmt:formatNumber var="fnumber" value="15250065.89" type ="number"/>
<b> Formated Number :: ${fnumber}</b><br>
<fmt:formatNumber var="fcurrency" value="15250065.89" type ="currency"/>
<b> Formated Currency :: ${fcurrency}</b><br>
<fmt:formatNumber var="fpercent" value="0.256" type ="percent"/>
<b> Formated percentage :: ${fpercent}</b>
<br><br>

<p style="color: blue; text-align: center;">
<a href="?lang=hi_IN"> Hindi </a> &nbsp; &nbsp; &nbsp;
<a href="?lang=te_IN"> telugu</a>&nbsp; &nbsp; &nbsp;
<a href="?lang=bn_BD"> Bangla</a>&nbsp; &nbsp; &nbsp;
<a href="?lang=zh_CN"> Chinesse</a>&nbsp; &nbsp; &nbsp;
<a href="?lang=en_US"> English</a>&nbsp; &nbsp; &nbsp;
</p>