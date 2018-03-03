
package com.networknt.petstore;

import com.networknt.health.HealthGetHandler;
import com.networknt.info.ServerInfoGetHandler;
import com.networknt.petstore.handler.PetsGetHandler;
import com.networknt.petstore.handler.PetsPetIdDeleteHandler;
import com.networknt.petstore.handler.PetsPetIdGetHandler;
import com.networknt.petstore.handler.PetsPostHandler;
import com.networknt.server.HandlerProvider;
import io.undertow.Handlers;
import io.undertow.server.HttpHandler;
import io.undertow.util.Methods;

public class PathHandlerProvider implements HandlerProvider {
    @Override
    public HttpHandler getHandler() {
        return Handlers.routing()
        
            .add(Methods.GET, "/v1/health", new HealthGetHandler())
        
            .add(Methods.GET, "/v1/server/info", new ServerInfoGetHandler())
        
            .add(Methods.POST, "/v1/pets", new PetsPostHandler())
        
            .add(Methods.GET, "/v1/pets", new PetsGetHandler())
        
            .add(Methods.GET, "/v1/pets/{petId}", new PetsPetIdGetHandler())
        
            .add(Methods.DELETE, "/v1/pets/{petId}", new PetsPetIdDeleteHandler())
        
        ;
    }
}
