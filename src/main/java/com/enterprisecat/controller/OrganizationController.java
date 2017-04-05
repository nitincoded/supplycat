package com.enterprisecat.controller;

import static spark.Spark.*;

import com.enterprisecat.biz.OrganizationHandler;
import com.enterprisecat.entity.Organization;
import com.enterprisecat.util.GsonUtility;
import spark.Request;
import spark.Response;

/**
 * Created by Developer on 4/5/17.
 */
public class OrganizationController {
    public void registerRoutes() {
        get("/list/organization", this::index);
        get("/get/organization/id/:id", this::getById);
        get("/get/organization/code/:code", this::getByCode);
        post("/save/organization", this::save);
        post("/delete/organization/id/:id", this::deleteById);
        post("/delete/organization/code/:code", this::deleteByCode);
    }

    public String index(Request request, Response response) {
        try {
            return GsonUtility.getInstance().toJson(OrganizationHandler.getList());
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String getById(Request request, Response response) {
        try {
            String id = request.params(":id");
            return GsonUtility.getInstance().toJson(OrganizationHandler.getById(Integer.parseInt(id)));
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String getByCode(Request request, Response response) {
        try {
            String code = request.params(":code");
            return GsonUtility.getInstance().toJson(OrganizationHandler.getByCode(code));
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String save(Request request, Response response) {
        try {
            Organization org = (Organization) GsonUtility.getInstance().fromJson(request.body(), Organization.class);
            OrganizationHandler.save(org);
            return Boolean.toString(true);
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String deleteById(Request request, Response response) {
        try {
            String id = request.params(":id");
            OrganizationHandler.delete(OrganizationHandler.getById(Integer.parseInt(id)));
            return Boolean.toString(true);
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String deleteByCode(Request request, Response response) {
        try {
            String code = request.params(":code");
            OrganizationHandler.delete(OrganizationHandler.getByCode(code));
            return Boolean.toString(true);
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }
}
