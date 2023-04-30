package tube.codingexamples.ejb.stateless;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless(mappedName = "HelloBean")
@LocalBean
public class HelloBean implements HelloBeanRemote {


	@Override
	public String sayHello() {
		
		return "Hello Frined";
	}

}
