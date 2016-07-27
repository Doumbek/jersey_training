package yakush.rest.jersey;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Produces(MediaType.TEXT_PLAIN)
public class MyResource {

    @GET
    public String getAsPlain() {
        return "Got it as plain!";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAsHTML() {
        return "Got it as html!";
    }

    @GET
    @Path("{userName: [a-zA-Z]*}")
    public String getUserName(@PathParam("userName") String username) {

        return "User name is " + username;

    }

}
