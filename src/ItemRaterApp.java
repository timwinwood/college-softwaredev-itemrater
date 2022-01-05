
/**
ItemRaterApp - a class that enables a user to provide ratings for items
	- prompts the user to:
		-- select an operation (e.g. "Add an Item","Add a Rating for a given Item" etc.)
	- processes the user's selected operation using a switch statement
	- reuses the instantiable class ItemRater to perform the operation
	- displays the results and returns the user to the application menu

an additional operation "Additional Choice - Generate Test Data" has been added to the application
 	- generates the max number of items, naming them "TestItemX", where X is the index of the item
 	- generates random ratings, up to the max number of ratings, for each item
 	
comments and spacing have been used exhaustively to aide review and demonstrate understanding
in a commercial setting, comments would be limited to more technical aspects of the application

@author Tim Winwood - x20213638
 
*/
public class ItemRaterApp {

	// main method, the entry point to the application
	public static void main(String[] args) {

		// declare local variables
		
		// declare a variable of type ItemRater, the instantiable Class used to perform the operation
		ItemRater itemRater = new ItemRater();
		
		// while loop to repetitively display application menu and process the user's selected operation
		while (true) {
			
			// declare a variable of type int to store the user's selected operation
			// call method displayAppMenu() on the itemRater object to display the application menu and return the user's selected operation
			int intChoice = itemRater.displayAppMenu();

			// switch statement to process the user's selected operation 
			switch (intChoice) {

			// operation - "Add an Item"
			case 0:
				
				// call method addItem() on the itemRater object to perform the operation "Add an Item"
				itemRater.addItem();

				break;
				
			// operation - "Display all the Items"
			case 1:
				
				// call method addItem() on the itemRater object to perform the operation "Add an Item"
				itemRater.displayAllItems();
				
				// call method pressEnterReturnToMenu() on the itemRater object to return the user to the application menu
				itemRater.pressEnterReturnToMenu();

				break;

			// operation - "Add a Rating for a given Item"
			case 2:
				
				// call method addRatingForItem() on the itemRater object to perform the operation "Add a Rating for a given Item"
				itemRater.addRatingForItem();

				break;

			// operation - "Display all the Ratings for a Given Item"
			case 3:
				
				// call method displayRatingsForItem() on the itemRater object to perform the operation "Display all the Ratings for a Given Item"
				itemRater.displayRatingsForItem();

				break;

			// operation - "Calculate and Display the Average Rating for Each Item"
			case 4:
				
				// call method displayAverageRatingForItems() on the itemRater object to perform the operation "Calculate and Display the Average Rating for Each Item"
				itemRater.displayAverageRatingForItems();

				break;

				
			// the last digit of my student id (x20213638) is 8, therefore the operation is:
			// operation - "Display the Best Item Based on the Average Rating"
			case 5:
				
				// call method displayBestItemByAverageRating() on the itemRater object to perform the operation "Display the Best Item Based on the Average Rating"
				itemRater.displayBestItemByAverageRating();

				break;

			// operation - "Exit Application"
			case 6:
				
				// call method exitApplication() on the itemRater object to exit the application
				itemRater.exitApplication();

				break;

			// operation - "Additional Choice - Generate Test Data"
			case 7:
				
				// call method generateTestData() on the itemRater object to perform the operation "Additional Choice - Generate Test Data"
				itemRater.generateTestData();

				break;

			// invalid operation - display a message and return the user to the application menu
			default:
				
				// call method invalidOperation() on the itemRater object to display a message and return the user to the application menu
				itemRater.invalidOperation();

			}// end switch statement

		}// end while loop

	}// end Main method

}// end ItemRaterApp Class
