package pq.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient {

	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private int patientId;
	private int organizationId;

	public Patient(String firstName, String lastName, Date dob, String gender, int patientId, int organizationId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.patientId = patientId;
		this.organizationId=organizationId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientid(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "Patient [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender
				+ ", patientId=" + patientId + ", organizationId=" + organizationId + "]";
	}
	
	

}
