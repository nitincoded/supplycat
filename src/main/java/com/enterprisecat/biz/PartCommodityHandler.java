package com.enterprisecat.biz;

import com.enterprisecat.entity.PartCommodity;
import com.enterprisecat.util.HibernateUtility;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Developer on 4/7/17.
 */
public class PartCommodityHandler {
    public static List getList() throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM PartCommodity");
        return qry.getResultList();
    }

    public static PartCommodity getById(int a) throws Exception {
        return HibernateUtility.getInstance().getSession().get(PartCommodity.class, a);
    }

    public static PartCommodity getByCode(String a) throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM PartCommodity WHERE code=:code");
        qry.setParameter("code", a);
        return (PartCommodity) qry.getSingleResult();
    }

    public static void save(PartCommodity a) throws Exception {
        HibernateUtility.getInstance().getSession().saveOrUpdate(a);
    }

    public static void delete(PartCommodity a) throws Exception {
        HibernateUtility.getInstance().getSession().delete(a);
    }
}
