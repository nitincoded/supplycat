package com.enterprisecat;

import com.enterprisecat.controller.*;
import com.mitchellbosecke.pebble.PebbleEngine;
import spark.Request;
import spark.Response;

import java.io.StringWriter;

import static spark.Spark.*;

/**
 * Created by Nitin Reddy on 4/5/2017.
 */
public class WebServer {
    public static void main(String[] args) {
//        port(4567);
        get("/", (request, response) -> "Hello");
        new OrganizationController().registerRoutes();
        new PartCategoryController().registerRoutes();
        new PartClassController().registerRoutes();
        new PartCommodityController().registerRoutes();
        new PartController().registerRoutes();
        new PartStatusController().registerRoutes();
        new PartUomController().registerRoutes();
        new StoreController().registerRoutes();
        new UserController().registerRoutes();
        new AuthenticationController().registerRoutes();
    }
}
