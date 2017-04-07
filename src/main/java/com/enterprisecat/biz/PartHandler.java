package com.enterprisecat.biz;

import com.enterprisecat.entity.Part;
import com.enterprisecat.util.HibernateUtility;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Developer on 4/7/17.
 */
public class PartHandler {
    public static List getList() throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM Part");
        return qry.getResultList();
    }

    public static Part getById(int a) throws Exception {
        return HibernateUtility.getInstance().getSession().get(Part.class, a);
    }

    public static Part getByCode(String a) throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM Part WHERE code=:code");
        qry.setParameter("code", a);
        return (Part) qry.getSingleResult();
    }

    public static void save(Part a) throws Exception {
        HibernateUtility.getInstance().getSession().saveOrUpdate(a);
    }

    public static void delete(Part a) throws Exception {
        HibernateUtility.getInstance().getSession().delete(a);
    }
}
