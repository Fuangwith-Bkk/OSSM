package com.chan;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import java.util.logging.Logger;
import java.net.InetAddress;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import com.chan.client.BackendService;

@Path("/")
public class FrontendResource {

    @ConfigProperty(name = "app.name")
    String appName;

    @ConfigProperty(name = "app.version")
    String appVersion;

    @Inject
    @RestClient
    BackendService backendService;



    private final Logger logger = Logger.getLogger(FrontendResource.class.getName());

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
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

        Response response = backendService.request();
        int res_status = response.getStatus();
        String resMessage = response.readEntity(String.class);

        return Response.status(Response.Status.OK).entity(appName + " " +appVersion + " >> [" + res_status +"] " + resMessage).build();
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