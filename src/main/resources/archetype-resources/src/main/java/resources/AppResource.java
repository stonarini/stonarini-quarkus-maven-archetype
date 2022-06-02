package ${package}.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class AppResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response root() {
        return Response.ok("Test OK Response").build();
    }

}
