import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Helper_Classes.Location;
import Helper_Classes.Get_Data_From_Input;
import Helper_Classes.CreateXml;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		//Read in locations from file
		String file_path = "src/Helper_Classes/indata.txt";
		List<Location> locations = Get_Data_From_Input.Read(file_path);

		// Remove duplicates
		Set<Location> s = new HashSet<Location>();
		s.addAll(locations);
		locations = new ArrayList<Location>();
		locations.addAll(s);

		// Sorting
		Collections.sort(locations, new Comparator<Location>() {
			@Override
			public int compare(Location loc1, Location loc2) {
				return Integer.compare(loc1.ZipCode, loc2.ZipCode);
			}
		});

		// for(Location loc: locations){
		// System.out.print(loc.ZipCode + ", ");
		// System.out.print(loc.Zone + ", ");
		// System.out.print(loc.City);
		// System.out.println();
		// }

		// Create XML file
		CreateXml.CreateXMLFile(locations);

		System.out.println("Done");
	}
}
