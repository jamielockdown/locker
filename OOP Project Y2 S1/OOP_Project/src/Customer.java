import java.util.ArrayList;

public class Customer {
	private String name, address;
	
	private ArrayList <Order> orders;
	
	public Customer(String theName, String theAddress) {
		name = theName;
		address = theAddress;
		orders = new ArrayList<Order>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
}
