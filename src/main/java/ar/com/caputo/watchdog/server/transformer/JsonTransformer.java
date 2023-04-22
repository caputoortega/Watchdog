package ar.com.caputo.watchdog.server.transformer;

import ar.com.caputo.watchdog.server.ServerUtils;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    @Override
    public String render(Object model) {
        return ServerUtils.GSON.toJson(model);
    }
    
}
