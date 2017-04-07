package com.enterprisecat.util;

import com.enterprisecat.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import spark.Request;
import spark.Response;

/**
 * Created by Developer on 4/4/17.
 */
public class AuthenticationUtility {
    private static AuthenticationUtility instance = null;
    public static AuthenticationUtility getInstance() {
        if (instance == null) instance = new AuthenticationUtility();
        return instance;
    }

    private boolean isInitializedNow = false;

    public static void setInstance(AuthenticationUtility instance) {
        AuthenticationUtility.instance = instance;
    }

    public boolean isInitializedNow() {
        return isInitializedNow;
    }

    public void setInitializedNow(boolean initializedNow) {
        isInitializedNow = initializedNow;
    }

    private void checkInitialization(Session sess) {
        Query qry = sess.createQuery("SELECT count(1) FROM User");
        Long cnt = (Long) qry.uniqueResult();
        if (cnt == 0) {
            User adminUser = new User();
            adminUser.setCode("admin");
            adminUser.setPassword("root");
            adminUser.setName("Administrator");
            sess.save(adminUser);
            isInitializedNow = true;
        }
    }

    public boolean validateCredentials(String username, String password) throws ClassNotFoundException {
        Session sess = HibernateUtility.getInstance().getSession();

        checkInitialization(sess);

        Query qry = sess.createQuery("SELECT count(1) FROM User WHERE code=:code AND password=:password");
        qry.setParameter("code", username);
        qry.setParameter("password", password);
        Long cnt = (Long) qry.uniqueResult();
        if (cnt == 1) return true;
        else return false;
    }

    public boolean validateAuthentication(Request request, Response response) throws Exception {
        return AuthenticationUtility.getInstance().validateCredentials(
                request.headers("username"),
                request.headers("password")
        );
    }
}
