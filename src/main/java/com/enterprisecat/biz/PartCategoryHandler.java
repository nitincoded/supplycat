package com.enterprisecat.biz;

import com.enterprisecat.entity.PartCategory;
import com.enterprisecat.util.HibernateUtility;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Developer on 4/7/17.
 */
public class PartCategoryHandler {
    public static List getList() throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM PartCategory");
        return qry.getResultList();
    }

    public static PartCategory getById(int a) throws Exception {
        return HibernateUtility.getInstance().getSession().get(PartCategory.class, a);
    }

    public static PartCategory getByCode(String a) throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM PartCategory WHERE code=:code");
        qry.setParameter("code", a);
        return (PartCategory) qry.getSingleResult();
    }

    public static void save(PartCategory a) throws Exception {
        HibernateUtility.getInstance().getSession().saveOrUpdate(a);
    }

    public static void delete(PartCategory a) throws Exception {
        HibernateUtility.getInstance().getSession().delete(a);
    }
}
