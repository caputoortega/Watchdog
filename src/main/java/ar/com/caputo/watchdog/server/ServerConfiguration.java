package ar.com.caputo.watchdog.server;

import static spark.Spark.before;
import static spark.Spark.notFound;
import static spark.Spark.internalServerError;

import ar.com.caputo.watchdog.server.filter.AuthFilter;
import ar.com.caputo.watchdog.server.transformer.JsonTransformer;
import spark.Spark;

public class ServerConfiguration {

    private final AuthFilter AUTH;

    public ServerConfiguration(String secret) {
        this.AUTH = new AuthFilter(secret);
    }
    
    public void apply() {

        configure();
        registerCustomErrorHandlers();

    }

    private void configure() {

        Spark.defaultResponseTransformer(new JsonTransformer());
        before("/api", this.AUTH);

    }

    private void registerCustomErrorHandlers() {

        notFound((req, resp) -> {
            resp.status(404);
            return ServerUtils.buildResponse("Requested resource could not be found");
        });

        internalServerError((req, resp) -> {
            resp.status(500);
            return ServerUtils.buildResponse("An error ocurred on the server side while handling your request!");
        });



    }

}
