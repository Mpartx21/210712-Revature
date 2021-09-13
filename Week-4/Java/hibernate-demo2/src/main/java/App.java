import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ){
        System.out.println("Proejct started...");

        // create a configuration object
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");

        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();

        // create employee
        Student employee  =new Student();
        employee.setId(35);
        employee.setName("Mark");
        employee.setCity("Windy CIty ");


        // save the employee
        session.save(employee);

        // commit the transaction
        t.commit();
        // close the session
        session.close();
    }
}
