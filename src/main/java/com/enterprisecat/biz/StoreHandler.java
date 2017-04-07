package com.enterprisecat.biz;

import com.enterprisecat.entity.Store;
import com.enterprisecat.util.HibernateUtility;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Developer on 4/7/17.
 */
public class StoreHandler {
    public static List getList() throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM Store");
        return qry.getResultList();
    }

    public static Store getById(int a) throws Exception {
        return HibernateUtility.getInstance().getSession().get(Store.class, a);
    }

    public static Store getByCode(String a) throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM Store WHERE code=:code");
        qry.setParameter("code", a);
        return (Store) qry.getSingleResult();
    }

    public static void save(Store a) throws Exception {
        HibernateUtility.getInstance().getSession().saveOrUpdate(a);
    }

    public static void delete(Store a) throws Exception {
        HibernateUtility.getInstance().getSession().delete(a);
    }
}
