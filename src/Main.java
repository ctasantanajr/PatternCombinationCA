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
		// THE CLIENT WILL ONLY TALK TO THE COUNTRYDAO
		// IN TERMS OF COUNTRY
		// IN OTHER WORDS, THE PASSING OF DATA IS GOING
		// TO BE COUNTRYS OBJECTS
		CountryDAO db = new MySQLCountryDAO();

		// GETTING ALL OF THE COUNTRYS IN THE DATABASE
		ArrayList<Country> countries = db.getCountries();

		// PRINTING THEM TO THE CONSOLE
		/*for (Country c : countries) {
			System.out.println(c);
		}*/

		// GETTING ONLY THE COUNTRY THAT HAS THE GIVEN
		// ID
		//Country c = db.findCountryByCode("BHS");

		// PRINTING IT TO THE CONSOLE
		//System.out.println(c);

		// CREATING A NEW COUNTRY. KEEP IN MIND THAT
		// THE ID OF THE NEW COUNTRY IS GOING TO BE THE
		// SIZE OF THE ARRAY PLUS ONE
		Country newCountry = new Country("TXT", "Test", Continent.EUROPE, (float) 12345.87, "Heaven");

		// ADDING THE COUNTRY TO THE ARRAY, TO HAVE LOCAL
		// CONTROL OF THE DATA
		countries.add(newCountry);
		// ADDING THE NEW COUNTRY INTO THE DATABASE
		System.out.println(db.saveCountry(newCountry));

	}

}
