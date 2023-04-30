package tube.codingexamples.ejb.stateful;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface ShoppingCartRemote {

	public List<String> getAllItems();
	
	public void placeProduct(String name);
	
	public void removeProduct(String name);
	
	public void clearProduct();
}
