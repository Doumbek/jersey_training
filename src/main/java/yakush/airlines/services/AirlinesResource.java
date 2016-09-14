package yakush.airlines.services;

import yakush.airlines.parks.PassengerPlanesPark;
import yakush.airlines.planes.PassengerPlanes;
import yakush.airlines.utils.Search;
import yakush.airlines.utils.Sort;
import yakush.airlines.utils.comporator.sort.ByModelComporator;
import yakush.airlines.utils.comporator.sort.ByRangeComporator;
import yakush.airlines.utils.io.UtilsIO;
import yakush.airlines.utils.reader.TxtFileReader;
import yakush.airlines.utils.reader.XmlFileReader;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.Set;

@Path("airlines")
public class AirlinesResource {

    private static PassengerPlanesPark passengerPlanesPark = new PassengerPlanesPark();

    @GET
    @Path("info")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllPlanesAsString() {
        return passengerPlanesPark.toString();
    }

    @GET
    @Path("common/load")
    public int getCommonLoadCapacity() {
        return passengerPlanesPark.getCommonLoadCapacity();
    }

    @GET
    @Path("common/passangers")
    public int getCommonPassCapacity() {
        return passengerPlanesPark.getCommonPassCapacity();
    }

    @GET
    @Path("sort/range")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSortedByRange(
            @DefaultValue("false") @QueryParam("desc") boolean desc) {
        Sort.sort(passengerPlanesPark.getPark(), new ByRangeComporator(), desc);
        return passengerPlanesPark.toString();
    }

    @GET
    @Path("sort/model")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSortedByModel(
            @DefaultValue("false") @QueryParam("desc") boolean desc) {
        Sort.sort(passengerPlanesPark.getPark(), new ByModelComporator(), desc);
        return passengerPlanesPark.toString();
    }

    @GET
    @Path("search")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPlanesAsString(
            @DefaultValue("") @QueryParam("model") String model,
            @DefaultValue("0") @QueryParam("range") int range,
            @DefaultValue("0") @QueryParam("load") int maxLoadCapacity,
            @DefaultValue("0") @QueryParam("passengers") int maxPassCapacity) {

        return Search.searchResultAsString(passengerPlanesPark.findBy(model, range, maxLoadCapacity, maxPassCapacity));

    }

    @POST
    @Path("add")
    @Consumes(MediaType.TEXT_PLAIN)
    public void addNewPlanesText(File file) {

        passengerPlanesPark.addNewPlanesFromFile(file, new TxtFileReader());

    }

    @POST
    @Path("add")
    @Consumes(MediaType.TEXT_XML)
    public void addNewPlanesXML(File file) {

        passengerPlanesPark.addNewPlanesFromFile(file, new XmlFileReader());

    }

//    @GET
//    @Path("search")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Set<PassengerPlanes> getPlanesAsJSON(
//            @DefaultValue("") @QueryParam("model") String model,
//            @DefaultValue("0") @QueryParam("range") int range,
//            @DefaultValue("0") @QueryParam("load") int maxLoadCapacity,
//            @DefaultValue("0") @QueryParam("passengers") int maxPassCapacity) {
//
//        return passengerPlanesPark.findBy(model, range, maxLoadCapacity, maxPassCapacity);
//
//    }

}
