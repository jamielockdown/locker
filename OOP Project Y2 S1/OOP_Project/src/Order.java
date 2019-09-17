
public class Order extends ProductDB{
	
	
	
	public boolean add(Product p, int quantity) {
		boolean success = false;
		
		for (int i = 0; i < quantity; i++) {
			super.add(p);
			success = true;
		}
		
		return success;
	}
}

