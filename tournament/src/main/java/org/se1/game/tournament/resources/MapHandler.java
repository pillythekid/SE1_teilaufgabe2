package org.se1.game.tournament.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;

@Path("/map")
public class MapHandler {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages() {
		return "ASDF";
	}

}
