package com.enterprisecat.biz;

import com.enterprisecat.entity.PartUom;
import com.enterprisecat.util.HibernateUtility;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Developer on 4/7/17.
 */
public class PartUomHandler {
    public static List getList() throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM PartUom");
        return qry.getResultList();
    }

    public static PartUom getById(int a) throws Exception {
        return HibernateUtility.getInstance().getSession().get(PartUom.class, a);
    }

    public static PartUom getByCode(String a) throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM PartUom WHERE code=:code");
        qry.setParameter("code", a);
        return (PartUom) qry.getSingleResult();
    }

    public static void save(PartUom a) throws Exception {
        HibernateUtility.getInstance().getSession().saveOrUpdate(a);
    }

    public static void delete(PartUom a) throws Exception {
        HibernateUtility.getInstance().getSession().delete(a);
    }
}
