package com.chan;

import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.config.ConfigProperties;

@Path("/")
public class ApplicationResource {

    @ConfigProperty(name = "app.name")
    String appName;

    @ConfigProperty(name = "app.version")
    String appVersion;

    @ConfigProperty(name = "response.delay")
    int delay;

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
    @Produces(MediaType.TEXT_PLAIN)
    public Response request(@Context HttpHeaders headers){
        logger.info("/req");
        logger.info("app.name: " + appName);
        logger.info("app.version: " + appVersion);

        String userAgent = headers.getRequestHeader("user-agent").get(0);
        logger.info("user-agent:" + userAgent);

        try{
            Thread.sleep(delay);
        }catch(Exception ex){
            logger.severe(ex.getMessage());
        }

        return Response.status(Response.Status.OK).entity("Response from app.name: " + appName + ", app.version: " + appVersion + ", server name: " + getServerName() + ", User-Agent: " + userAgent).build();
    }


    private String getServerName(){
        try{
            String serverName = InetAddress.getLocalHost().getHostName();
            logger.info("Server Name: " + serverName);
            return serverName;
        }catch(Exception ex){
            logger.severe(ex.getMessage());
            return "Unknow server name.";
        }
    }


}


