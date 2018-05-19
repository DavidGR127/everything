package co.edu.eafit.cec.dipl.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class ReservaService {

	@Path("/vuelos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getVuelos() {
		return "{ \"id\":\"1\" }";
	}
}
