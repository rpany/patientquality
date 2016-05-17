package pq.domain;

public class Result {
	
	private int resultId;
	private int patientId;
	private String bloodculture;
	private String organism;
	
	
	
	public Result(int resultId, int patientId, String bloodculture, String organism) {
		super();
		this.resultId = resultId;
		this.patientId = patientId;
		this.bloodculture = bloodculture;
		this.organism = organism;
	}
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getBloodculture() {
		return bloodculture;
	}
	public void setBloodculture(String bloodculture) {
		this.bloodculture = bloodculture;
	}
	public String getOrganism() {
		return organism;
	}
	public void setOrganism(String organism) {
		this.organism = organism;
	}
	@Override
	public String toString() {
		return "Result [resultId=" + resultId + ", patientId=" + patientId + ", bloodculture=" + bloodculture
				+ ", organism=" + organism + "]";
	}
	
	
	

}
