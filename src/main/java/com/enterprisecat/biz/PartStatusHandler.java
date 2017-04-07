package com.enterprisecat.biz;

import com.enterprisecat.entity.PartStatus;
import com.enterprisecat.util.HibernateUtility;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Developer on 4/7/17.
 */
public class PartStatusHandler {
    public static List getList() throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM PartStatus");
        return qry.getResultList();
    }

    public static PartStatus getById(int a) throws Exception {
        return HibernateUtility.getInstance().getSession().get(PartStatus.class, a);
    }

    public static PartStatus getByCode(String a) throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM PartStatus WHERE code=:code");
        qry.setParameter("code", a);
        return (PartStatus) qry.getSingleResult();
    }

    public static void save(PartStatus a) throws Exception {
        HibernateUtility.getInstance().getSession().saveOrUpdate(a);
    }

    public static void delete(PartStatus a) throws Exception {
        HibernateUtility.getInstance().getSession().delete(a);
    }
}
