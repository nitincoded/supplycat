package com.enterprisecat.biz;

import com.enterprisecat.entity.PartClass;
import com.enterprisecat.util.HibernateUtility;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Developer on 4/7/17.
 */
public class PartClassHandler {
    public static List getList() throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM PartClass");
        return qry.getResultList();
    }

    public static PartClass getById(int a) throws Exception {
        return HibernateUtility.getInstance().getSession().get(PartClass.class, a);
    }

    public static PartClass getByCode(String a) throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM PartClass WHERE code=:code");
        qry.setParameter("code", a);
        return (PartClass) qry.getSingleResult();
    }

    public static void save(PartClass a) throws Exception {
        HibernateUtility.getInstance().getSession().saveOrUpdate(a);
    }

    public static void delete(PartClass a) throws Exception {
        HibernateUtility.getInstance().getSession().delete(a);
    }
}
