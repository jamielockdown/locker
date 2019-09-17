public class TV extends Product{
	private String make, type;
	private int screenSize;
	private boolean compatible3D;
	
	public TV(String theMake, String theType, int screen, boolean threeD, float thePrice, String description) {
		setProductID(getIdGenerator());
		setIdGenerator(getIdGenerator()+ 1); //increment static ID generator
		make = theMake;
		type = theType;
		screenSize = screen;
		compatible3D = threeD;
		setPrice(thePrice);
		setDescription(description);
		
		this.setName(make +" "+ type +" "+ screenSize+ "\"");//For when Product.print() is called instead of tv.print();
		if (compatible3D == true) {
			this.setName(this.getName() + " 3D Compatible");
		}

	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}
	public boolean isCompatible3D() {
		return compatible3D;
	}
	public void setCompatible3D(boolean is3d) {
		compatible3D = is3d;
	}
	
	
	public void print(){
		
		System.out.println("Product ID:\t\t" + getProductID());
		System.out.println("TV Make:\t\t" + make);
		System.out.println("Screen Size:\t\t" + screenSize);
		System.out.println("TV Type:\t\t" + type);
		System.out.println("3D capable?\t\t" + compatible3D);
		System.out.println("Product description:\t"+ getDescription());
		System.out.println("Product price:\t\t"+ getPrice());
		
	}
	
}
