/**
 * 
 */

/**
 * @author Claudio Santana Student Nr. 2017180
 *
 */
public class Country {
	
	private int id;
	private String name;
	private Continent continent;
	private float surfaceArea;
	private String headOfState;
	
	
	private Country(int id, String name, Continent continent, float surfaceArea, String headOfState) {
		this.id = id;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.headOfState = headOfState;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
		return "Country [Id=" + id + ", Name=" + name + ", Continent=" + continent + ", Surface Area=" + surfaceArea
				+ ", Head Of State=" + headOfState + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
