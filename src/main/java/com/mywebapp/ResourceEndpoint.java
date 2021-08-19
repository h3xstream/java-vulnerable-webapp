package com.mywebapp;

import javax.activation.MimetypesFileTypeMap;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.File;

public class ResourceEndpoint {

    @Inject
    MyControllerFacade controller;

    @GET
    @Path("/images/{image}")
    @Produces("image/*")
    public Response getImage(@PathParam("image") String image) {
        File f = new File(image);

        if (!f.exists()) {
            throw new WebApplicationException(404);
        }

        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok(f, mt).build();
    }

    @GET
    @Path("/images_thumbs/{image}")
    @Produces("images/*")
    public Response getImageThumbnail(@PathParam("image") String image) {
        byte[] content = controller.getImageThumbnail(image,false);

        return Response.ok().entity(content).build();
    }
}
