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
	public Country findCountryByCode(String code);
	public ArrayList<Country> findCountryByName(String name);
	public boolean saveCountry(Country country);
	public void CloseDatabase();
	

}
