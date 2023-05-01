package tube.codingexamples.ejb.stateless;

import jakarta.ejb.Remote;

@Remote
public interface SavingAcBeanRemote {

	public int newAccount(String holderName,int initBalance);
}
