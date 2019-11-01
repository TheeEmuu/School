package org.emuu.hearthstone.api;

import org.json.simple.JSONObject;

import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Path("matchups")
public class MatchupsService implements Matchups{
    @Override
    public String getIt(String player, String opponent) {
        System.out.println("test");
        String sql = "SELECT Winrate FROM Matchups WHERE Player = ? AND Opponent = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, player);
            pstmt.setString(2, opponent);
            ResultSet rs = pstmt.executeQuery();

            JSONObject ret = new JSONObject();
            ret.put("winrate", rs.getDouble(1));
            System.out.println(ret);
            return ret.toString();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
