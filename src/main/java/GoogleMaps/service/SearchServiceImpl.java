package GoogleMaps.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import GoogleMaps.model.City;

@Service
public class SearchServiceImpl implements SearchService {

	private static String readJsonFile(String filePath) {
		BufferedReader br = null;
		FileReader fr = null;
		StringBuffer jsonString = new StringBuffer();


		try {

			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(filePath));

			int lineCount = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				jsonString.append(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} 
			catch (IOException ex) {

				ex.printStackTrace();

			}

		}

		return jsonString.toString();
	}

	private static List<City> readFromJson(String jsonString) {

		Gson gson = new Gson();
		Type collectionType = new TypeToken<List<City>>(){}.getType();

		List<City> examples = gson.fromJson(jsonString, collectionType);
		return examples;
	}

	private  static List<City> searchFromList(List<City> examples, String searchString) {

		List<City> filteredList = new ArrayList<City>();

		for(City example : examples) {
			if(example.search(searchString)) {
				filteredList.add(example);
			}
		}

		return filteredList;
	}

	public List<City> searchCities(String searchString) {

		String jsonString = null;
		List<City> examples = null;
		List<City> filteredList = null;

		try {
			jsonString = readJsonFile("/home/bridgeit/Downloads/citylist.json");
			examples = readFromJson(jsonString);
			filteredList = searchFromList(examples, searchString);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return filteredList;

	}
}