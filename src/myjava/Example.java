
package myjava;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("country")
	@Expose
	private String country;
	@SerializedName("coord")
	@Expose
	private Coord coord;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Example() {
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
	public Example(Integer id, String name, String country, Coord coord) {
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
		
		return (country.contains(searchString));
		
	}

}