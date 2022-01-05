/**
ItemRaterItem - an instantiable class, a class used to represent an 'item' that can be rated

@author Tim Winwood - x20213638
 
*/
public class ItemRaterItem {

	// declare constants
	
	// declare a constant of type int, to store the rating accuracy (decimal places)
	static final int RATING_ACCURACY = 2;
	
	// declare instance Variables
	
	// declare a variable of type int, used to store the maximum number of ratings
	private int maxNumRatings;
	
	// declare a variable of type String, used to store the name of the ItemRaterItem
	private String name;
	
	// declare a variable of type double[], an array used to store the ratings
	private double[] ratings;
	
	// declare a variable of type int, used to keep track of the number of ratings
	private int ratingCount = 0;
	
	// declare a variable of type double, used to store the average rating
	private double averageRating;

	
	// declare constructor
	
	// ItemRaterItem constructor, called when an object of type ItemRaterItem is initialised
	public ItemRaterItem(String name, int maxNumRatings) {
		
		this.name = name;
		this.maxNumRatings = maxNumRatings;
		this.ratings = new double[maxNumRatings];
		
	}// end ItemRaterItem constructor
	
	// declare methods
	
	// getName method, get the name
	public String getName() {
		
		return name;
		
	}// end getName method

	
	// setName method, set the name
	public void setName(String name) {
		
		this.name = name;
		
	}// end setName method

	
	// getRatingCount method, get the ratingCount
	public int getRatingCount() {
		
		return ratingCount;
		
	}// end getRatingCount method

	
	// setRatingCount method, set the ratingCount
	public void setRatingCount(int ratingCount) {
		
		this.ratingCount = ratingCount;
		
	}// end setRatingCount method
	
	
	// getMaxNumRatings method, get the maxNumRatings
	public int getMaxNumRatings() {
		
		return maxNumRatings;
		
	}// end getMaxNumRatings method

	
	// setMaxNumRatings method, set the maxNumRatings
	public void setMaxNumRatings(int maxNumRatings) {
		
		this.maxNumRatings = maxNumRatings;
		
	}// end setMaxNumRatings method

	
	// getRatings method, get the ratings array
	public double[] getRatings() {
		
		return ratings;
		
	}// end getRatings method

	
	// getRating method, get a rating from the ratings array
	public double getRating(int index) {
		
		return this.ratings[index];
		
	}// end getRating method

	
	// setRating method, set a rating in the ratings array
	public void setRating(int index, int rating) {
		
		double scale = Math.pow(10, RATING_ACCURACY);
		this.ratings[index] = Math.round(rating * scale) / scale;
		
	}// end setRating method
	
	
	// addRating method, add a rating to the end of the ratings array
	public void addRating(double rating) {
		
		double scale = Math.pow(10, RATING_ACCURACY);
		ratings[ratingCount] = Math.round(rating * scale) / scale;
		ratingCount++;
		
	}// end addRating method
	
	
	// calcAverageRating method, calculate the average rating
	public double calcAverageRating() {
		
		// declare a variable of type int (within the scope of this method), used to store the sum of the ratings
		double sumRatings = 0;
		
		// loop ratings
		for(int i = 0; i < ratingCount; i++) {
			
			// add the rating to the sum of the ratings
			double itemRating = ratings[i];
			sumRatings += itemRating;
			
		}// end loop ratings
		
		// calculate the average rating
		double scale = Math.pow(10, RATING_ACCURACY);
		averageRating = Math.round((sumRatings/ratingCount) * scale) / scale;
		
		//return the average rating
		return averageRating;
		
	}// end calcAverageRating method

	
	// getAverageRating method, get the averageRating
	public double getAverageRating() {
		
		return averageRating;
		
	}// end getAverageRating method


}// end ItemRaterItem class
