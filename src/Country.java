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

	// BUILDER CONSTRUCTOR
	private Country(CountryBuilder builder) {
		this.code = builder.code;
		this.name = builder.name;
		this.continent = builder.continent;
		this.surfaceArea = builder.surfaceArea;
		this.headOfState = builder.headOfState;
	}

	// Specific implementation for Visa
	@Override
	public String toString() {
		return "Country [Code=" + code + ", Name=" + name + ", Continent=" + continent + ", Surface Area=" + surfaceArea
				+ ", Head Of State=" + headOfState + "]";
	}

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

	/*
	 * public void setCode(String code) { this.code = code; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public void setContinent(String continent) { this.continent = continent; }
	 * 
	 * public void setSurfaceArea(float surfaceArea) { this.surfaceArea =
	 * surfaceArea; }
	 * 
	 * public void setHeadOfState(String headOfState) { this.headOfState =
	 * headOfState; }
	 */

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

		public CountryBuilder setCode(String code) {
			this.code = code;
			return this;
		}

		public CountryBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public CountryBuilder setContinent(String continent) {
			this.continent = continent;
			return this;
		}

		public CountryBuilder setSurfaceArea(float surfaceArea) {
			this.surfaceArea = surfaceArea;
			return this;
		}

		public CountryBuilder setHeadOfState(String headOfState) {
			this.headOfState = headOfState;
			return this;
		}

		public Country build() {
			return new Country(this);
		}

	}
}
