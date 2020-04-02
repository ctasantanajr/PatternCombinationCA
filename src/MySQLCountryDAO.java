import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Claudio Santana Student Nr. 2017180
 *
 */
public class MySQLCountryDAO implements CountryDAO {

	// METHOD TO GET ALL COUNTRIES
	@Override
	public ArrayList<Country> getCountries() {
		// CREATE THE ARRAYLIST THAT RECEIVES ALL COUNTRIES TO BE RETURNED
		ArrayList<Country> countries = new ArrayList<Country>();

		// THIS VARIABLE STORAGES THE QUERY
		String query = "select * from country";

		// ACCESSING THE DATABASE - USING SINGLETON PATTERN
		// IN THIS CASE THERE IS NO NEED TO CREATE A NEW OBJECT, INSTEAD AN INSTANCE IS
		// RETURNED.
		DataSourceSingleton db = DataSourceSingleton.getInstance();

		// QUERYING THE DATABASE
		ResultSet rs = db.select(query);

		// LOOP OVER THE RESULT SET
		try {
			while (rs.next()) {
				// GET THE VALUE FROM EACH ATTRIBUTE OF THE DATABASE
				// PS. THE FIRST ATTRIBUTE ALWAYS STARTS FROM THE NUMBER 1.
				String code = rs.getString(1);
				String name = rs.getString(2);
				String continent = rs.getString(3);
				// Continent continent = Continent.getContinent(rs.getString(3));
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);

				// CREATING A NEW OBJECT "COUNTRY" FOLLOWING THE BUILDER PATTERN
				Country.CountryBuilder builder = new Country.CountryBuilder(code, name, continent, surfaceArea,
						headOfState);
				countries.add(builder.build());

			}

			// db.closing();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// RETURN THE ARRAYLIST WITH ALL THE COUNTRIES
		return countries;
	}

	// THIS METHOD IS CALLED TO FIND A COUNTRY BY ITS CODE
	@Override
	public Country findCountryByCode(String code) {
		// CREATING THE OBJECT THAT IS GOING TO BE RETURNED
		Country c = null;

		// THIS VARIABLE STORAGES THE QUERY
		String query = "select * FROM country WHERE Code ='" + code + "'";

		// ACCESSING THE DATABASE - USING SINGLETON PATTERN
		// IN THIS CASE THERE IS NO NEED TO CREATE A NEW OBJECT, INSTEAD AN INSTANCE IS
		// RETURNED.
		DataSourceSingleton db = DataSourceSingleton.getInstance();

		// QUERYING THE DATABASE
		ResultSet rs = db.select(query);

		// GET THE VALUE FROM EACH ATTRIBUTE OF THE DATABASE
		// PS. THE FIRST ATTRIBUTE IS CODE (NUMBER 1) SO THE FOLLOWING ONE SHOULD STARTS
		// NUMBER 2.
		try {
			rs.next();
			String name = rs.getString(2);
			String continent = rs.getString(3);
			// Continent continent = Continent.getContinent(rs.getString(3));
			float surfaceArea = rs.getFloat(4);
			String headOfState = rs.getString(5);

			// CREATING A NEW OBJECT "COUNTRY" FOLLOWING THE BUILDER PATTERN
			Country.CountryBuilder builder = new Country.CountryBuilder(code, name, continent, surfaceArea,
					headOfState);
			c = builder.build();

			// db.closing();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Country not found!");
		}

		// RETURN THE COUNTRY FOUND
		return c;
	}

	// THIS METHOD FIND A COUNTRY BY ITS NAME
	@Override
	public ArrayList<Country> findCountryByName(String name) {
		// IN CASE OF HAVING MORE THAN ONE COUNTRY WITH THE SAME NAME IN THE DATABASE,
		// THIS ARRAYLIST WAS CREATED.
		// PS. THE DATABASE DOES NOT CONSISTS COUNTRY'S NAME, THAT IS WHY.
		ArrayList<Country> countries = new ArrayList<Country>();

		// THIS VARIABLE STORAGES THE QUERY
		String query = "select * FROM country WHERE Name ='" + name + "'";

		// ACCESSING THE DATABASE - USING SINGLETON PATTERN
		// IN THIS CASE THERE IS NO NEED TO CREATE A NEW OBJECT, INSTEAD AN INSTANCE IS
		// RETURNED.
		DataSourceSingleton db = DataSourceSingleton.getInstance();

		// QUERYING THE DATABASE
		ResultSet rs = db.select(query);

		// LOOP OVER THE RESULT SET, GETTING THE RESULT FROM THE DATABASE
		// AND SETTING IN THE INSTANCE OF COUNTRY
		try {
			while (rs.next()) {
				// GET THE VALUE FROM EACH ATTRIBUTE OF THE DATABASE
				// PS. NAME IS THE SECOND ATTRIBUTE IN THE DATABASE SO WE JUST NEED TO SET THE
				// OTHERS
				String code = rs.getString(1);
				String continent = rs.getString(3);
				// Continent continent = Continent.getContinent(rs.getString(3));
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);

				// CREATING A NEW OBJECT "COUNTRY" FOLLOWING THE BUILDER PATTERN
				Country.CountryBuilder builder = new Country.CountryBuilder(code, name, continent, surfaceArea,
						headOfState);
				countries.add(builder.build());

			}

			// db.closing();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// RETURN THE ARRAYLIST WITH ALL THE COUNTRIES
		return countries;
	}

	// THIS METHOD ADD A NEW COUNTRY TO THE DATABASE
	@Override
	public boolean saveCountry(Country country) {

		// ACCESSING THE DATABASE - USING SINGLETON PATTERN
		// IN THIS CASE THERE IS NO NEED TO CREATE A NEW OBJECT, INSTEAD AN INSTANCE IS
		// RETURNED.
		DataSourceSingleton db = DataSourceSingleton.getInstance();

		// FROM THE OBJECT, GETTING THE DATA
		String code = country.getCode();
		String name = country.getName();
		String continent = country.getContinent();
		float surfaceArea = country.getSurfaceArea();
		String headOfState = country.getHeadOfState();

		// THIS VARIABLE STORAGES THE QUERY
		String query = "insert into country (Code, Name, Continent, SurfaceArea, HeadOfState) values ('" + code + "', '"
				+ name + "', '" + continent + "', " + surfaceArea + ", '" + headOfState + "')";

		// REQUESTION TO SAVE THE DATA
		boolean result = db.save(query);

		// db.closing();

		return result;
	}

	// THIS METHOD CLOSES THE INSTANCE OF THE DATABASE THAT WAS CREATED WHEN
	// THE USER ENDS THE APLICATION
	@Override
	public void CloseDatabase() {
		// TODO Auto-generated method stub

		// ACCESSING THE DATABASE - USING SINGLETON PATTERN
		// IN THIS CASE THERE IS NO NEED TO CREATE A NEW OBJECT, INSTEAD AN INSTANCE IS
		// RETURNED.
		DataSourceSingleton db = DataSourceSingleton.getInstance();
		// CLOSING THE DATABASE
		db.closing();

	}

}
