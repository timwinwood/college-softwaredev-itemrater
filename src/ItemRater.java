/**
ItemRater - an instantiable class, a class that performs operations for an item rater application

@author Tim Winwood - x20213638
 
*/

// import the java.util.Random class, used to generate random ratings for test data
import java.io.IOException;
import java.util.Random;

// import the java.util.Scanner class, used to gain input from the user
import java.util.Scanner;

public class ItemRater {
	// declare constants
	
	// declare a constant of type String, to store the item type
	// the penultimate digit of my student id (x20213638) is 3, therefore the item type is "Electronics"
	static final String ITEM_TYPE = "Electronics";
	
	// declare a constant of type int, to store the maximum number of items
	static final int MAX_NUM_ITEMS = 5;
	
	// declare a constant of type int, to store the max number of ratings per item
	static final int MAX_NUM_RATINGS = 5;
	
	// declare a constant of type double, to store the minimum possible rating
	static final double MIN_RATING = 1;
	
	// declare a constant of type double, to store the maximum possible rating
	static final double MAX_RATING = 5;

	// declare a constant of type String[], an array to store the application operations
	static final String[] APP_OPERATIONS = {
			"Add an Item",
			"Display all the Items",
			"Add a Rating for a given Item",
			"Display all the Ratings for a Given Item",
			"Calculate and Display the Average Rating for Each Item",
			"Display the Best Item Based on the Average Rating",
			"Exit Application",
			"Additional Choice - Generate Test Data" };

	// declare instance Variables
	
	// declare a variable of type Scanner, used to gain input from the user
	private Scanner input;
	
	// declare a variable of type ItemRaterItemGroup, used to store a 'group' of ItemRaterItems
	private ItemRaterItemGroup itemRaterItemGroup;
	
	// declare constructor
	
	// ItemRater constructor, called when an object of type ItemRater is initialised
	public ItemRater() {
		
		// initialise the variable 'input' of type Scanner, used to gain input from the user 
		this.input = new Scanner(System.in);
		
		// initialise the variable 'itemRaterItemGroup' of type ItemRaterItemGroup, used to store a 'group' of ItemRaterItems
		this.itemRaterItemGroup = new ItemRaterItemGroup(ITEM_TYPE, MAX_NUM_ITEMS);
		
	}// end ItemRater constructor
	
	// declare methods
	
	// invalidOperation method, display a message and return the user to the application menu
	public void invalidOperation() {
		
		// display a message
		System.out.println("Invalid Choice. Please enter a number between 1 and 8.");
		
		// return the user to the application menu
		pressEnterReturnToMenu();
		
	}// end invalidOperation method
	
	/** generateTestData method
		-- generates the max number of items, naming them "TestItemX", where X is the index of the item
 		-- generates random ratings, up to the max number of ratings, for each item */
	public void generateTestData() {
		
		// initialise the variable 'rand' of type Random, used to generate random ratings for test data
		Random rand = new Random();
		
		// loop items
		for (int i = 0; i < MAX_NUM_ITEMS; i++) {
			
			// initialise the ItemRaterItem
			String itemNameI = "TestItem" + (i + 1);
			ItemRaterItem itemI = new ItemRaterItem(itemNameI, MAX_NUM_RATINGS);	
			System.out.println("Adding Item \"" + itemNameI + "\" of Item Type \"" + ITEM_TYPE + "\"...");
			
			// loop ratings
			for (int j =0; j < MAX_NUM_RATINGS; j++) {
				
				// add a rating to the ItemRaterItem 
				double ratingJ =  MIN_RATING + (MAX_RATING -  MIN_RATING) * rand.nextDouble();
				itemI.addRating(ratingJ);
				
				System.out.println("Rating of \"" + itemI.getRating(j) + " out of " + MAX_RATING  + "\" for item \"" + itemNameI + "\" successfully added.");
				
			}// end loop ratings
			
			// add the ItemRaterItem to the ItemRaterItemGroup
			itemRaterItemGroup.addItem(itemI);
			System.out.println("Item \"" + itemNameI + "\" of Item Type \"" + ITEM_TYPE + "\" succesfully added.");
			
		}// end loop items
		
		// return the user to the application menu
		System.out.println("Test data succesfully generated.");
		pressEnterReturnToMenu();
		
	}// end generateTestData method
	
	
	// exitApplication method, exit the application
	public void exitApplication() {
		
		// exit the application
		System.exit(0);
		
	}// end exitApplication method
	
	
	// displayBestItemByAverageRating method, calculates and displays the best item based on the average rating
	public void displayBestItemByAverageRating(){
		
	ItemRaterItemGroup itemRaterItemGroupBest = itemRaterItemGroup.calcBestItemByAverageRating();
	int itemCountBest = itemRaterItemGroupBest.getItemCount();
	
	if(itemCountBest > 0) {

		double bestRating = itemRaterItemGroupBest.getBestRating();
		
		if(bestRating > 0) {
			
			System.out.print("Item(s): ");
			ItemRaterItem[] itemsBest = itemRaterItemGroupBest.getItems();
			
			for (int i = 0; i < itemCountBest; i++) {
				
				ItemRaterItem itemBestI = itemsBest[i];
				String itemNameBestI = itemBestI.getName();
				System.out.print("\"" + itemNameBestI + "\", ");
				
			}
			
			System.out.println("with the best average rating of " + bestRating + " out of " + MAX_RATING);
			
		}else {
			
			System.out.println("No Ratings have been added to the Application.");
			
		}
		
		pressEnterReturnToMenu();
	
	}else {
		
		System.out.println("No Items have been added to the Application.");
		pressEnterReturnToMenu();
		
		}

	}// end displayBestItemByAverageRating method
	

	// displayAverageRatingForItems method, calculates and displays the average rating for each item
	public void displayAverageRatingForItems() {
		
		int itemCount = itemRaterItemGroup.getItemCount();
		
		if(itemCount > 0) {
			
			ItemRaterItem[] items = itemRaterItemGroup.getItems();
			System.out.println("Displaying all the Items:");
			
			for (int i = 0; i < itemCount; i++) {
				
				ItemRaterItem itemI = items[i];
				
				if (itemI != null) {
					
					String itemNameI = itemI.getName();			
					int ratingCountI = itemI.getRatingCount();
					
					if(ratingCountI > 0) {
							
						double averageRatingI = itemI.calcAverageRating();
						System.out.println("Item Name: \"" + itemNameI + "\" - average rating: " + averageRatingI + " out of " + MAX_RATING);
	
					}else {
						
						System.out.println("Item with Name: \"" + itemNameI + "\" has not yet been rated.");
						pressEnterReturnToMenu();
						
					}

				}
			}
			
			pressEnterReturnToMenu();
		
		}else {
			
			System.out.println("No Items have been added to the Application.");
			pressEnterReturnToMenu();
			
		}
		
	}// end displayAverageRatingForItems method
	
	
	// displayRatingsForItem method, display all the ratings for a given item
	public void displayRatingsForItem(){
		
		displayAllItems();
		System.out.println("Enter Item Name:");
		String itemName = input.next();
		ItemRaterItem item = itemRaterItemGroup.getItemByName(itemName);
		
		if(item != null) {
			
			int ratingCount = item.getRatingCount();
			
			if(ratingCount > 0) {
				
				double[] itemRatings = item.getRatings();
				System.out.println("Item with Name: \"" + itemName + "\" has been rated " + ratingCount + " time(s):");
				
				for(int i = 0; i < ratingCount; i++) {
					
					double itemRatingI = itemRatings[i];	
					System.out.println(itemRatingI + " out of " + MAX_RATING);
					
				}
				
				pressEnterReturnToMenu();
				
			}else {
				
				System.out.println("Item with Name: \"" + itemName + "\" has not yet been rated.");
				pressEnterReturnToMenu();
				
			}
	
		}else {
			
			System.out.println("Item with Name: \"" + itemName + "\" does not exit.");
			pressEnterReturnToMenu();
			
		}
		
	}// end displayRatingsForItem method
	
	
	// addRatingForItem method, add a rating for a given item
	public void addRatingForItem(){
		
		displayAllItems();
		System.out.println("Enter Item Name:");
		String itemName = input.next();
		ItemRaterItem item = itemRaterItemGroup.getItemByName(itemName);
		
		if(item != null) {
			
			int ratingCount = item.getRatingCount();
			
			if (ratingCount < MAX_NUM_RATINGS) {
				
				System.out.println("Enter Rating (" + MIN_RATING +  " to " + MAX_RATING + ") :");
				double itemRating = input.nextDouble();
				
					if(itemRating >= MIN_RATING && itemRating <= MAX_RATING) {
						
						item.addRating(itemRating);
						System.out.println("Rating of \"" + itemRating + " out of " + MAX_RATING  + "\" for item \"" + itemName + "\" succesfully added.");
						pressEnterReturnToMenu();
						
					}else {
						
						System.out.println("Rating entered (" + itemRating +") must be between " + MIN_RATING +  " and " + MAX_RATING + ".");
						pressEnterReturnToMenu();
						
					}

			} else {
				
				System.out.println("The Maximum Number of Ratings (" + MAX_NUM_RATINGS + " Ratings) has been met for Item \"" + itemName + "\"");
				pressEnterReturnToMenu();
				
			}
			
		}else {
			
			System.out.println("Item with Name: \"" + itemName + "\" does not exit.");
			pressEnterReturnToMenu();
			
		}
			
	}// end addRatingForItem method
	
	
	// displayAllItems method, display all the items
	public void displayAllItems() {
		
		// initialise the variable 'itemCount' of type int, used to store the item count
		int itemCount = itemRaterItemGroup.getItemCount();
		
		// if item count more than 0
		if(itemCount > 0) {
			
			// get the items in the item group
			ItemRaterItem[] items = itemRaterItemGroup.getItems();
			
			// loop the items in the item group
			System.out.println("Displaying all the Items:");			
			for (int i = 0; i < itemCount; i++) {
				
				// initialise the variable 'itemI' of type ItemRaterItem, used to store the next item
				ItemRaterItem itemI = items[i];
				
				// if next item is not null
				if (itemI != null) {
					
					// display the item number/index and item name
					String itemIName = itemI.getName();
					System.out.println("Item Number: " + (i + 1) + " Item Name: \"" + itemIName + "\"");
					
				}// end if next item is not null
				
			}// end loop the items in the item group
		
		}else {
			
			// item count 0 or less
			// display a warning message and return the user to the application menu
			System.out.println("No Items have been added to the Application.");
			pressEnterReturnToMenu();
			
		}// end if item count more than 0

	}// end displayAllItems method
	
	
	// addItem method, add an item
	public void addItem() {
		
		// initialise the variable 'itemCount' of type int, used to store the item count
		int itemCount = itemRaterItemGroup.getItemCount();
		
		// if item count less than max number of items
		if (itemCount < MAX_NUM_ITEMS) {
			
			// prompt the user for item name and add item to the group
			System.out.println("Enter Item Name:");
			String itemName = input.next();
			ItemRaterItem item = new ItemRaterItem(itemName, MAX_NUM_RATINGS);
			itemRaterItemGroup.addItem(item);
			System.out.println("Item \"" + itemName + "\" of Item Type \"" + ITEM_TYPE + "\" succesfully added.");
			pressEnterReturnToMenu();
			
		} else {
			
			// item count more than max number of items
			// display a warning message and return the user to the application menu
			System.out.println("The Maximum Number of Items (" + MAX_NUM_ITEMS + " Items) has been met.");
			pressEnterReturnToMenu();
			
		}// end if item count less than max number of items
		
	}// end addItem method
	
	
	// addItem method, display the application menu and return the user's selected operation
	public int displayAppMenu() {
		
		// display the application summary
		System.out.println("Application Menu ... For Item Type: " + ITEM_TYPE);
		System.out.println("Maximum Number of Items: " + MAX_NUM_ITEMS);
		System.out.println("Maximum Number of Ratings: " + MAX_NUM_RATINGS);
		
		// loop and display the application operations
		for (int i = 0; i < APP_OPERATIONS.length; i++) {
			
			System.out.println((i + 1) + " - " + APP_OPERATIONS[i]);
			
		}// end  loop and display the application operations

		// prompt the user to select an operation
		System.out.println("Enter Your Choice:");
		int intChoice = input.nextInt() - 1;
		
		// return the user's selection
		return intChoice;
		
	}// end displayAppMenu method

	
	// pressEnterReturnToMenu method, return the user to the application menu
	public void pressEnterReturnToMenu() {

		// prompt the user to press the Enter key
		System.out.println("Press Enter key to return to Application Menu...");
		
		// try/catch block to handle the IOException thrown by System.in.read method
		try {
			
			// reads the next byte of data from the input stream
			// in this context this is being used to wait for the user to press the Enter key
			System.in.read();
			
		} catch (IOException e) {
			
			// if an IOException is thrown, print the stack trace (the list of methods the application is currently processing)
			e.printStackTrace();
			
		}// end try/catch block

	}// end pressEnterReturnToMenu method

}// end ItemRater class
