package com.wtech.jersey;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloWorld")
public class HelloWorldRest {
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String textMessage(){
        return "hey JERSEY JAX-RS";
    }
    
  
}