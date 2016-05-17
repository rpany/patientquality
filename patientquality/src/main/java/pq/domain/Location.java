package pq.domain;

public class Location {
	private int locationId;
	private int organizationId;
	private String locationName;
	private String shortName;
	
	
	
	public Location(int locationId, int organizationId, String locationName, String shortName) {
		super();
		this.locationId = locationId;
		this.organizationId = organizationId;
		this.locationName = locationName;
		this.shortName = shortName;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", organizationId=" + organizationId + ", locationName="
				+ locationName + ", shortName=" + shortName + "]";
	}
	
	
	

}
