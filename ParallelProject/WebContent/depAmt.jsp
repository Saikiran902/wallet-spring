<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="dept" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <script type="text/javascript">
function chkEmpty(){
	if(document.frmReg.mobNo.value==""){alert("please enter mobile number");
	return false;}
	else{
		return true;
	}
}
</script> -->
<h1 align="center" style="color:Blue;">Deposit Money Form</h1>

<dept:form action="depositmoney" modelAttribute="my" >
<table align="center">
<tr>
<td>Enter mobile number:</td>
<td><dept:input path="mobNo" pattern="[7-9]{1}[0-9]{9}" title="mobile number should start with 7,8 or 9 and should be 10 digits" /></td>
</tr>
<tr>
<td>Enter amount to deposit:</td>
<td><dept:input path="balance" pattern="[1-9]{1}[0-9]+" title="enter valid number"/></td>
</tr>
<tr>
<td align="center"><input type="submit" value="deposit"/></td>
</tr>
</table>
<a href = "all">Go to Main Menu</a>
</dept:form>


</body>
</html>