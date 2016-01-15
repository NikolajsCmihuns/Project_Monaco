package com.monaco.controllers;

import com.monaco.Entities.Health;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by maksimspuskels on 15/12/15.
 */

@Component
@Path("/health")
public class HealthController {

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Health health() {
        Health health = new Health("Jersey: Up and Running!");
        return health;
    }
}
