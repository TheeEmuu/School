package edu.lvc.cds;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("reviews")
public class MyResource {
//
//    /**
//     * Method handling HTTP GET requests. The returned object will be sent
//     * to the client as "text/plain" media type.
//     *
//     * @return String that will be returned as a text/plain response.
//     */
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getIt() {
//        return "Got it!";
//    }
//
//
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getItID(@PathParam("id") int id){
//        return "Got it " + id;
//    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String newReview(String input){


        return null;
    }

    @PUT
    @Path("{id}/moderate")
    @Produces(MediaType.APPLICATION_JSON)
    public String moderate(JSONObject input){
        JSONObject ret = new JSONObject();

        String review = (String)input.get("review");

        int id = 8;
        String status = "unmoderated";

        ret.put("id", id);
        ret.put("stats" , status);

        return ret;
    }
}
