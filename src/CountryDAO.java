import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Claudio Santana Student Nr. 2017180
 *
 */
public interface CountryDAO {
	
	public ArrayList<Country> getCountries();
	public Country findCountryById(int id);
	public Country findCountryByName(String name);
	public boolean saveCountry(Country country);
	

}