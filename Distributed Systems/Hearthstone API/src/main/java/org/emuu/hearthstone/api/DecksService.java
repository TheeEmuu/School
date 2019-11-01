package org.emuu.hearthstone.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

@Path("decks")
public class DecksService implements Decks {
    @Override
    public String getDecks(String filter) {
        if(filter == null)
            filter = "";

        String sql = "SELECT Archetype FROM Decks WHERE Archetype LIKE ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + filter + "%");
            ResultSet rs = pstmt.executeQuery();

            JSONObject ret = new JSONObject();
            JSONArray list = new JSONArray();

            HashSet<String> added = new HashSet<>();
            while(rs.next()){
                String archetype = rs.getString("Archetype");

                if(!added.contains(archetype))
                    list.add(Main.BASE_URI + "decks/" + archetype);

                added.add(archetype);
            }

            ret.put("decks", list);

            return ret.toString();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public String getArchetype(String archetype) {
        String sql = "SELECT ID FROM Decks WHERE Archetype LIKE ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, archetype);
            ResultSet rs = pstmt.executeQuery();

            JSONObject ret = new JSONObject();
            JSONArray list = new JSONArray();
            while(rs.next()){
                list.add(Main.BASE_URI + "decks/" + archetype + "/" + rs.getString("ID"));
            }

            ret.put("decks", list);

            return ret.toString();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public String getDeck(String archetype, int id) {
        String sql = "SELECT Code FROM Decks WHERE ID = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            String ret = Deckstrings.readDeck(rs.getString(1)).toString();
            System.out.println(ret);
            return ret;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    @Override
    public String newDeck(String archetype, Code code) {
        String sql = "INSERT INTO Decks(Archetype,Code) VALUES(?,?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, archetype);
            pstmt.setString(2, code.getCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "SELECT ID FROM Decks WHERE Code LIKE ?";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, code.getCode());

            ResultSet rs = pstmt.executeQuery();

            JSONObject ret = new JSONObject();
            ret.put("link", Main.BASE_URI + "decks/" + archetype + "/" + rs.getInt(1));

            return ret.toString();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public String deleteDeck(String archetype, int id) {
        String sql = "DELETE FROM Decks WHERE ID = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
