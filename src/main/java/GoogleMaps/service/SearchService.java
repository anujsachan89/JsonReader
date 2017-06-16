package GoogleMaps.service;

import java.util.List;

import GoogleMaps.model.City;

public interface SearchService {

	 public  List<City> searchCities(String searchString);
}