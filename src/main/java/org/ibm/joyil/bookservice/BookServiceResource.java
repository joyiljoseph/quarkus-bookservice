package org.ibm.joyil.bookservice;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bookinfo")
public class BookServiceResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/getBookInfo/{query}")
    public String getBookInfo(@PathParam("query") String query) {
        String responseJson = "{}";
        try{ 

            String url = "https://www.googleapis.com/books/v1/volumes?q="+query;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse <String> response;
            response = client.send(req,BodyHandlers.ofString());
            responseJson = response.body();
        }catch(Exception e){
            responseJson = "{'error', '"+e.getMessage()+"'}";
        }
        return responseJson;
    }

    
}