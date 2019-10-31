package org.emuu.hearthstone.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.Path;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

@Path("cards")
public class CardsService implements Cards{
    @Override
    public String getCards(String cardName) {
        JSONParser jsonParser = new JSONParser();

        try(FileReader reader = new FileReader("src/cards.collectible.json")){
            Object obj = jsonParser.parse(reader);

            JSONArray cardList = (JSONArray) obj;

            Iterator i = cardList.iterator();
            while(i.hasNext()){
                JSONObject card = (JSONObject) i.next();
                if(card.get("name").equals(cardName))
                    return card.toString();
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }

        return null;
    }



}
