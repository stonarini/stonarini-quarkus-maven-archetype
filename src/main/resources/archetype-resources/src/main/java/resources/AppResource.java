package ${package}.resources;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ${package}.entities.Test;
import ${package}.services.TestService;

@Path("/")
public class AppResource {

    @Inject
    TestService ts;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response root() {
        return Response.ok("Test OK Response").build();
    }

    @GET
    @Path("/test/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTest(@PathParam("name") String name) {
        Test test = ts.getTest(name);
        return !test.getName().equals("") ? Response.ok(test).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("/test")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTest(@Valid Test test) {
        test.persist();
        return test != null ? Response.status(Response.Status.CREATED)
                .entity(test).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}