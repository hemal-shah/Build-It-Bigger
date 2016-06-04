package com.example.hemal.myapplication.backend;

import com.example.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeEndpointApi",
        version = "v1",
        resource = "jokeEndpoint",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.hemal.example.com",
                ownerName = "backend.myapplication.hemal.example.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    private static final Logger logger = Logger.getLogger(JokeEndpoint.class.getName());

    /**
     * This method gets the <code>Joke</code> object associated with the specified <code>id</code>.
     *
     * @return The <code>Joke</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getJokeEndpoint")
    public Joke getJokeEndpoint() {

        JokeProvider provider = new JokeProvider();
        Joke returnObject = new Joke();
        returnObject.setJoke(provider.getJoke());
        return returnObject;
    }
}