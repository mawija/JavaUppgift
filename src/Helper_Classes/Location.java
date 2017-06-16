package Helper_Classes;

public class Location {

	public String City;
	public String Zone;
	public int ZipCode;

	public Location(String city, String zone, int zipCode) {
		City = city;
		Zone = zone;
		ZipCode = zipCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (ZipCode != other.ZipCode)
			return false;
		if (City == null) {
			if (other.City != null)
				return false;
		} else if (!City.equals(other.City))
			return false;
		if (Zone == null) {
			if (other.Zone != null)
				return false;
		} else if (!Zone.equals(other.Zone))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ZipCode;
		result = prime * result + ((City == null) ? 0 : City.hashCode());
		result = prime * result + ((Zone == null) ? 0 : Zone.hashCode());
		return result;
	}
}
