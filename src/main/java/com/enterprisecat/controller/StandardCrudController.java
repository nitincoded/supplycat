package com.enterprisecat.controller;

import spark.Request;
import spark.Response;

/**
 * Created by Developer on 4/7/17.
 */
public interface StandardCrudController extends BaseController {
    String index(Request request, Response response);
    String getById(Request request, Response response);
    String getByCode(Request request, Response response);
    String save(Request request, Response response);
    String deleteById(Request request, Response response);
    String deleteByCode(Request request, Response response);
}
