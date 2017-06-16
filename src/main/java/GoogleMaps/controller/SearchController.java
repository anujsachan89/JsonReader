package GoogleMaps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import GoogleMaps.model.City;
import GoogleMaps.service.SearchService;

@RestController
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	@RequestMapping("/countries")
	public List<City> getallcountries(@RequestParam("searchString") String searchString ){
		
		return searchService.searchCities(searchString);
	}
		
    
    
    
    
    
    
    
   /* public static void main(String[] args) {
    	
 	   try {
 		   String jsonString = readJsonFile("/home/bridgeit/Downloads/citylist.json");
 		   List<City> examples = readFromJson(jsonString);
 		   List<City> filteredList = searchFromList(examples, "IN");
 		   Gson gson = new Gson();
 		   System.out.println(filteredList.size());
// 		   System.out.println(gson.toJson(filteredList));
 		   
 		   
 	} catch (Exception e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
    }
*/
   
}

