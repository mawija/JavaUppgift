package Helper_Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Get_Data_From_Input {

	public static List<Location> Read(String file_path) throws FileNotFoundException {
		List<Location> locations = new ArrayList<Location>();

		Scanner reader = new Scanner(new File(file_path), "UTF-8");
		try {
			reader.nextLine();
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				if (!line.isEmpty()) {
					locations.add(createFromLine(line));
				}
			}
		} finally {
			reader.close();
		}
		return locations;
	}
	
	private static Location createFromLine(String line) {
		String splitBy = ",";
		String[] split = line.split(splitBy);

		int zip = Integer.parseInt(split[0]);
		String zone = getZone(zip);

		String city = split[1].toUpperCase();

		return new Location(city, zone, zip);
	}

	private static String getZone(int zip) {

		if (isBetween(zip, 00001, 29999)) {
			return "SEZONE11";
		} else if (isBetween(zip, 30000, 31999)) {
			return "SEZONE21";
		} else if (isBetween(zip, 32000, 39999)) {
			return "SEZONE11";
		} else if (isBetween(zip, 40000, 51999)) {
			return "SEZONE21";
		} else if (isBetween(zip, 52000, 59999)) {
			return "SEZONE11";
		} else if (isBetween(zip, 60000, 61999)) {
			return "SEZONE31";
		} else if (isBetween(zip, 62000, 62999)) {
			return "SEZONE12";
		} else if (isBetween(zip, 63000, 73999)) {
			return "SEZONE31";
		} else if (isBetween(zip, 74000, 74499)) {
			return "SEZONE11";
		} else if (isBetween(zip, 74500, 74599)) {
			return "SEZONE31";
		} else if (isBetween(zip, 74600, 74899)) {
			return "SEZONE11";
		} else if (isBetween(zip, 74900, 74905)) {
			return "SEZONE31";
		} else if (isBetween(zip, 74906, 74906)) {
			return "SEZONE11";
		} else if (isBetween(zip, 74907, 74959)) {
			return "EZONE31";
		} else if (isBetween(zip, 74960, 74963)) {
			return "SEZONE11";
		} else if (isBetween(zip, 74964, 74999)) {
			return "SEZONE31";
		} else if (isBetween(zip, 75000, 76999)) {
			return "SEZONE11";
		} else if (isBetween(zip, 77000, 79999)) {
			return "SEZONE31";
		} else if (isBetween(zip, 80000, 81999)) {
			return "SEZONE11";
		} else if (isBetween(zip, 82000, 82999)) {
			return "SEZONE31";
		} else if (isBetween(zip, 83000, 84999)) {
			return "SEZONE32";
		} else if (isBetween(zip, 85000, 85999)) {
			return "SEZONE31";
		} else if (isBetween(zip, 86000, 99999)) {
			return "SEZONE32";
		} else {
			return "invalid zip";
		}
	}

	private static boolean isBetween(int x, int lower, int upper) {
		return lower <= x && x <= upper;
	}
}
