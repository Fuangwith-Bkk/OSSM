package com.chan;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ApplicationResource {

    private final Logger logger = Logger.getLogger(ApplicationResource.class.getName());

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/echo/{message}")
    @Produces(MediaType.APPLICATION_JSON)
    public String echo(@PathParam("message") String message){        
        return "echo: " + message;
    }

    @GET
    @Path("/req")
    @Produces(MediaType.APPLICATION_JSON)
    public Response request(@Context HttpHeaders headers){
        logger.info("/req");
        String userAgent = headers.getRequestHeader("user-agent").get(0);
        logger.info("user-agent:" + userAgent);
        return Response.status(Response.Status.OK).entity("Response from backend.").build();
    }


}


