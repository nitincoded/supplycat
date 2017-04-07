package com.enterprisecat.controller;

import com.enterprisecat.util.PebbleEngineUtility;
import com.mitchellbosecke.pebble.PebbleEngine;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

import java.io.StringWriter;

/**
 * Created by Developer on 4/7/17.
 */
public class AuthenticationController implements BaseController {
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
        PebbleEngineUtility.getTemplateEngine().getTemplate("templates/home.html").evaluate(stringWriter);
        return stringWriter.toString();
    }

    @Override
    public void registerRoutes() {
        get("/login", this::login);
        post("/authenticate", this::authenticate);
    }
}
