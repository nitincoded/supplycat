package com.enterprisecat.controller;

import com.enterprisecat.biz.SupplierHandler;
import com.enterprisecat.entity.Supplier;
import com.enterprisecat.util.AuthenticationUtility;
import com.enterprisecat.util.GsonUtility;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by Developer on 4/7/17.
 */
public class SupplierController implements StandardCrudController {
    public void registerRoutes() {
        get("/list/supplier", this::index);
        get("/get/supplier/id/:id", this::getById);
        get("/get/supplier/code/:code", this::getByCode);
        post("/save/supplier", this::save);
        post("/delete/supplier/id/:id", this::deleteById);
        post("/delete/supplier/code/:code", this::deleteByCode);
    }

    public String index(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            return GsonUtility.getInstance().toJson(SupplierHandler.getList());
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
            return GsonUtility.getInstance().toJson(SupplierHandler.getById(Integer.parseInt(id)));
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
            return GsonUtility.getInstance().toJson(SupplierHandler.getByCode(code));
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }

    public String save(Request request, Response response) {
        try {
            if (!AuthenticationUtility.getInstance().validateAuthentication(request, response)) { response.status(401); return null; }

            Supplier org = (Supplier) GsonUtility.getInstance().fromJson(request.body(), Supplier.class);
            SupplierHandler.save(org);
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
            SupplierHandler.delete(SupplierHandler.getById(Integer.parseInt(id)));
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
            SupplierHandler.delete(SupplierHandler.getByCode(code));
            return Boolean.toString(true);
        }
        catch (Exception ex) {
            response.status(500);
            return null;
        }
    }
}
