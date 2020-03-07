package za.co.anylytical.showcase.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author: Thabo Lebogang Matjuda
 * @since: 2020-03-07
 * @email: <a href="mailto:thabo@anylytical.co.za">Anylytical Technologies</a>
 * <a href="mailto:tl.matjuda@gmail.com">Personal GMail</a>
 */

@Path("/text")
@Api(value = "/text", tags = "Text API")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {

    @GET
    @ApiOperation(
            value = "Gets a text message",
            notes = "Returns the message as HTTP Resposne",
            response = Response.class)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.status(Response.Status.OK)
                .entity("Hey, there, you requested for text?")
                .build();
    }
}
