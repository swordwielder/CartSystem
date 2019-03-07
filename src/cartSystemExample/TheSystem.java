package cartSystemExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
	private HashMap<String, Item> itemCollection;

	TheSystem() {
        itemCollection = new HashMap<String, Item>();
        if (getClass().getSimpleName().equals("AppSystem")) {
        	try {
    			FileReader reader = new FileReader("sample.txt");
    			Scanner s = new Scanner(reader);
    			String line;
    			while (s.hasNext()) {
    				line = s.nextLine();
    				String[] itemInfo = line.split("\\s+ ");;
    				Item a = new Item();
    				a.setItemName(itemInfo[0]);
    				a.setItemDesc(itemInfo[1]);
    				a.setItemPrice(Double.valueOf(itemInfo[2]));
    				a.setAvailableQuantity(Integer.valueOf(itemInfo[3]));
    				
    				itemCollection.put(itemInfo[0], a);
    				
    			}
    			s.close();
    		}catch (FileNotFoundException er) {
    			System.out.println("error reading the file");
    			er.printStackTrace();
    		}
        }
       
	}

	public Boolean checkAvailability(Item item) {
		// Your code here
		if (item.getQuantity() >= item.getAvailableQuantity()) {
			System.out.println("System is unable to add " + item.getItemName()+ " to the card. System only has" + item.getAvailableQuantity() + item.getItemName()+"s.");
			return false;
		}
		
		return true;
	}
	
	public HashMap<String, Item> getItemCollection() {
		return itemCollection;
	}

	public void setItemCollection(HashMap<String, Item> itemCollection) {
		this.itemCollection = itemCollection;
	}

	public Boolean add(Item item) {
		// Your code here
		if (item.equals(null)) {
			return false;
		}else if (itemCollection.containsKey(item.getItemName()) && item.getAvailableQuantity() > 0) {
			item.setQuantity(item.getQuantity()+1);
			//item.setAvailableQuantity(item.getAvailableQuantity()-1);
			return true;
		}else if(!itemCollection.containsKey(item.getItemName())) {
			itemCollection.put(item.getItemName(), item);
			//item.setAvailableQuantity(item.getAvailableQuantity()-1);
			return true;
		}else {
			return false;
		}
	}

	public String remove(String itemName) {
		// Your code here
		if (itemCollection.containsKey(itemName)) {
			itemCollection.remove(itemName);
					
			
			return itemName;
		}
		return null;
	}

	public abstract void display();
}
