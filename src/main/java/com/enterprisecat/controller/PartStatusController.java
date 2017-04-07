package com.enterprisecat.controller;

import com.enterprisecat.biz.PartStatusHandler;
import com.enterprisecat.entity.PartStatus;
import com.enterprisecat.util.AuthenticationUtility;
import com.enterprisecat.util.GsonUtility;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by Developer on 4/7/17.
 */
public class PartStatusController implements StandardCrudController {
    public void registerRoutes() {
        get("/list/partstatus", this::index);
        get("/get/partstatus/id/:id", this::getById);
        get("/get/partstatus/code/:code", this::getByCode);
        post("/save/partstatus", this::save);
        post("/delete/partstatus/id/:id", this::deleteById);
        post("/delete/partstatus/code/:code", this::deleteByCode);
    }

    public String index(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            return GsonUtility.getInstance().toJson(PartStatusHandler.getList());
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
            return GsonUtility.getInstance().toJson(PartStatusHandler.getById(Integer.parseInt(id)));
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
            return GsonUtility.getInstance().toJson(PartStatusHandler.getByCode(code));
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String save(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            PartStatus org = (PartStatus) GsonUtility.getInstance().fromJson(request.body(), PartStatus.class);
            PartStatusHandler.save(org);
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
            PartStatusHandler.delete(PartStatusHandler.getById(Integer.parseInt(id)));
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
            PartStatusHandler.delete(PartStatusHandler.getByCode(code));
            return Boolean.toString(true);
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }
}
