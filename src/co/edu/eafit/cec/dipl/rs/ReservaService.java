package co.edu.eafit.cec.dipl.rs;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import co.edu.eafit.cec.dipl.rs.dto.ConsultaVueloDTO;
import co.edu.eafit.cec.dipl.rs.entidades.Vuelo;
import co.edu.eafit.cec.dipl.rs.usecases.ConsultarVuelosUseCase;

@Path("/rest")
public class ReservaService {

	@Path("/vuelos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vuelo> getVuelos(@Context UriInfo info) {
		
		MultivaluedMap<String, String> queryString = info.getQueryParameters();
		
		String origen =  (String) queryString.getFirst("origen");
		String destino = (String) queryString.getFirst("destino");
		String fecha = (String) queryString.getFirst("fecha");
		
		System.out.println("Buscando origen " + origen);
		System.out.println("Buscando destino " + destino);
		System.out.println("Buscando fecha " + fecha);
		
		ConsultaVueloDTO parametros = new ConsultaVueloDTO();
		parametros.setDestino(destino);
		parametros.setOrigen(origen);
		parametros.setFecha(new Date(1526706000000l));
		
		ConsultarVuelosUseCase casoUso = new ConsultarVuelosUseCase();
		List<Vuelo> resultado = casoUso.obtenerVuelos(parametros);
		
		return resultado;
	}
}
