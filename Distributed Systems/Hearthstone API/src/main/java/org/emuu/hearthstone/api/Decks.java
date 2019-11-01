package org.emuu.hearthstone.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "decks" path)
 */
public interface Decks {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDecks(@QueryParam("filter") String filter);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{archetype}")
    public String getArchetype(@PathParam("archetype") String archetype);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{archetype}/{id}")
    public String getDeck(@PathParam("archetype") String archetype, @PathParam("id") int id);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{archetype}/new")
    public String newDeck(@PathParam("archetype") String archetype, Code code);

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{archetype}/{id}")
    public String deleteDeck(@PathParam("archetype") String archetype, @PathParam("id") int id);
}
