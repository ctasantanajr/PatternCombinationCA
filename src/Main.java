import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Claudio Santana Student Nr. 2017180
 *
 */
public class Main {

	static Scanner sc = new Scanner(System.in);
	static Boolean run = true;
	static ArrayList<Country> countries = new ArrayList<Country>();
	static Country c = null;
	static CountryDAO db = null;

	Main() {

		// NOW THE CLIENT DOES NOT ACCESS THE DATABASE CLASS DIRECTLY.
		// THE CLIENT WILL ONLY TALK TO THE COUNTRYDAO AND ALL DATA IS GOING
		// TO BE PASSED TROUGH COUNTRYS OBJECTS
		db = new MySQLCountryDAO();

		Welcome();

		// this while loop builds up the menu of the system, utilising the I/O class
		// scanner to receive the input from the user
		while (run) {

			System.out.println();
			System.out.println("**********************************************************************");
			System.out.println("              Please Select From The Following Options:               ");
			System.out.println("**********************************************************************");

			System.out.println("Enter 1 to list all countries");
			System.out.println("Enter 2 to search a country by code");
			System.out.println("Enter 3 to search a country by name");
			System.out.println("Enter 4 to save a new country");
			System.out.println("Enter 5 to quit without saving");

			String answer = "";

			// IN THIS POINT THE PROGRAM WILL VALIDATE THE OPTION ENTERED BY USER
			try {
				boolean valid = false;
				do {
					answer = sc.next();
					valid = ValidateMenuOption(answer);
				} while (valid == false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error reading input");
			}

			// this conditional switch executes blocks of methods in regards to the option
			// typed by the user. After executing the whole block of commands it breaks and
			// print off the option menu again
			switch (answer) {

			case "1":

				GetAllCountries();
				break;

			case "2":

				FindCountryByCode();
				break;

			case "3":

				// GETTING ONLY THE COUNTRY THAT HAS THE GIVEN
				// NAME
				countries = db.findCountryByName("Test");

				// PRINTING IT TO THE CONSOLE
				for (Country c : countries) {
					System.out.println(c);
				}
				break;

			case "4":

				// CREATING A NEW COUNTRY. KEEP IN MIND THAT
				// THE ID OF THE NEW COUNTRY IS GOING TO BE THE
				// SIZE OF THE ARRAY PLUS ONE
				Country newCountry = new Country("TXX", "Test", Continent.EUROPE, (float) 12345.87, "Heaven");

				// ADDING THE COUNTRY TO THE ARRAY, TO HAVE LOCAL
				// CONTROL OF THE DATA
				countries.add(newCountry);
				// ADDING THE NEW COUNTRY INTO THE DATABASE
				System.out.println(db.saveCountry(newCountry));
				break;

			case "5":
				EndProgram();
				break;

			}
		}
		System.exit(0);

	}

	// ------------------------------------------------------------------
	// METHOD TO VALIDATE THE OPTION ENTERED BY USER
	// ------------------------------------------------------------------

	private boolean ValidateMenuOption(String answer) {
		// TODO Auto-generated method stub

		boolean valid = false;

		if (answer.matches("[0-9]+")) {
			if (Integer.parseInt(answer) == 1 || Integer.parseInt(answer) == 2 || Integer.parseInt(answer) == 3
					|| Integer.parseInt(answer) == 4 || Integer.parseInt(answer) == 5) {
				valid = true;

			} else {
				valid = false;
				System.out.println("Invalid option. Please try again!");
			}

		} else {

			System.out.println("Please choose one of the options!");
		}

		return valid;

	}

	// ------------------------------------------------------------------
	// ENDING THE PROGRAM
	// ------------------------------------------------------------------

	public static void EndProgram() {

		System.out.println("Bye!");
		System.exit(0);

	}

	// --------------------------------------------------------------------
	// METHOD TO WELCOME USER
	// --------------------------------------------------------------------

	private static void Welcome() {
		// TODO Auto-generated method stub
		System.out.println("\nWelcome!");
		System.out.println();

	}

	// --------------------------------------------------------------------
	// METHOD TO GET ALL COUNTRIES FROM DATABASE
	// --------------------------------------------------------------------

	private static void GetAllCountries() {

		// GETTING ALL OF THE COUNTRYS IN THE DATABASE
		countries = db.getCountries();

		// PRINTING THEM TO THE CONSOLE

		for (Country c : countries) {
			System.out.println(c);
		}

	}

	// --------------------------------------------------------------------
	// METHOD TO FIND A COUNTRY BY ITS CODE
	// --------------------------------------------------------------------

	private static void FindCountryByCode() {

		String code = "";
		System.out.println("Please inform the code: ");

		try {
			
			do {

				code = sc.next();

				if (code.length() == 3) {

					// GETTING ONLY THE COUNTRY THAT HAS THE GIVEN CODE
					c = db.findCountryByCode(code);

					// PRINTING IT TO THE CONSOLE
					System.out.println(c);

				} else {

					System.out.println("Please inform a code of 3 digits: ");

				}

			} while (code.length() != 3);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Problem finding a country by code");
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main();

	}

}
