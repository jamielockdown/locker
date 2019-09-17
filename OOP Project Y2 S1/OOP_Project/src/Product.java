
public class Product {
	private String name, description;
	private double price;
	private static int idGenerator = 0;
	private int productID;
	
	public static int getIdGenerator() {
		return idGenerator;
	}
	public static void setIdGenerator(int idGenerator) {
		Product.idGenerator = idGenerator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void print() {
		System.out.println("Product ID:\t\t" + productID);
		System.out.println("Product name:\t\t" + name);
		System.out.println("Product description:\t"+ description);
		System.out.println("Product price:\t\t"+ price);
		System.out.println();
	}
}
