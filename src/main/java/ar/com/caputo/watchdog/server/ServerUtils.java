package ar.com.caputo.watchdog.server;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class ServerUtils {
    
    public static final Gson GSON = new Gson();

    public static String buildResponse(Object content) {
        return GSON.toJson(Map.of("data", content));
    }

    public static String buildBulkResponse(List<?> content) {
        return GSON.toJson(Map.of(
                            "size", content.size(),
                            "data", content));
    }

}
