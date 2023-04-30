<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="jakarta.ejb.EJB"%>
<%@page import="tube.codingexamples.ejb.stateful.ShoppingCartRemote"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Sample 2.5: Java Objects used here. We already have Project 
      Dependancy set as part of previous stateless bean demo   -->    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>

<body>
  <!-- Sample 2.6: Html Form to Collect Input  -->
  <form action="ShoppingCart.jsp" method="post">
    Place Item into Shopping Cart: 
    <input type="text" size=35 value="" name="Purchased"  />
    <input type="submit" value="Add to Cart" name="CartAction"/> 
    <input type="submit" value="Remove From Cart" name="CartAction" />
    <input type="submit" value="List items in Cart" name="CartAction"/>
    <input type="submit" value="Empty Cart" name="CartAction" />
  </form>
  <%!
  	@EJB
  	ShoppingCartRemote scart;
  %>
  <%
  //Sample 2.7: Get ShoppingCart from the Session Attribute, if not create the bean on server
  ShoppingCartRemote cart 
  =(ShoppingCartRemote) session.getAttribute("sessionShoppingCart");
  if(cart == null)
  {
    InitialContext ct = new InitialContext();
    //ShoppingCartRemote scart = 
      //  (ShoppingCartRemote) ct.lookup("java:global/EJBEar/EJBBean/ShoppingCart!tube.codingexamples.ejb.stateful.ShoppingCartRemote");
    session.setAttribute("sessionShoppingCart", scart);
  }

  //Sample 2.8: Get the input strings 
  String item = request.getParameter("Purchased");
  String CartAction = request.getParameter("CartAction");

  //Sample 2.9: Now Perform the Action
  if (CartAction != null)
  {
		if(CartAction.equalsIgnoreCase("Add to Cart"))
		{
			cart.placeProduct(item);
			out.println("<h3> " + item + " added to the cart </h3>");
		}
		if(CartAction.equalsIgnoreCase("Remove From Cart"))
		{
			cart.removeProduct(item);
			out.println("<h3> " + item + " removed to the cart </h3>");
		}
		if(CartAction.equalsIgnoreCase("List items in Cart"))
		{
			out.println("<h3> List of Items in the Cart </h3>");
			out.println("<ol>");
			List<String> items = cart.getAllItems();
			for(String CartItem: items)
			{
				out.println("<li>");
				out.println(CartItem);
				out.println("</li>");
			}
			out.println("</ol>");
			
		}
		if(CartAction.equalsIgnoreCase("Empty Cart"))
		{
			cart.clearProduct();
			out.println("<h3> Cart is Empty</h3>");
		}
	}
%>	
</body>
</html>