<%@page import="jakarta.ejb.EJB"%>
<%@page import="tube.codingexamples.ejb.stateless.SavingAcBeanRemote"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--Sample 3.9: Page Include Directive --%>    
<%@ page import='javax.naming.InitialContext'%>
<%@ page import='javax.naming.NamingException'%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Savings Ac</title>
</head>
<body>
<!-- Sample 3.10: Account Creation Form -->
<FORM action="CreateNewAccount.jsp">
<h1>Savings Account Creation Form</h1>
Enter Your Name: <br>
<input name="person_name" type="text" size="25" value=""><br>
Initial Amount:  <br>
<Input name="balance" type="text" size="5" value=""><br>
<input name="NewAc" type="submit" value="Submit"><br>
</FORM>
<%
	//Sample 3.11: Create Session Bean and Submit Account Creation Request
	String PersonName = request.getParameter("person_name");
	String InitBalance = request.getParameter("balance");
	if (PersonName != null && PersonName.trim().length() > 0) {
		try {
			InitialContext ctx = new InitialContext();
			SavingAcBeanRemote accontMgr = (SavingAcBeanRemote) 
					ctx.lookup("java:global/EJBEar/EJBBean/SavingAcBean!tube.codingexamples.ejb.stateless.SavingAcBeanRemote");
			int balance = Integer.valueOf(InitBalance).intValue();
			int id = accontMgr.newAccount(PersonName, balance);
			out.println("Account created.  Account holder Personal ID <h2" + 
			"style=\"font-size: 16pt; color: teal; font-family: Verdana;\">" + id + "</h2>");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
%>
</body>
</html>