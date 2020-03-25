package kikahatest.mavenplugin.pages;

import kikahatest.mavenplugin.core.commons.HelloWorldService;
import kikaha.urouting.api.GET;
import kikaha.urouting.api.Path;
import kikaha.urouting.api.PathParam;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Path("/")
public class IndexResource {

    @Inject
    private HelloWorldService service;

    @GET
    @Path("hello/{name}")
    public String hello(@PathParam("name") String name) {
        val finalName = name == null ? "mate" : name;
        return service.getMessage(name);
    }
}

