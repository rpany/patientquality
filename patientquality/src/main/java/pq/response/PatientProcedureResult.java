package pq.response;

import pq.domain.Location;
import pq.domain.Patient;
import pq.domain.Procedure;
import pq.domain.Result;

public class PatientProcedureResult {
	private Patient patient;
	private Procedure procedure;
	private Location location;
	private Result result;
	public PatientProcedureResult(Patient patient, Procedure procedure, Location location, Result result) {
		super();
		this.patient = patient;
		this.procedure = procedure;
		this.location = location;
		this.result = result;
	}
	
	
	

}
