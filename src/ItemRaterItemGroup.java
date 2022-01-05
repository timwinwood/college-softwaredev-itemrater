/**
ItemRaterItemGroup - an instantiable class, a class used to represent a 'group' of ItemRaterItems

@author Tim Winwood - x20213638
 
*/
public class ItemRaterItemGroup {

	// declare instance Variables
	
	// declare a variable of type String, to store the item type
	private String itemType;
	
	// declare a variable of type int,  to store the maximum number of items
	private int maxNumItems;
	
	// declare a variable of type ItemRaterItem, and array to store the items
	private ItemRaterItem[] items;
	
	// declare a variable of type int, to keep track of the number of items
	private int itemCount = 0;
	
	// declare a variable of type ItemRaterItem, to store the best Item
	private ItemRaterItemGroup itemRaterItemGroupBest;
	
	// declare a variable of type double, to store the best rating
	private double bestRating;
	
	// declare constructor
	
	// ItemRaterItemGroup constructor, called when an object of type ItemRaterItemGroup is initialised
	public ItemRaterItemGroup(String itemType,int maxNumItems) {
		
		this.itemType =  itemType;
		this.maxNumItems =  maxNumItems;
		this.items = new ItemRaterItem[maxNumItems];	
		
	}// end ItemRaterItemGroup constructor
	
	// declare methods
	
public ItemRaterItemGroup calcBestItemByAverageRating(){
	
	itemRaterItemGroupBest = new ItemRaterItemGroup(itemType,maxNumItems);

			for (int i = 0; i < itemCount; i++) {	
				
				ItemRaterItem itemI = items[i];
				
				if (itemI != null) {	
					
					int ratingCountI = itemI.getRatingCount();
					
					if(ratingCountI > 0) {
						
						double averageRatingI = itemI.calcAverageRating();
						double bestRating = itemRaterItemGroupBest.getBestRating();
				
						if(averageRatingI > bestRating) {

							// Reset the best List
							itemRaterItemGroupBest = new ItemRaterItemGroup(itemType,maxNumItems);
							itemRaterItemGroupBest.addItem(itemI);
							itemRaterItemGroupBest.setBestRating(averageRatingI);
							
						}else if (averageRatingI == bestRating){
							
							itemRaterItemGroupBest.addItem(itemI);
							
						}
						
					}
					
				}
				
			}
			
			return itemRaterItemGroupBest;
						

	}// end displayBestItemByAverageRating method

	
	// getItemRaterItemGroupBest method, get the getItemRaterItemGroupBest
	public ItemRaterItemGroup getItemRaterItemGroupBest() {
		
		return itemRaterItemGroupBest;
		
	}// end getItemRaterItemGroupBest method
	

	// getBestRating method, get the bestRating
	public double getBestRating() {
		
		return bestRating;
		
	}// end getBestRating method
	
	// setBestRating method, set the bestRating
	public void setBestRating(double bestRating) {
		
		this.bestRating = bestRating;
		
	}// end getBestRating method
	
	
	// addItem method, add an item to the end of the items array
	public void addItem(ItemRaterItem item) {
		
		this.items[itemCount] = item;
		this.itemCount++;
		
	}// end addItem method
	
	
	// getItemByName method, get an item from the ratings array by the item name
	public ItemRaterItem getItemByName(String itemName) {
		
		// initialise the variable 'item' of type ItemRaterItem to null
		// used to store the item or null if an item with itemName is not found
		ItemRaterItem item = null;
		
		// loop items
		for(int i = 0; i < itemCount; i++) {
			
			// get the next item from the items array
			ItemRaterItem itemI = items[i];
			
			// get the next item name from the item
			String itemNameI = itemI.getName();
			
			// if the next item name is equal to itemName
			if(itemName.equalsIgnoreCase(itemNameI)) {
				
				// set item to the next item
				item = itemI;
				
			}// end if itemNameI is equal to itemName
			
		}// end loop items
		
		// return the item or null if an item with itemName is not found
		return item;
		
	}// end getItemByName method
	
	
	// getItemType method, get the itemType
	public String getItemType() {
		
		return itemType;
		
	}// end getItemType method

	
	// getMaxNumItems method, get the maxNumItems
	public int getMaxNumItems() {
		
		return maxNumItems;
		
	}// end getMaxNumItems method

	
	// getItems method, get the items array
	public ItemRaterItem[] getItems() {
		
		return items;
		
	}// end getItems method
	
	
	// getItem method, get an item from the items array
	public ItemRaterItem getItem(int index) {
		
		return items[index];
		
	}// end getItem method

	
	// getItemCount method, get the itemCount
	public int getItemCount() {
		
		return itemCount;
		
	}// end getItemCount method
	
	
	// setItemType method, set the itemType
	public void setItemType(String itemType) {
		
		this.itemType = itemType;
		
	}// endsetItemType method

	
	// setMaxNumItems method, get the maxNumItems
	public void setMaxNumItems(int maxNumItems) {
		
		this.maxNumItems = maxNumItems;
		
	}// end setMaxNumItems method
	
	
	// setItems method, set the items array
	public void setItems(ItemRaterItem[] items) {
		
		this.items = items;
		
	}// end setItems method

	
	// setItemCount method, set the itemCount
	public void setItemCount(int itemCount) {
		
		this.itemCount = itemCount;
		
	}// end setItemCount method
	
	
}// end ItemRaterItemGroup class
