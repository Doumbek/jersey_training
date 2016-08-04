package yakush.rest.jersey;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Map;

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

    @GET
    @Path("param")
    public String getParamFromRequest(
            @DefaultValue("7") @QueryParam("int") int number,
            @DefaultValue("string") @QueryParam("string") String string,
            @DefaultValue("true") @QueryParam("boolean") Boolean bool) {

        return "number: " + number +
                "\nstring: " + string +
                "\nboolean: " + bool;

    }

    @GET
    @Path("context")
    public String getContext(@Context HttpHeaders hh,
                             @QueryParam("header") String header) {

        MultivaluedMap<String, String> headers = hh.getRequestHeaders();
        Map<String, Cookie> cookies = hh.getCookies();

        return headers.get(header).toString();

    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String postForm(
            @FormParam("name") String name,
            @FormParam("age") int age) {

        return "Name: " + name +
                "\nAge: " + age;
    }

    @POST
    @Path("context")
    @Consumes("application/x-www-form-urlencoded")
    public String postForm(MultivaluedMap<String, String> formParams) {

        return formParams.toString();

    }
}
