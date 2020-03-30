import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Claudio Santana Student Nr. 2017180
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// NOW THE CLIENT DOES NOT HAVE ANYTHING TO DO
		// THE THE DATABASE CLASS.
		// THE CLIENT WILL ONLY TALK TO THE CUSTOMERDAO
		// IN TERMS OF CUSTOMER
		// IN OTHER WORDS, THE PASSING OF DATA IS GOING
		// TO BE CUSTOMERS OBJECTS
		CountryDAO db = new MySQLCountryDAO();

		// GETTING ALL OF THE CUSTOMERS IN THE DATABASE
		ArrayList<Country> countries = db.getCountries();

		// PRINTING THEM TO THE CONSOLE
		for (Country c : countries) {
			System.out.println(c);
		}

		// GETTING ONLY THE CUSTOMER THAT HAS THE GIVEN
		// ID
		//Country c = db.findCountryByCode("BHS");

		// PRINTING IT TO THE CONSOLE
		//System.out.println(c);

		// CREATING A NEW CUSTOMER. KEEP IN MIND THAT
		// THE ID OF THE NEW CUSTOMER IS GOING TO BE THE
		// SIZE OF THE ARRAY PLUS ONE
		//Country newCountry = new Country("TTT", "Test", Continent.EUROPE, (float) 12345.87, "Heaven");

		// ADDING THE CUSTOMER TO THE ARRAY, TO HAVE LOCAL
		// CONTROL OF THE DATA
		//countries.add(newCountry);
		// ADDING THE NEW CUSTOMER INTO THE DATABASE
		//System.out.println(db.saveCountry(newCountry));

	}

}
