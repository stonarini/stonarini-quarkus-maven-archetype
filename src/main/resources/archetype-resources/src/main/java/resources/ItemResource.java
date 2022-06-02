package ${package}.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ${package}.models.Item;
import ${package}.services.ItemService;

@Path("/item")
public class ItemResource {

    @Inject
    ItemService itemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok(itemService.get()).build();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("name") String name) {
        return Response.ok(itemService.get(name)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Item item) {
        return Response.status(Status.CREATED).entity(itemService.create(item)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Item item) {
        return Response.status(Status.OK).entity(itemService.update(item)).build();
    }

    @DELETE
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("name") String name) {
        itemService.delete(name);
        return Response.ok().build();
    }
}