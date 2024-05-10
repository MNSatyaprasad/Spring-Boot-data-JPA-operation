<%@ page isELIgnored="false" import="java.util.*" %>

<h1>Model Attributes data are </h1>

<b> favorite Colors :: <%=Arrays.toString(((String[])request.getAttribute("favColors"))) %></b>
<br>
<br>
<b> nick Names are ${nickNames}</b>
<br>
<br>
<b> Phone Numbers  are ${phoneNumbers}</b>
<br>
<br>
<b> Id Details are ${idDetails} </b>

