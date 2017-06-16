
package GoogleMaps.model;

public class City {

	private Integer id;
	private String name;
	private String country;
	private Coord coord;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public City() {
	}

	@Override
	public String toString() {
		return "Example [id=" + id + ", name=" + name + ", country=" + country + ", coord=" + coord + "]";
	}

	/**
	 * 
	 * @param coord
	 * @param id
	 * @param name
	 * @param country
	 */
	public City(Integer id, String name, String country, Coord coord) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.coord = coord;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	
	public boolean search(String searchString) {
		
		return (name.toUpperCase().startsWith(searchString.toUpperCase()));
		
	}

}