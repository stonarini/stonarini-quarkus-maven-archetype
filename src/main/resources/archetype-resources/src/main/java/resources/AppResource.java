package ${package}.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class AppResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String app() {
        return "Quarkus is working!";
    }
}