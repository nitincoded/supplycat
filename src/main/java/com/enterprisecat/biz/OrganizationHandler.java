package com.enterprisecat.biz;

import com.enterprisecat.entity.Organization;
import com.enterprisecat.util.HibernateUtility;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Developer on 4/4/17.
 */
public class OrganizationHandler {
    public static List getList() throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM Organization");
        return qry.getResultList();
    }

    public static Organization getById(int a) throws Exception {
        return HibernateUtility.getInstance().getSession().get(Organization.class, a);
    }

    public static Organization getByCode(String a) throws Exception {
        Query qry = HibernateUtility.getInstance().getSession().createQuery("FROM Organization WHERE code=:code");
        qry.setParameter("code", a);
        return (Organization) qry.getSingleResult();
    }

    public static void save(Organization a) throws Exception {
        HibernateUtility.getInstance().getSession().saveOrUpdate(a);
    }

    public static void delete(Organization a) throws Exception {
        HibernateUtility.getInstance().getSession().delete(a);
    }
}
