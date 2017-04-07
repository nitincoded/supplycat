package com.enterprisecat.controller;

import com.enterprisecat.biz.PartHandler;
import com.enterprisecat.entity.Part;
import com.enterprisecat.util.AuthenticationUtility;
import com.enterprisecat.util.GsonUtility;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by Developer on 4/7/17.
 */
public class PartController implements StandardCrudController {
    public void registerRoutes() {
        get("/list/part", this::index);
        get("/get/part/id/:id", this::getById);
        get("/get/part/code/:code", this::getByCode);
        post("/save/part", this::save);
        post("/delete/part/id/:id", this::deleteById);
        post("/delete/part/code/:code", this::deleteByCode);
    }

    public String index(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            return GsonUtility.getInstance().toJson(PartHandler.getList());
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String getById(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            String id = request.params(":id");
            return GsonUtility.getInstance().toJson(PartHandler.getById(Integer.parseInt(id)));
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String getByCode(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            String code = request.params(":code");
            return GsonUtility.getInstance().toJson(PartHandler.getByCode(code));
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String save(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            Part org = (Part) GsonUtility.getInstance().fromJson(request.body(), Part.class);
            PartHandler.save(org);
            return Boolean.toString(true);
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String deleteById(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            String id = request.params(":id");
            PartHandler.delete(PartHandler.getById(Integer.parseInt(id)));
            return Boolean.toString(true);
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String deleteByCode(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            String code = request.params(":code");
            PartHandler.delete(PartHandler.getByCode(code));
            return Boolean.toString(true);
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }}
