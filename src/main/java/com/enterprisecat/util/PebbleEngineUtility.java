package com.enterprisecat.util;

import com.mitchellbosecke.pebble.PebbleEngine;

/**
 * Created by Developer on 4/7/17.
 */
public class PebbleEngineUtility {
    private static PebbleEngine templateEngine = null;
    public static PebbleEngine getTemplateEngine() { if (templateEngine == null) templateEngine = new PebbleEngine.Builder().build(); return templateEngine; }
}
