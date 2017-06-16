package myjava;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonToJava {

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

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	   return jsonString.toString();
   }
   
   private static List<Example> readFromJson(String jsonString) {
	   
	   Gson gson = new Gson();
	   Type collectionType = new TypeToken<List<Example>>(){}.getType();

	   List<Example> examples = gson.fromJson(jsonString, collectionType);
	   return examples;
   }
   
   private static List<Example> searchFromList(List<Example> examples, String searchString) {
	   
	   List<Example> filteredList = new ArrayList<Example>();
	   
	   for(Example example : examples) {
		   if(example.search(searchString)) {
			   filteredList.add(example);
		   }
	   }
	   
	   return filteredList;
   }
   
   public static void main(String[] args) {
	
	   try {
		   String jsonString = readJsonFile("/home/bridgeit/Downloads/citylist.json");
		   List<Example> examples = readFromJson(jsonString);
		   List<Example> filteredList = searchFromList(examples, "in");
		   Gson gson = new Gson();
		   System.out.println(filteredList.size());
//		   System.out.println(gson.toJson(filteredList));
		   
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

}