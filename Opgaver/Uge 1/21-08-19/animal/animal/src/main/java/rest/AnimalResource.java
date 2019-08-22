/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Animal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Marcus
 */
@Path("animal")
public class AnimalResource {
    private static Animal dog = new Animal("Dog", 2010 ,"Bark");
    private static Animal duck = new Animal("Duck", 2018 ,"Quack");
    private static Animal cat = new Animal("Cat", 2015 ,"Miaow");
    private static Animal fish = new Animal("Fish", 2019 ,"Blob");
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Det her er en kat";
    }
    
//    @GET
//    @Path("/random")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String javaMethod(){
//        return "Det her er en hund";
//    }
    
    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public String randomAnimalSelection(){
        List<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(duck);
        animals.add(cat);
        animals.add(fish);
        Random rand = new Random();
        Animal randomElement = animals.get(rand.nextInt(animals.size()));
        return new Gson().toJson(randomElement);
    }
    
    
    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
