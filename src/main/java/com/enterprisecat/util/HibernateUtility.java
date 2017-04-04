package com.enterprisecat.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by Nitin Reddy on 4/3/2017.
 */
public class HibernateUtility {
    private static HibernateUtility mInstance = null;
    public static HibernateUtility getInstance() { if (mInstance == null) { mInstance = new HibernateUtility(); } return mInstance; }

    private Session sess = null;

    public Session getSession() throws ClassNotFoundException {
        if (sess == null) { setupConnection(); }
        return sess;
    }

    public void setupConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
//      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dijon","root", "");

        //If the hibernate.cfg.xml is in a different path (i.e. not at the same location of the default package folder), pass the path to the configure method
        SessionFactory sessFac = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata().buildSessionFactory();
        sess = sessFac.openSession();
    }
}
