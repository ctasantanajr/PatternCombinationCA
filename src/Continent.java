/**
 * 
 */

/**
 * @author Claudio Santana Student Nr. 2017180
 *
 */
public enum Continent {
	
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
	
	public String getName() {
		return this.name;
	}
	
	public static Continent getContinent (String name) {
		//Continent returnContinent = null;
		
		
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
