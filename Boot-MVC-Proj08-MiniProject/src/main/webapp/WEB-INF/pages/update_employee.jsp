<%@ page isELIgnored="false"%>

<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color: red; text-align: center;" > Update Employee</h1>
<frm:form  modelAttribute="emp">
 <table align="center" bgcolor="cyan">
 <tr>
  <td> Employee Number </td>
  <td><frm:input path ="eid" readonly="true"/></td>
 </tr>
 <tr>
  <td> Employee Name   </td>
  <td><frm:input path ="name"/></td>
 </tr>
 <tr>
  <td> Employee Designation   </td>
  <td><frm:input path ="job"/></td>
 </tr>
 <tr>
  <td> Employee Department   </td>
  <td><frm:input path ="dept"/></td>
 </tr>
  <tr>
  <td> Employee Adderess   </td>
  <td><frm:input path ="addrs"/></td>
 </tr>
  <tr>
  <td> Employee Salary   </td>
  <td><frm:input path ="salary"/></td>
 </tr>
 <tr> 
 <td> <input type="submit" value="Update"></td>
 <td> <input type="reset" value="cancel"></td>
 </tr>
 </table>


</frm:form>
