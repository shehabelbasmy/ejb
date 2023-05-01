package tube.codingexamples.ejb.stateless;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import tube.codingexamples.jpa.entity.SavingAccount;

/**
 * Session Bean implementation class SavingAcBean
 */
@Stateless(mappedName = "savingAcBean")
@LocalBean
public class SavingAcBean implements SavingAcBeanRemote {

	@PersistenceContext(name="JPA")
	private EntityManager entityManager;
	
	@Override
	public int newAccount(String holderName, int initBalance) {
		SavingAccount account=new SavingAccount();
		account.setBalance(initBalance);
		account.setName(holderName);
		entityManager.persist(account);
		return account.getId();
	}

}
