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
	private Continent continent;
	private float surfaceArea;
	private String headOfState;

	public Country(String code, String name, Continent continent, float surfaceArea, String headOfState) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.headOfState = headOfState;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	@Override
	public String toString() {
		return "Country [Code=" + code + ", Name=" + name + ", Continent=" + continent + ", Surface Area=" + surfaceArea
				+ ", Head Of State=" + headOfState + "]";
	}

}
