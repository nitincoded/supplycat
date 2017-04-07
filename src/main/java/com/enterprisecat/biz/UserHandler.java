package com.enterprisecat.biz;

import com.enterprisecat.entity.User;
import com.enterprisecat.util.HibernateUtility;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Developer on 4/7/17.
 */
public class UserHandler {
    public static List getList() throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM User");
        return qry.getResultList();
    }

    public static User getById(int a) throws Exception {
        return HibernateUtility.getInstance().getSession().get(User.class, a);
    }

    public static User getByCode(String a) throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM User WHERE code=:code");
        qry.setParameter("code", a);
        return (User) qry.getSingleResult();
    }

    public static void save(User a) throws Exception {
        HibernateUtility.getInstance().getSession().saveOrUpdate(a);
    }

    public static void delete(User a) throws Exception {
        HibernateUtility.getInstance().getSession().delete(a);
    }
}
