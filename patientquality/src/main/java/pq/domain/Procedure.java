package pq.domain;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class Procedure {
	private int procedureId;
	private int patientId;
	private String procedureName;
	private int locationId;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date startTime;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date removeTime;
	public Procedure(int procedureId, int patientId, String procedureName, int locationId, Date startTime, Date removeTime) {
		super();
		this.procedureId = procedureId;
		this.patientId = patientId;
		this.procedureName = procedureName;
		this.startTime = startTime;
		this.removeTime = removeTime;
		this.locationId=locationId;
	}
	public int getProcedureId() {
		return procedureId;
	}
	public void setProcedureId(int procedureId) {
		this.procedureId = procedureId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getProcedureName() {
		return procedureName;
	}
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getRemoveTime() {
		return removeTime;
	}
	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}
	
	
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "Procedure [procedureId=" + procedureId + ", patientId=" + patientId + ", procedureName=" + procedureName
				+ ", startTime=" + startTime + ", removeTime=" + removeTime + "]";
	}
	
	
	
	
}
