package cartSystemExample;

import java.util.*;
public class AppSystem extends TheSystem {
	AppSystem() {
		super();
	}

	@Override
	public void display() {
		
		System.out.println("Name \t \t Desc \t \t Price \t Quantity");
		for (String keys : getItemCollection().keySet()){
			
			System.out.format("%-16s %-15s %-7s %s\n", keys,getItemCollection().get(keys).getItemDesc()
					,getItemCollection().get(keys).getItemPrice(),getItemCollection().get(keys).getAvailableQuantity());
		}
	}

	@Override
	public Boolean add(Item item) {
		// Your code here
		if (item.equals(null)) {
			return false;
		}else if (getItemCollection().containsKey(item.getItemName())) {
			System.out.println(item.getItemName()+ " is already in the App System");
			return false;
		}else {
			getItemCollection().put( item.getItemName(), item);
			
			return true;
		}
		
	}
	

}
