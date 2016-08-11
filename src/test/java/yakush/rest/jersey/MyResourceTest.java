package yakush.rest.jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class MyResourceTest {

    private static HttpServer server;
    private static WebTarget target;

    @BeforeClass
    public static void setUp() throws Exception {
        // start the server
//        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @AfterClass
    public static void tearDown() throws Exception {
//        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetAsPlain() {
        String responseMsg = target.path("myresource").
                request().
                accept(MediaType.TEXT_PLAIN).
                get(String.class);

        assertEquals("Got it as plain!", responseMsg);
    }

    @Test
    public void testGetAsHTML() {
        String responseMsg = target.path("myresource").
                request(MediaType.TEXT_HTML).
                get(String.class);

        assertEquals("Got it as html!", responseMsg);
    }

    @Test
    public void testGetUserName() {
        String responseMsg = target.path("myresource").
                path("Vitaliy").
                request().
                get(String.class);

        assertEquals("User name is Vitaliy", responseMsg);
    }

    @Test
    public void testsGetParamFromRequestDefault() {
        String responseMsg = target.path("myresource").
                path("param").
                request().
                get(String.class);

        assertEquals("number: 7\n" +
                "string: string\n" +
                "boolean: true", responseMsg);
    }

    @Test
    public void testsGetParamFromRequest() {
        String responseMsg = target.path("myresource").
                path("param")
                .queryParam("int", 5)
                .queryParam("string", "Test")
                .queryParam("boolean", "false")
                .request()
                .get(String.class);

        assertEquals("number: 5\n" +
                "string: Test\n" +
                "boolean: false", responseMsg);
    }

    @Test
    public void testGetContext() {
        String responseMsg = target.path("myresource").
                path("context").
                queryParam("header", "test").
                request().
                header("test", "test").
                get(String.class);

        assertEquals("[test]", responseMsg);
    }

    @Test
    public void testPostForm() {
        Form form = new Form();
        form.param("name", "Vitaliy");
        form.param("age", "27");

        String responseMsg = target.path("myresource").
                request().
                post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

        assertEquals("Name: Vitaliy\n" +
                "Age: 27",
                responseMsg);
    }

    @Test
    public void testPostFormContext() {
        Form form = new Form();
        form.param("name", "Vitaliy");
        form.param("age", "27");

        String responseMsg = target.path("myresource").
                path("context").
                request().
                post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

        assertEquals("{name=[Vitaliy], age=[27]}",
                responseMsg);
    }

}
