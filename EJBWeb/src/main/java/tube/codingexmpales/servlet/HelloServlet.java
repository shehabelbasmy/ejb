package tube.codingexmpales.servlet;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.MediaType;
import tube.codingexamples.ejb.stateless.HelloBeanRemote;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private HelloBeanRemote helloBeanRemote;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = helloBeanRemote.sayHello();
		response.setContentType(MediaType.TEXT_HTML);
		response.getWriter().print(text);;
	}

}
