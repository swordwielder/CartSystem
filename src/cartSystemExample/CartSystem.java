package cartSystemExample;

public class CartSystem extends TheSystem {
	CartSystem() {
	}

	@Override
	public void display() {
		// Your code here
		//getItemCollection().
		
		double subtotal=0;
		double temporary=0;
		
		for (String keys : getItemCollection().keySet()){
			System.out.println("Item: "+keys + ", Total number: "+getItemCollection().get(keys).getQuantity()+ ", "
					+ "Price: " +getItemCollection().get(keys).getItemPrice()  );
		    temporary = getItemCollection().get(keys).getItemPrice()*getItemCollection().get(keys).getQuantity();
		    subtotal +=temporary;
		}
		
		double tax = subtotal * 0.05;
		double total = subtotal+tax;
		System.out.println("The subtotal: " + subtotal);
		System.out.println("The  tax  is: " + tax);
		System.out.println("The total is: " + total);
		
	}
	
}
