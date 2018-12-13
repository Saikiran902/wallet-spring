<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="wdraw" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="color:Blue;">WithDraw Form</h1>
<wdraw:form action="withdrawmoney" modelAttribute="my">
<table align="center">
<tr>
<td>Enter mobile number:</td>
<td><wdraw:input path="mobNo" pattern="[7-9]{1}[0-9]{9}" title="mobile number should start with 7,8 or 9 and should be 10 digits"/></td>

</tr>
<tr>
<td>Enter amount to withdraw:</td>
<td><wdraw:input path="balance" pattern="[1-9]{1}[0-9]+" title="enter valid number"/></td>
</tr>
<tr>
<td align="center"><input type="submit" value="withdraw"/></td>
</tr>
</table>
<a href = "all">Go to Main Menu</a>
</wdraw:form>

</body>
</html>