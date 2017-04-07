package com.enterprisecat.controller;

import com.enterprisecat.biz.PartCategoryHandler;
import com.enterprisecat.entity.PartCategory;
import com.enterprisecat.util.AuthenticationUtility;
import com.enterprisecat.util.GsonUtility;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by Developer on 4/7/17.
 */
public class PartCategoryController implements StandardCrudController {
    public void registerRoutes() {
        get("/list/partcategory", this::index);
        get("/get/partcategory/id/:id", this::getById);
        get("/get/partcategory/code/:code", this::getByCode);
        post("/save/partcategory", this::save);
        post("/delete/partcategory/id/:id", this::deleteById);
        post("/delete/partcategory/code/:code", this::deleteByCode);
    }

    public String index(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            return GsonUtility.getInstance().toJson(PartCategoryHandler.getList());
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
            return GsonUtility.getInstance().toJson(PartCategoryHandler.getById(Integer.parseInt(id)));
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
            return GsonUtility.getInstance().toJson(PartCategoryHandler.getByCode(code));
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String save(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            PartCategory org = (PartCategory) GsonUtility.getInstance().fromJson(request.body(), PartCategory.class);
            PartCategoryHandler.save(org);
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
            PartCategoryHandler.delete(PartCategoryHandler.getById(Integer.parseInt(id)));
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
            PartCategoryHandler.delete(PartCategoryHandler.getByCode(code));
            return Boolean.toString(true);
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }
}
