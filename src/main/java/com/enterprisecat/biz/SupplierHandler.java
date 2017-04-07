package com.enterprisecat.biz;

import com.enterprisecat.entity.Supplier;
import com.enterprisecat.util.HibernateUtility;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Developer on 4/7/17.
 */
public class SupplierHandler {
    public static List getList() throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM Supplier");
        return qry.getResultList();
    }

    public static Supplier getById(int a) throws Exception {
        return HibernateUtility.getInstance().getSession().get(Supplier.class, a);
    }

    public static Supplier getByCode(String a) throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM Supplier WHERE code=:code");
        qry.setParameter("code", a);
        return (Supplier) qry.getSingleResult();
    }

    public static void save(Supplier a) throws Exception {
        HibernateUtility.getInstance().getSession().saveOrUpdate(a);
    }

    public static void delete(Supplier a) throws Exception {
        HibernateUtility.getInstance().getSession().delete(a);
    }
}
