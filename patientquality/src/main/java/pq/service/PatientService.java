package pq.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pq.data.LocationDAO;
import pq.data.PatientDAO;
import pq.data.ProcedureDAO;
import pq.data.ResultDAO;
import pq.data.TokenDAO;
import pq.data.UserDAO;
import pq.domain.Location;
import pq.domain.Patient;
import pq.domain.Procedure;
import pq.domain.Result;
import pq.domain.Token;
import pq.response.PatientProcedureResult;
import pq.rest.AuthenticationRestService;

public class PatientService {
	private static final Logger log = Logger.getLogger(PatientService.class);

	/**
	 * This function returns the list of procedures for a given organiation
	 * @param token
	 * @return
	 */
	public List<PatientProcedureResult> getAllQualityIssuesForOrganization(String token){
		TokenDAO tokendao = new TokenDAO();
		Token tk = tokendao.getToken(token);
		int userId = tk.getUserId();
		UserDAO userdao = new UserDAO();
		int organizationId = userdao.getByUserId(userId).getOrganizationId();
		ProcedureDAO proceduredao = new ProcedureDAO();
		List<Procedure> procedures = proceduredao.getProceduresByOrganizationId(organizationId);
		
		List<PatientProcedureResult> outputs = new ArrayList<PatientProcedureResult>();
		
		for(Procedure p: procedures){
			Location location = new LocationDAO().getById(p.getLocationId());
			log.debug(location);
			Patient patient = new PatientDAO().getById(p.getPatientId());
			log.debug(patient);
			Result result = new ResultDAO().getByResultDate(p.getStartTime(), p.getPatientId());
			log.debug(result);
			PatientProcedureResult ppr = new PatientProcedureResult(patient, p, location, result);
			outputs.add(ppr);
		}
		
		return outputs;
		
	}
}
