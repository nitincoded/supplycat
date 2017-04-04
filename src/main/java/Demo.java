import com.enterprisecat.util.AuthenticationUtility;
import com.enterprisecat.util.HibernateUtility;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Nitin Reddy on 4/3/2017.
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
//        Session sess = HibernateUtility.getInstance().getSession();
//        Query qry = sess.createQuery("FROM Organization");
//        List lstOrgs = qry.list();
//
//        System.out.println("Hello world");
//
//        System.out.println(String.format("%d", lstOrgs.size()));

        String username = "admin", password = "root";
        String msg = Boolean.toString(AuthenticationUtility.getInstance().validateCredentials(username, password));
        System.out.println(msg);

        if (AuthenticationUtility.getInstance().isInitializedNow()) {
            System.out.println("Consider changing the default password for the admin user");
        }
    }
}
