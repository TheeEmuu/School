package org.emuu.hearthstone.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class test {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:database.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(JSONObject match) {
        String sql = "INSERT INTO Matchups(player,opponent,winrate) VALUES(?,?,?)";
        System.out.println(match);

        String player = (String) match.get("player");
        String opponent = (String) match.get("opponent");
        double winrate = (double) match.get("winrate");

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, player);
            pstmt.setString(2, opponent);
            pstmt.setDouble(3, winrate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        test app = new test();

        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("D:\\Downloads\\data.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray matchups = (JSONArray) obj;

            matchups.forEach(match -> app.insert((JSONObject) match));
        }
        catch(Exception e){}
    }

}