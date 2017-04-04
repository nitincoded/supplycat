import com.enterprisecat.util.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Nitin Reddy on 4/3/2017.
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        Session sess = HibernateUtility.getInstance().getSession();
        Query qry = sess.createQuery("FROM Organization");
        List lstOrgs = qry.list();

        System.out.println("Hello world");

        System.out.println(String.format("%d", lstOrgs.size()));
    }
}
