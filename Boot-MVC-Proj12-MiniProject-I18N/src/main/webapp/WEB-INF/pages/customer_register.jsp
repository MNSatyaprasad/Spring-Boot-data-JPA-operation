<%@ page isELIgnored="false"  contentType="text/html; charset=UTF-8"%>

<%@ taglib uri ="http://www.springframework.org/tags" prefix="sp"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color: red; text-align: center;"><sp:message code ="home.link"/></h1>
<frm:form modelAttribute="cust">
<table border="1" bgcolor="cyan" align="center">
<tr>
  <td><sp:message code="cust.registration.no"></sp:message></td>
  <td><frm:input path ="no"/></td>
</tr>
<tr>
<td><sp:message code="cust.registration.name"></sp:message></td>
<td><frm:input path="name"/></td>
</tr>
<tr>
<td><sp:message code="cust.registraton.addrs"></sp:message></td>
<td><frm:input path="addrs"/></td>
</tr>
<tr>
<td><sp:message code="cust.registrator.phone"></sp:message></td>
<td><frm:input path="phoneNumber"/></td>
</tr>
<tr>
<td><input type="submit" value="<sp:message code="cust.btn.register"/>"/></td>
</tr>

</table>

</frm:form>
<br><br>

<p style="color: blue; text-align: center;">
<a href="?lang=hi_IN"> Hindi </a> &nbsp; &nbsp; &nbsp;
<a href="?lang=te_IN"> telugu</a>&nbsp; &nbsp; &nbsp;
<a href="?lang=bn_BD"> Bangla</a>&nbsp; &nbsp; &nbsp;
<a href="?lang=zh_CN"> Chinesse</a>&nbsp; &nbsp; &nbsp;
<a href="?lang=en_US"> English</a>&nbsp; &nbsp; &nbsp;
</p>