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

	// METHOD 1: GET ALL COUNTRIES
	@Override
	public ArrayList<Country> getCountries() {
		// CREATE THE ARRAYLIST TO PUT ALL THE COUNTRIES
		// THAT ARE GOING TO BE RETURNED
		ArrayList<Country> countries = new ArrayList<Country>();

		// THIS IS THE METHOD IN CHARGE OF CREATE THE QUERY
		String query = "select * from country";

		// ACCESSING THE DATABASE
		DataSource db = DataSource.getInstance();

		// QUERYING THE DATABASE
		ResultSet rs = db.select(query);

		// LOOP OVER THE RESULT SET
		try {
			while (rs.next()) {
				// FOR EACH ONE OF THE VALUES, WE WANT TO
				// GET THE ATTRIBTUES
				String code = rs.getString(1);
				String name = rs.getString(2);
				String continent = rs.getString(3);
				//Continent continent = Continent.getContinent(rs.getString(3));
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);

				countries.add(new Country(code, name, continent, surfaceArea, headOfState));
			}

			// CLOSING THE CONNECTION TO THE DATABASE
			db.closing();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// RETURN THE ARRAYLIST WITH ALL THE COUNTRIES
		return countries;
	}

	@Override
	public Country findCountryByCode(String code) {
		// CREATING THE OBJECT THAT WE'RE GOING TO RETURN
		Country c = null;

		// THIS METHOD IS IN CHAGE OF CREATING THE QUERY
		String query = "select * FROM country WHERE Code ='" + code + "'";

		// ACCESSING THE DATABASE
		DataSource db = DataSource.getInstance();

		// QUERYING THE DATABASE
		ResultSet rs = db.select(query);

		// WITH THE RESULT GET THE DATA AND PUT IT IN THE INSTANCE
		// OF COUNTRY
		try {
			rs.next();
			String name = rs.getString(2);
			String continent = rs.getString(3);
			//Continent continent = Continent.getContinent(rs.getString(3));
			float surfaceArea = rs.getFloat(4);
			String headOfState = rs.getString(5);

			c = new Country(code, name, continent, surfaceArea, headOfState);

			// CLOSING THE CONNECTION TO THE DATABASE
			db.closing();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// RETURN THE COUNTRY
		return c;
	}

	@Override
	public ArrayList<Country> findCountryByName(String name) {
		// CREATING THE LIST THAT WE'RE GOING TO RETURN
		ArrayList<Country> countries = new ArrayList<Country>();

		// THIS METHOD IS IN CHAGE OF CREATING THE QUERY
		String query = "select * FROM country WHERE Name ='" + name + "'";

		// ACCESSING THE DATABASE
		DataSource db = DataSource.getInstance();

		// QUERYING THE DATABASE
		ResultSet rs = db.select(query);
		

		// WITH THE RESULT GET THE DATA AND PUT IT IN THE INSTANCE
		// OF COUNTRY
		// LOOP OVER THE RESULT SET
		try {
			while (rs.next()) {
				// FOR EACH ONE OF THE VALUES, WE WANT TO
				// GET THE ATTRIBTUES
				String code = rs.getString(1);
				String continent = rs.getString(3);
				//Continent continent = Continent.getContinent(rs.getString(3));
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);

				countries.add(new Country(code, name, continent, surfaceArea, headOfState));
			}

			// CLOSING THE CONNECTION TO THE DATABASE
			db.closing();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// RETURN THE ARRAYLIST WITH ALL THE COUNTRIES
		return countries;
	}

	@Override
	public boolean saveCountry(Country country) {
		// ACCESSING THE DATABASE
		DataSource db = DataSource.getInstance();

		// FROM THE OBJECT, GETTING THE DATA
		String code = country.getCode();
		String name = country.getName();
		String continent = country.getContinent();
		float surfaceArea = country.getSurfaceArea();
		String headOfState = country.getHeadOfState();

		// THIS METHOD IS IN CHARGE OF CREATING THE QUERY
		String query = "insert into country (Code, Name, Continent, SurfaceArea, HeadOfState) values ('" + code + "', '"
				+ name + "', '" + continent + "', " + surfaceArea + ", '" + headOfState + "')";

		// REQUESTION TO SAVE THE DATA
		boolean result = db.save(query);

		// CLOSING THE DATABASE
		db.closing();

		return result;
	}

}
