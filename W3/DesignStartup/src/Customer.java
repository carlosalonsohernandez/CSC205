package W3.DesignStartup.src;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String _name;	
	private List<Rental> _rentals = new ArrayList<>();

	public Customer(String name) {
		super();
		this._name = name;
	}
	public void addRentals(Rental rental){
		_rentals.add(rental);
	}
	public String getName() {
		return this._name;
	}
	public String statement(){
		double totalAmount = 0 ;
		int frequentRenterPoints =0;
		String result = "Rental Records for " + this.getName() +"\r\n";
		for (Rental rental : _rentals) {
			double thisAmount =0;
			var priceCode = rental.getMovie().getPriceCode();
			switch(priceCode){
				case Movie.REGULAR:
					thisAmount = thisAmount +2;
					if(rental.getDaysRented()>2){
						totalAmount = totalAmount + (rental.getDaysRented() -2)* 1.5;
					}
					break;
				case Movie.CHILDREN:
					thisAmount = thisAmount + 1.5;
					if(rental.getDaysRented()>2){
						totalAmount = totalAmount + (rental.getDaysRented() -3)* 1.5;
					}
					break;
				case Movie.NEW_RELEASE:
					thisAmount = thisAmount + rental.getDaysRented()* 3;
					break;
				default:
				break;
			}

			// add frequent renter points
			frequentRenterPoints = frequentRenterPoints + 1;
			// add bolus for two day rentals
			if(priceCode == Movie.NEW_RELEASE && rental.getDaysRented() >1){
				frequentRenterPoints = frequentRenterPoints + 1;
			}
			totalAmount = totalAmount + thisAmount;
			// show detail rentals figures
			result = result + "\t"+ rental.getMovie().getTitle() 
							+ "\t"+ totalAmount + "\r\n";
			

		}
		// add footer
		result = result + "\t"+ "Amount owed is : " + totalAmount + "\r\n";
		result = result + "\t"+ "You earned : " + frequentRenterPoints 
						+ " frequent renter points" + "\r\n";
		return result;
	}
}
