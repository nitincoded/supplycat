package com.enterprisecat;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import spark.Request;
import spark.Response;

import java.io.StringWriter;

import static spark.Spark.*;

/**
 * Created by Nitin Reddy on 4/5/2017.
 */
public class WebServer {
    PebbleEngine templateEngine = new PebbleEngine.Builder().build();

    public static void main(String[] args) {
        port(4567);
//        get("/", (request, response) -> "Hello");

        WebServer ws = new WebServer();

        get("/", ws::login);
        post("/login", ws::authenticate);
        get("/dashboard", ws::dashboard);
    }

    public String authenticate(Request request, Response response) {
        String username = request.attribute("inputUsername");
        String password = request.attribute("inputPassword");

        //TODO If success then proceed
        response.redirect("/dashboard");

        //TODO If failure then return to the login page and display a message

        return null; //We're redirecting so we don't have to bother with sending anything back
    }

    private boolean isLoggedIn() {
        return true;
    }

    public String login(Request request, Response response) throws Exception {
        //resp.header("Content-Encoding", "gzip");
        StringWriter stringWriter = new StringWriter();
        templateEngine.getTemplate("templates/home.html").evaluate(stringWriter);
        return stringWriter.toString();
    }

    public String dashboard(Request request, Response response) throws Exception {
        if (!isLoggedIn()) { response.redirect("/"); return null; }

        StringWriter stringWriter = new StringWriter();
        templateEngine.getTemplate("templates/dashboard.html").evaluate(stringWriter);
        return stringWriter.toString();
    }
}
