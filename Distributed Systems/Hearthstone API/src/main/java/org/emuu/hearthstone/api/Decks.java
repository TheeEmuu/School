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
    @Path("{archetype}/{code}")
    public String getDeck(@PathParam("archetype") String archetype, @PathParam("code") String code);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{archetype}/{code}")
    public String updateDeck(@PathParam("archetype") String archetype, @PathParam("code") String code);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{archetype}/{code}")
    public String newDeck(@PathParam("archetype") String archetype, @PathParam("code") String code);

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{archetype}/{code}")
    public String deleteDeck(@PathParam("archetype") String archetype, @PathParam("code") String code);
}
