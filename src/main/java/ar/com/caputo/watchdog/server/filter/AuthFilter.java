package ar.com.caputo.watchdog.server.filter;

import spark.Filter;
import spark.Request;
import spark.Response;
import static spark.Spark.halt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

public class AuthFilter implements Filter {

    private final String secret;

    public AuthFilter(String secret) {
        this.secret = secret;
    }

    @Override
    public void handle(Request request, Response response) throws Exception {
        
        String token = request.headers("Authorization");
        
        if(token == null || !token.startsWith("Bearer ")) {
            response.status(401);
            halt();
            return;
        }

        String userToken = token.substring(7);
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            JWT.require(algorithm).build().verify(userToken);
        } catch (JWTVerificationException e) {
            response.status(401);
            halt();
        }

    }

    
    
}
