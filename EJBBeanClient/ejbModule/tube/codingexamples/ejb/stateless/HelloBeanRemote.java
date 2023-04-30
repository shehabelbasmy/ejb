package tube.codingexamples.ejb.stateless;

import jakarta.ejb.Remote;

@Remote
public interface HelloBeanRemote {

	public String sayHello();
}
