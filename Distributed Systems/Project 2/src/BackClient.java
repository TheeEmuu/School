import java.io.File;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BackClient {
    String ip;
    int port;
    public BackClient(String ip, int port){
        this.ip =ip;
        this.port =port;
    }
    public ArrayList<ArrayList<String>> callMethod(String method, List<List<String>> dict){
        String call = formatCall(method,dict);
        JSONObject jojo = callToServer(call);
        return synthesize(jojo);
    }
    private String formatCall(String method, List<List<String>> dict){//turn the method call into json format
        //dict: each inner arraylist is name, type, value
        String callJson = "{\"version\" : 1.0, \"id\" : ";//beginning of the call no matter what
        int id = (int)(Math.random()*30000);//randomly generated id number
        callJson+=id;
        callJson+=", \"methodName\" : \""+method+"\", \"params\" : ";
        callJson+=paramsToJson(dict);
        callJson+="}";
        //System.out.println(callJson);
        return callJson;//get rid of this
    }
    private String paramsToJson(List<List<String>> dict){//converts params to a json array. passed an arraylist of arraylists of strings. The inner arraylists are name, type, and value in that order.
        String out = "[ ";
        for(int i=0;i<dict.size();i++){
            out+="{ \"name\" : \"";
            out+=dict.get(i).get(0);
            out+="\", \"type\" : \"";
            String type = dict.get(i).get(1);
            out+=type;
            out+="\", \"value\" : ";
            if(type.equalsIgnoreCase("String"))
                out+="\""+dict.get(i).get(2)+"\"";
            else
                out+=dict.get(i).get(2);
            out+="}";
            if(i<dict.size()-1) out+=", ";
        }
        out+="]";
        return out;
    }
    private JSONObject callToServer(String s){//takes a json request in string form and sends it to the server, returning the response in jsonobject form
        //taken from monday's client and repurposed
        var client = HttpClient.newBuilder()
                .build();
        //I left this here in case reading in the json file threw an exception
        var request = HttpRequest.newBuilder()
                .uri(URI.create("http://"+ip+":"+port+"/"))
                .GET()
                .build();
        try {

            request = HttpRequest.newBuilder()
                    .uri(URI.create("http://"+ip+":"+port+"/"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(s, StandardCharsets.UTF_8))
                    .build();
        }
        catch(Exception e){
            System.out.println("Http Request failed to build");
        }
        try {
            //System.out.println(request);
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.statusCode());
            try {//turn the response into a json object
                String bod = response.body();
                JSONObject j = new JSONObject(bod);
                return j;
            }
            catch (Exception e){
                System.out.println("Unable to parse the json of response. Here it is in its raw form.");
                System.out.println(response.body());
            }
            /*
            for (var header : response.headers().map().keySet()) {
                System.out.print(header + ": ");
                for (var val : response.headers().map().get(header))
                    System.out.print(val + " ");
                System.out.println();
            }*/
        }
        catch (IOException e) {
            System.out.println("Error making request");
        }
        catch (InterruptedException e) {
            System.out.println("Connection interrupted");
        }

        return null;//if exception occurred
    }
    private ArrayList<ArrayList<String>> synthesize(JSONObject jsob){//turns the response jsonobject into arraylist<arraylist<string>> form
        try {
            int status = jsob.getInt("status");
            if(status==0){//no error - the return value is a json object

                if(jsob.isNull("return")) return new ArrayList<ArrayList<String>>();//if nothing was returned and no errors occurred, return an empty array.

                JSONObject ret = jsob.getJSONObject("return");
                return synthesizeReturn(ret);
            }
            else{//yes error
                String errormsg = jsob.getString("error");
                return singleReturnToArrayLists("Error code "+status+": "+errormsg);//If there's an error, return it as a single string
            }
        }
        catch(Exception e){
            System.out.println("failed to synthesize Json object");
        }
        return new ArrayList<ArrayList<String>>();//if synthesis failed, return empty arraylist
    }
    private ArrayList<ArrayList<String>> synthesizeReturn(JSONObject retob){//retob: The object in the return field. Should have fields name, type, value.
        try {
            String type = retob.getString("type");
            if (type.equalsIgnoreCase("array")) {
                return arrayToArrayLists(retob.getJSONArray("value"));
            }
            else {//return value is not an array - it's just a single value
                return singleReturnToArrayLists(retob.get("value").toString());
            }
        }
        catch(Exception e){
            System.out.println("Failed to synthesize the return object.");
            return new ArrayList<ArrayList<String>>();
        }
    }
    private ArrayList<ArrayList<String>> singleReturnToArrayLists(String ret){//if the return parameter isn't an array, we convert it to one of these.
        ArrayList<ArrayList<String>> alals = new ArrayList<>();
        ArrayList<String> als = new ArrayList<>();
        als.add(ret);
        alals.add(als);
        for(ArrayList<String> a:alals){
            for(String x:a){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        return alals;
    }
    private ArrayList<ArrayList<String>> arrayToArrayLists(JSONArray jsa){//jsa should be an array of jsonobjects. This converts it to an arraylist of strings, which is more readable.
        try {
            ArrayList<ArrayList<String>> alals = new ArrayList<>();
            for (int i = 0; i < jsa.length(); i++) {//iterate through the members of jsa, which are all jsonobjects
                ArrayList<String> als = new ArrayList<>();
                JSONObject ocur = jsa.getJSONObject(i);
                Iterator<String> keys = ocur.keys();
                while(keys.hasNext()){
                    String kee = keys.next();
                    als.add(kee+": "+ocur.get(kee));
                }
                alals.add(als);
            }
            /*
            for(ArrayList<String> a:alals){
                for(String x:a){
                    System.out.print(x+" ");
                }
                System.out.println();
            }*/
            return alals;
        }
        catch(Exception e){
            System.out.println("Error converting the returned array.");
            return new ArrayList<ArrayList<String>>();//return an empty arraylist if it failed.
        }
    }
}
