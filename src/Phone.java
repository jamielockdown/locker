
public class Phone extends Product{
	private String make, model;
	private int storage;
	
	public Phone(String theMake, String theModel, int theStorage, double price, String description) {
		setProductID(getIdGenerator());
		setIdGenerator(getIdGenerator()+ 1); //increment static ID generator
		make = theMake;
		model = theModel;
		storage = theStorage;
		setPrice(price);
		setDescription(description);
		
		this.setName(make+ " "+ model + " "+ storage+ "GB");//For when Product.print() is called instead of Phone.print();
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	
	
	public void print(){
		System.out.println("Product ID:\t\t" + getProductID());
		System.out.println("Phone Make:\t\t" + make);
		System.out.println("Phone Model:\t\t" + model);
		System.out.println("Phone Storage:\t\t" + storage + "GB");
		System.out.println("Product description:\t"+ getDescription());
		System.out.println("Product price:\t\t"+ getPrice());
	}
}
