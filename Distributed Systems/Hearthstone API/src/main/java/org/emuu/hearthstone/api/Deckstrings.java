package org.emuu.hearthstone.api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;

import com.clearspring.analytics.util.Varint;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Deckstrings {
    public static JSONObject readDeck(String deckCode){
        JSONObject ret = new JSONObject();
        JSONArray decklist = new JSONArray();

        ArrayList<DeckEntry> list = translateDbfId(deckToDbfIds(deckCode));

        for(DeckEntry x : list) {
            JSONObject obj = new JSONObject();
            try {
                obj.put("quantity", x.getQuantity());
                obj.put("card", x.getName());
                decklist.add(obj);
            }catch(Exception e){}
        }

        ret.put("decklist", decklist);
        return ret;
    }

    private static ArrayList<Integer> deckToDbfIds(String deckCode){
        byte[] decode = Base64.getDecoder().decode(deckCode);

        ArrayList<byte[]> toVarInt = new ArrayList<>();
        ArrayList<Byte> arr = new ArrayList<>();
        for(byte x : decode){
            arr.add(x);
            // Reads the decoded base64 as VarInts
            if((x & 0x80) != 0x80){
                byte[] num = new byte[arr.size()];
                for(int i = 0; i < num.length; i++){
                    num[i] = arr.get(i);
                }
                toVarInt.add(num);
                arr.clear();
            }
        }

        ArrayList<Integer> dbfIds = new ArrayList<>();
        for(byte[] x : toVarInt){
            dbfIds.add(Varint.readUnsignedVarInt(x));
        }

        return dbfIds;
    }

    private static ArrayList<DeckEntry> translateDbfId(ArrayList<Integer> dbfIds){
        ArrayList<DeckEntry> deck = new ArrayList<>();

        int singleCopies = dbfIds.get(5);
        for (int i = 6; i < 6 + singleCopies; i++) {
            deck.add(new DeckEntry(1, getCard(dbfIds.get(i))));
        }
        int doubleCoppies = dbfIds.get(6+singleCopies);
        for (int i = 6 + singleCopies + 1; i < 6 + singleCopies + doubleCoppies; i++){
            deck.add(new DeckEntry(2, getCard(dbfIds.get(i))));
        }

        return deck;
    }

    private static String getCard(int dbfId) {
        JSONParser jsonParser = new JSONParser();

        try(FileReader reader = new FileReader("src/cards.collectible.json")){
            Object obj = jsonParser.parse(reader);

            JSONArray cardList = (JSONArray) obj;

            Iterator i = cardList.iterator();
            while(i.hasNext()){
                JSONObject card = (JSONObject) i.next();

                if(card.get("dbfId").equals((long)dbfId))
                    return (String) Main.BASE_URI + "cards/" + card.get("name");
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

class DeckEntry{
    public int getQuantity() {
        return quantity;
    }
    public String getName(){
        return name;
    }

    int quantity;
    String name;

    public DeckEntry(int quantity, String name){
        this.quantity = quantity;
        this.name = name;
    }

    @Override
    public String toString() {
        return quantity + " " + name;
    }
}
