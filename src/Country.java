/**
 * 
 */

/**
 * @author Claudio Santana Student Nr. 2017180
 *
 */
public class Country {

	private String code;
	private String name;
	private String continent;
	private float surfaceArea;
	private String headOfState;

	//CONSTRUCTOR - following Builder Pattern
	private Country(CountryBuilder builder) {
		this.code = builder.code;
		this.name = builder.name;
		this.continent = builder.continent;
		this.surfaceArea = builder.surfaceArea;
		this.headOfState = builder.headOfState;
	}

	//METHOD TO DISPLAY ALL PARAMETERS OF A COUNTRY
	@Override
	public String toString() {
		return "Country [Code=" + code + ", Name=" + name + ", Continent=" + continent + ", Surface Area=" + surfaceArea
				+ ", Head Of State=" + headOfState + "]";
	}

	//GETTERS
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getContinent() {
		return continent;
	}

	public float getSurfaceArea() {
		return surfaceArea;
	}

	public String getHeadOfState() {
		return headOfState;
	}


	//INNER CLASS - Static class builder
	public static class CountryBuilder {

		private String code;
		private String name;
		private String continent;
		private float surfaceArea;
		private String headOfState;

		public CountryBuilder(String code, String name, String continent, float surfaceArea, String headOfState) {
			this.code = code;
			this.name = name;
			this.continent = continent;
			this.surfaceArea = surfaceArea;
			this.headOfState = headOfState;
		}

	
		// build method to deal with outer class 
        // to return outer instance 
		public Country build() {
			return new Country(this);
		}

	}
}
