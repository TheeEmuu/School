package org.emuu.hearthstone.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "decks" path)
 */
@Path("decks")
public interface Decks {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDecks();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDecksFiltered(@QueryParam("filter") String filter);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{archetype}")
    public String getArchetype(@PathParam("archeype") String archetype);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{archetype}/{id}")
    public String getDeck(@PathParam("archetype") String archetype, @PathParam("id") String id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{archetype}/{id}")
    public String updateDeck(@PathParam("archetype") String archetype, @PathParam("id") String id);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{archetype}/{id}")
    public String newDeck(@PathParam("archetype") String archetype, @PathParam("id") String id);

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{archetype}/{id}")
    public String deleteDeck(@PathParam("archetype") String archetype, @PathParam("id") String id);
}
