/**
 * 
 */

/**
 * @author Claudio Santana Student Nr. 2017180
 *
 */
public enum Continent {
	
	//THIS CLASS ENUM WAS CREATED TO MATCH THE ENTRY INPUT BY AN USER 
	//WITH THE VALUES FROM THE DATABASE. SO, IN OTHER WORDS, EVERY VALUE MATCHES 
	//WITH A VALUE FROM THE DATABASE.
	
	ASIA ("Asia"), 
	EUROPE ("Europe"), 
	NORTH_AMERICA ("North America"), 
	AFRICA ("Africa"), 
	OCEANIA ("Oceania"), 
	ANTARCTICA ("Antarctica"), 
	SOUTH_AMERICA ("South America");
	
	private String name;
	
	Continent (String name){	
		this.name = name;
	}
	
	
	//THIS GETTER RETURNS THE VALUE "" OF ENUM TOO MATCH WITH THE VALUES OF THE DATABASE.
	public String getName() {
		return this.name;
	}
	
	//THIS METHOD WAS CREATED IN ORDER TO RETURN THE CORRECT ENUM CONTINENT
	//RELATED TO ANY OF THE ENTRIES FROM THE DATABASE. ONCE THE INPUT HAS BEEN VALIDATED, 
	//THIS METHOD IS NOT BEING USED. FOR TESTS PURPOSES, IT WAS CREATEAD AND WORKS PERFECTLY 
	//IF NECESSARY.
	public static Continent getContinent (String name) {
		
		switch (name) {
		
		case "Asia": return Continent.ASIA;
		case "Europe": return Continent.EUROPE;
		case "North America": return Continent.NORTH_AMERICA;
		case "Africa": return Continent.AFRICA;
		case "Oceania": return Continent.OCEANIA;
		case "Antarctica": return Continent.ANTARCTICA;
		case "South America": return Continent.SOUTH_AMERICA;
		
		}
		return null;
	}

}
