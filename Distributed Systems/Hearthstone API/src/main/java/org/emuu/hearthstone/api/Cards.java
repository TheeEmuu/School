package org.emuu.hearthstone.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface Cards {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public String getCards(@PathParam("name") String cardName);
}
