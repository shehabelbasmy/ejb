package tube.codingexmpales.servlet;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tube.codingexamples.ejb.stateful.ShoppingCartRemote;

@WebServlet("/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ShoppingCartRemote shoppingCartRemote;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getParameter("");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("ShoppingCart.jsp");
		
	}
}
