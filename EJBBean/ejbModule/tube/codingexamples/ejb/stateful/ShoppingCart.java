package tube.codingexamples.ejb.stateful;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;

@Stateful(mappedName = "shoppingCart")
@LocalBean
public class ShoppingCart implements ShoppingCartRemote {

	private List<String> products=new ArrayList<>();
	
	@Override
	public List<String> getAllItems() {
		return products;
	}

	@Override
	public void placeProduct(String name) {
		products.add(name);
	}

	@Override
	public void removeProduct(String name) {
		products.remove(name);
	}

	@Override
	public void clearProduct() {
		products.clear();
	}

}
