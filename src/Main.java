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

	// THIS VARIABLES ARE GLOBAL, TO BE ACCESSED FROM ANY OF THE METHODS
	static Scanner sc = new Scanner(System.in);
	static Boolean run = true;
	static ArrayList<Country> countries = new ArrayList<Country>();
	static Country c = null;
	static CountryDAO db = null;

	Main() {

		// NOW THE CLIENT DOES NOT ACCESS THE DATABASE CLASS DIRECTLY.
		// THE CLIENT WILL ONLY TALK TO THE COUNTRYDAO AND ALL DATA IS GOING
		// TO BE PASSED TROUGH COUNTRY OBJECTS
		db = new MySQLCountryDAO();

		// call the method that welcomes the user
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

			// IN THIS POINT THE PROGRAM WILL VALIDATE THE OPTION ENTERED BY USER
			String answer = ValidateMenuOption();

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

				FindCountryByName();
				break;

			case "4":

				AddCountry();
				break;

			case "5":
				db.CloseDatabase();
				EndProgram();
				break;

			}
		}
		System.exit(0);

	}

	// ------------------------------------------------------------------
	// METHOD TO VALIDATE THE OPTION ENTERED BY USER
	// ------------------------------------------------------------------

	private String ValidateMenuOption() {
		// TODO Auto-generated method stub

		boolean valid = false;
		String answer = "";

		try {

			do {

				answer = sc.next();

				// THIS IF STATEMENT VALIDATES IF THE INPUT MADE BY THE USER IS NUMERIC
				// AND A VALID OPTION
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

			} while (valid == false);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Error reading menu option input");
		}

		return answer;

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

		System.out.println("Please inform the code: ");

		String code = ValidateCode();

		// GETTING ONLY THE COUNTRY THAT HAS THE GIVEN CODE
		c = db.findCountryByCode(code);

		if (c != null) {
			// PRINTING IT TO THE CONSOLE IF FOUND A COUNTRY
			System.out.println(c);
		}

	}

	// --------------------------------------------------------------------
	// METHOD TO FIND A COUNTRY BY ITS NAME
	// --------------------------------------------------------------------

	private static void FindCountryByName() {

		System.out.println("Please inform the name: ");
		String name = sc.next();

		// GETTING ALL THE COUNTRIES THAT HAVE THE GIVEN NAME
		countries = db.findCountryByName(name);

		// PRINTING IT TO THE CONSOLE
		for (Country c : countries) {
			System.out.println(c);
		}

	}

	// --------------------------------------------------------------------
	// METHOD TO VALIDATE THE LENGTH OF A CODE ENTERED BY USER
	// --------------------------------------------------------------------

	private static String ValidateCode() {

		String code = "";

		try {

			do {

				code = sc.next();

				if (code.length() != 3) {

					System.out.println("Please inform a code of 3 digits: ");

				}

			} while (code.length() != 3);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error reading input code");
		}

		// Using this method to converts all of the
		// characters in this String to upper case
		return code.toUpperCase();

	}

	// ---------------------------------------------------------------------------
	// METHOD TO MATCH A CONTINENT TO THE ENUM - VALIDATION
	// ---------------------------------------------------------------------------

	private static Continent ValidateContinent() {

		Continent continent = null;

		try {

			boolean valid = false;

			do {

				String option = sc.next();

				// THIS IF STATEMENT VALIDATES IF THE INPUT MADE BY THE USER IS NUMERIC
				// AND A VALID OPTION
				if (option.matches("[0-9]+")) {
					if (Integer.parseInt(option) == 1 || Integer.parseInt(option) == 2 || Integer.parseInt(option) == 3
							|| Integer.parseInt(option) == 4 || Integer.parseInt(option) == 5
							|| Integer.parseInt(option) == 6 || Integer.parseInt(option) == 7) {
						valid = true;

						switch (option) {

						case "1":
							continent = Continent.ASIA;
							break;
						case "2":
							continent = Continent.EUROPE;
							break;
						case "3":
							continent = Continent.NORTH_AMERICA;
							break;
						case "4":
							continent = Continent.AFRICA;
							break;
						case "5":
							continent = Continent.OCEANIA;
							break;
						case "6":
							continent = Continent.ANTARCTICA;
							break;
						case "7":
							continent = Continent.SOUTH_AMERICA;
							break;

						}

					} else {
						valid = false;
						System.out.println("Invalid option");
					}
				}

			} while (valid == false);

		} catch (Exception e) {
			System.out.println("Error reading input");
		}

		return continent;

	}

	// --------------------------------------------------------------------
	// METHOD TO ADD A NEW COUNTRY
	// --------------------------------------------------------------------

	private static void AddCountry() {

		System.out.println("Enter a code (3 characters): ");
		String code = ValidateCode();

		System.out.println("Enter a name: ");
		String name = sc.next();

		System.out.println("Choose a Continent:\n 1-Asia \n 2-Europe \n 3-North America \n 4-Africa "
				+ "\n 5-Oceania \n 6-Antarctica \n 7-South America");
		Continent continent = ValidateContinent();

		System.out.println("Enter a surface area: ");
		float area = sc.nextFloat();

		System.out.println("Enter a head of state: ");
		String state = sc.next();

		// CREATING A NEW OBJECT "COUNTRY" FOLLOWING THE BUILDER PATTERN
		Country.CountryBuilder builder = new Country.CountryBuilder(code, name, continent.getName(), area, state);

		// ADDING THE COUNTRY TO THE ARRAY, TO HAVE LOCAL
		// CONTROL OF THE DATA
		countries.add(builder.build());

		// ADDING THE NEW COUNTRY INTO THE DATABASE
		boolean result = db.saveCountry(builder.build());

		if (result == true) {
			System.out.println("Country added successfully!");
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
