import java.util.ArrayList;

public class ProductDB {
	private ArrayList<Product> list;
	
	public ProductDB() {
		list = new ArrayList<Product>();
	}
	
	public boolean add(Product p) {
		return list.add(p);
	}
	
	public boolean remove (Product p) {
		
		boolean success = false;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == p) {
				list.remove(i);
				success = true;
		//remove(int index) used instead of remove(object) because it automatically shifts the index of subsequent elements
		//I could find no confirmation in the documentation that remove(object) did the same		
				
			}
		}
		return success;
	}
	
	public Product find (int ID) {
		Product searchedProduct = null;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getProductID() == ID) {
				searchedProduct = list.get(i);
			}
		}
		return searchedProduct;
	}
	
	public ArrayList<Product> getProductList() {
		return list;
	}

}
