package com.enterprisecat.util;

import com.google.gson.Gson;

/**
 * Created by Developer on 4/5/17.
 */
public class GsonUtility {
    private static Gson instance = null;
    public static Gson getInstance() { if (instance==null) instance=new Gson(); return instance; }
    public String toJson(Object a) { return getInstance().toJson(a); }
    public Object fromJson(String a, Class b) { return getInstance().fromJson(a, b.getComponentType()); }
}
