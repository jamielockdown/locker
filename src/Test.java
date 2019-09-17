import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	static Scanner sc = new Scanner(System.in);

	public static boolean checkDouble(String s) {
		//for robustness, check that that certain values are doubles
		boolean result = true;
		try {
			Double.parseDouble(s);
		}catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}

	public static boolean checkInt(String s) {
		//for robustness, check that that certain values are ints
		boolean result = true;
		try {
			Integer.parseInt(s);
		}catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}



	public static Phone createPhone() {// Create a new phone
		String make, model, description;
		int storage = 0;//initialise to avoid error. In reality variable has to be assigned a value to exit the do while loop below.
		boolean isNumeric;
		double price = 0;//initialise to avoid error.

		System.out.println("Phone make:");
		make = sc.nextLine();
		System.out.println("Phone model:");
		model = sc.nextLine();

		do {//for robustness, check that storage is an int
			isNumeric = true;
			System.out.println("Phone storage:");
			String storageNumericCheck = sc.nextLine();
			if (checkInt(storageNumericCheck)) {
				storage = Integer.parseInt(storageNumericCheck);
			}else {
				isNumeric = false;
				System.out.println("Please enter a numeric value for storage.");
			}
		}while (isNumeric == false);


		do {//for robustness, check that price is a double
			isNumeric = true;
			System.out.println("Phone price:");
			String priceNumericCheck = sc.nextLine();
			if (checkDouble(priceNumericCheck)) {
				price = Double.parseDouble(priceNumericCheck);
			}else {
				isNumeric = false;
				System.out.println("Please enter a numeric value for price.");
			}
		}while (isNumeric == false);


		System.out.println("Enter phone description:");
		description = sc.nextLine();

		Phone newPhone = new Phone(make, model, storage, price, description);
		return newPhone;
	}

	public static Customer createCustomer() {//Create a new customer
		String name, address;	
		System.out.println("Customer Name:");
		name = sc.nextLine();
		System.out.println("Customer Address (1 Line):");
		address = sc.nextLine();

		Customer newCustomer = new Customer (name, address);
		return newCustomer;
	}


	public static void main(String[] args) {
		ArrayList<Customer> custList = new ArrayList<Customer>(); //To handle "add new customer" menu option


		Phone ph0 = new Phone ("Apple", "iPhone XR", 64, 879, "All-new Liquid Retina display — the most advanced LCD in the industry. Even faster Face ID. The smartest, most powerful chip in a smartphone. And a breakthrough camera system. iPhone XR. It’s beautiful any way you look at it.");
		Phone ph1 = new Phone ("Apple", "iPhone XS", 64, 1179, "Super Retina display. Even faster Face ID. The smartest, most powerful chip in a smartphone. And a breakthrough dual-camera system. iPhone XS is everything you love about iPhone. Taken to the extreme.");
		TV tv0 = new TV ("Toshiba", "LED", 32, false, 180, "Toshiba HD Smart TV – Fire TV Edition delivers 720p picture quality with deep blacks and rich colors.");
		TV tv1 = new TV ("Cielo", "LED", 46, true, 900, "This LED HDTV features a large 46-inch screen and is 3D-compatible. You'll be able to see a clearer picture form anywhere in your room. It has a true 16 by nine aspect ratio, so you can view your movies as the director intended the viewer to.");

		ProductDB database = new ProductDB();

		database.add(ph0);
		database.add(ph1);
		database.add(tv0);
		database.add(tv1);
		//For testing application as per part 1.7 of project brief. In practice, the projectDB will be used to access product info, rather than variables such as ph0 and tv1.

		Customer cust1 = new Customer("Mary", "Melbourn Road, Cork");
		custList.add(cust1);

		Order o = new Order();

		o.add(ph0, 2);// 2 iPhone XRs
		o.add(tv0, 1);// 1 Toshiba

		cust1.getOrders().add(o);

		int menu;
		String menuCheck;
		boolean validMenu;
		
		

		do {
			validMenu = true;

			do {//for robustness, check that menu value is an int

				System.out.println("What would you like to do?");
				System.out.println("1.\tCreate a new phone.");
				System.out.println("2.\tCreate a new Customer.");
				System.out.println("3.\tSearch for a product by supplying the productid.");
				System.out.println("4.\tDisplay all products in the database.");
				System.out.println("5.\tAllow a customer to order some products.");
				System.out.println("6.\tDisplay all orders that a customer has made and all the products that are in a given order.");
				System.out.println("7.\tDisplay all orders for a given product by supplying the productid.");
				System.out.println("8.\tQuit.");

				menuCheck = sc.nextLine();

				if (!checkInt(menuCheck)) {
					validMenu = false;
					System.out.println("Please enter a numeric value.");
				}
			}while (validMenu == false);
			
			
			menu = Integer.parseInt(menuCheck);
		
			switch (menu) {
			case 1:	//create new phone product and add to database
				database.add(createPhone());
				System.out.println();
				break;

			case 2://Create new customer object, store in custList
				custList.add(createCustomer());
				System.out.println();
				break;

			case 3://Search for product by productID
				int id; 
				String idCheck; boolean validID;

				do {
					validID = true;
					System.out.println("Enter the productid number:");
					idCheck = sc.nextLine();

					if(!checkInt(idCheck)) {
						validID = false;
						System.out.println("Please enter a numeric value");
					}else {
						
					}
				}while (validID ==false);

				id = Integer.parseInt(idCheck);
				database.find(id).print();//Product print. Not yet cast to phone or tv
				System.out.println();
				break;

			case 4://Output every Product in database
				for (int i = 0; i < database.getProductList().size(); i++) {//
					database.getProductList().get(i).print();//Product print. Not yet cast to phone or tv
					System.out.println();
				}
				System.out.println();
				break;

			case 5:
				boolean valid;
				int custNum = 0, productNum = 0, product = 0;
				String custCheck, productCheck;
			
				do {
					valid = true;
					System.out.println("Which customer is ordering the products?");
					for (int i = 0; i < custList.size(); i++) {
						System.out.println(i+1);//  +- 1 to accommodate zero counting
						System.out.println(custList.get(i).getName() + ", " +  custList.get(i).getAddress());
					}
					custCheck = sc.nextLine();

					if(!checkInt(custCheck)) {
						valid = false;
						System.out.println("Please enter a numeric value");
					}else {
						custNum = Integer.parseInt(custCheck)-1;
					}
				}while(valid == false);
				
				Order custOrder = new Order();//add new order to customer
				custList.get(custNum).getOrders().add(custList.get(custNum).getOrders().size(), custOrder);
				
				do {
					valid = true;
					System.out.println("\nWhich products would the customer like to order?");
					for (int i = 0; i < database.getProductList().size(); i++) {
						System.out.println(i+1);//  +- 1 to accommodate zero counting
						database.getProductList().get(i).print();
					}
					productCheck = sc.nextLine();
				
					if(!checkInt(productCheck)) {
						valid = false;
						System.out.println("Please enter a numeric value");
					}else {
					product = Integer.parseInt(productCheck)-1;
					}
				}while (valid == false);
				
				do {
					valid = true;
					System.out.println("\nHow many of that product is the customer ordering?");
					productCheck = sc.nextLine();
				
					if(!checkInt(productCheck)) {
						valid = false;
						System.out.println("Please enter a numeric value");
					}else {
						productNum = Integer.parseInt(productCheck);
					}
				}while (valid == false);
				
					custOrder.add(database.getProductList().get(product), productNum);//add(product, quantity)
			
				break;
				
				
			case 6:
				
				do {
					valid = true;
					custNum = 0;
					System.out.println("Which customer's orders would you like to view?");
					for(int i = 1; i <= custList.size(); i++) {
						System.out.println((i) + ":\t " + custList.get(i-1).getName() + ", " +  custList.get(i-1).getAddress());
					}
					
					custCheck = sc.nextLine();
					
					if(!checkInt(custCheck)) {
						valid = false;
						System.out.println("Please enter a numeric value");
					}
					
				}while(valid == false);
				custNum = Integer.parseInt(custCheck) - 1;
				Customer custOption = custList.get(custNum);
				//  +- 1 to accommodate zero counting
				

				System.out.println("Which order would you like to view?");
				String orderCheck;
				int orderNum;
				do {
					valid = true;
					for (int i = 1; i <= custOption.getOrders().size(); i++) {
						System.out.println(i);
					}
					orderCheck = sc.nextLine();
					
					if (!checkInt(orderCheck)) {
						valid = false;
						System.out.println("Please enter a numeric value");
					}
					
				}while(valid == false);
				
				orderNum = Integer.parseInt(orderCheck) - 1;
				//  +- 1 to accommodate zero counting
				Order orderOption = custOption.getOrders().get(orderNum);
				
				for (int i = 0; i < orderOption.getProductList().size(); i++) {
					orderOption.getProductList().get(i).print();
				}
				break;

				
				
			case 7:
				
				do {
					valid = true;
					System.out.println("Enter the productID of the product for which you are searching.");
					idCheck = sc.nextLine();
					
					if (!checkInt(idCheck)) {
						valid = false;
						System.out.println("Please enter a numeric value");
					}
				}while(valid == false);
				
				int ID = Integer.parseInt(idCheck);


				for (int i = 0; i < custList.size(); i++) {
					for (int j = 0; j < custList.get(i).getOrders().size(); j++) {

						Order orderToCheck = custList.get(i).getOrders().get(j);

						if (orderToCheck.find(ID)!= null) {//Order object inherits the find method from ProductDB class.
							System.out.println("Customer:\t" + custList.get(i).getName() + ", Order:\t" + (j+1));
						}//If find doesn't return a null value, the productID appears in that order. j+1 used to allow for the zero counting
				
					}
				}

				break;
			case 8:
				System.out.println("Goodbye");
				break;


			default:
				System.out.println("Error. Please enter a value between 0 and 8.");
				menu = 1; //Takes the user back to the menu
				break;
			}
		}while (menu != 8);
	}

}
