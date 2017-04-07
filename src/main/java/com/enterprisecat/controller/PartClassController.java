package com.enterprisecat.controller;

import com.enterprisecat.biz.PartClassHandler;
import com.enterprisecat.entity.PartClass;
import com.enterprisecat.util.AuthenticationUtility;
import com.enterprisecat.util.GsonUtility;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by Developer on 4/7/17.
 */
public class PartClassController implements StandardCrudController {
    public void registerRoutes() {
        get("/list/partclass", this::index);
        get("/get/partclass/id/:id", this::getById);
        get("/get/partclass/code/:code", this::getByCode);
        post("/save/partclass", this::save);
        post("/delete/partclass/id/:id", this::deleteById);
        post("/delete/partclass/code/:code", this::deleteByCode);
    }

    public String index(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            return GsonUtility.getInstance().toJson(PartClassHandler.getList());
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
            return GsonUtility.getInstance().toJson(PartClassHandler.getById(Integer.parseInt(id)));
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
            return GsonUtility.getInstance().toJson(PartClassHandler.getByCode(code));
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String save(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            PartClass org = (PartClass) GsonUtility.getInstance().fromJson(request.body(), PartClass.class);
            PartClassHandler.save(org);
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
            PartClassHandler.delete(PartClassHandler.getById(Integer.parseInt(id)));
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
            PartClassHandler.delete(PartClassHandler.getByCode(code));
            return Boolean.toString(true);
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }
}
