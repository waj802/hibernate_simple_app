import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DbController {

    public List<Class> selectAllGroups() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();

        try {
            tx = session.getTransaction();
            tx.begin();

//            Query query = session.createQuery("from Class");
//            Query query = session.createSQLQuery("SELECT * FROM group_list;");
//            Query query = session.createSQLQuery("SELECT * FROM group_list;").unwrap(org.hibernate.query.Query.class);
//            for(int i =0; i <2; i++){
//                System.out.println(query.getResultList().get(i));
//            }

//            System.out.println( (Class) query.getResultList().get(0));

//            List<Class> classes = query.getResultList();
//            System.out.println(classes.toString());
//            System.out.println(query.getResultList().size());

//            System.out.println((session.createCriteria(Class.class).list()).getClass());

            List<Class> cL = session.createCriteria(Class.class).list();


            tx.commit();
            session.close();
            sessionFactory.close();
            return cL;

        } catch (Exception e) {
            System.out.println(e.toString());
            session.close();
            sessionFactory.close();
            return null;
        }
    }

    public void addNewGroup(Class c) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx = session.getTransaction();
            tx.begin();

            session.saveOrUpdate(c);

            tx.commit();
            session.close();
            sessionFactory.close();

        } catch (Exception e) {
            System.out.println(e.toString());
            session.close();
            sessionFactory.close();
        }
    }

    public void deleteGroup(Class c) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx = session.getTransaction();
            tx.begin();

//            session.createSQLQuery("SET FOREIGN_KEY_CHECKS=0;");

            for(Student s : c.getStudentsList()){
                DbController.deleteStudent(s);
            }
            session.delete(c);

            tx.commit();
            session.close();
            sessionFactory.close();

        } catch (Exception e) {
            System.out.println(e.toString());
            session.close();
            sessionFactory.close();
        }
    }

    public static List<Student> selectAllStudents() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx = session.getTransaction();
            tx.begin();

//            Query query = session.createQuery("FROM Student");
//            Query query = session.createSQLQuery("SELECT * FROM group_list;");
            List<Student> sL = session.createCriteria(Student.class).list();
//            System.out.println(sL);

//            System.out.println(query.getResultList());

//            List<Class> classes = query.getResultList();
//            System.out.println(classes.toString());
//            System.out.println(query.getResultList().size());


            tx.commit();
            session.close();
            sessionFactory.close();
            return sL;

        } catch (Exception e) {
            System.out.println(e.toString());
            session.close();
            sessionFactory.close();
            return null;
        }
    }

    public void addNewStudent(Student s) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx = session.getTransaction();
            tx.begin();

            session.saveOrUpdate(s);

            tx.commit();
            session.close();
            sessionFactory.close();

        } catch (Exception e) {
            System.out.println(e.toString());
            session.close();
            sessionFactory.close();
        }
    }

    public static void deleteStudent(Student s) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx = session.getTransaction();
            tx.begin();

            session.delete(s);

            tx.commit();
            session.close();
            sessionFactory.close();

        } catch (Exception e) {
            System.out.println(e.toString());
            session.close();
            sessionFactory.close();
        }
    }

    public static void addPoints(Student s, double points) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx = session.getTransaction();
            tx.begin();

            s.setNumberOfPoints(s.getNumberOfPoints());
            session.saveOrUpdate(s);

            tx.commit();
            session.close();
            sessionFactory.close();

        } catch (Exception e) {
            System.out.println(e.toString());
            session.close();
            sessionFactory.close();
        }
    }

    public static void changeCondiction(Student s) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx = session.getTransaction();
            tx.begin();

            s.setStudentCondition(s.getStudentCondition());
            session.saveOrUpdate(s);

            tx.commit();
            session.close();
            sessionFactory.close();

        } catch (Exception e) {
            System.out.println(e.toString());
            session.close();
            sessionFactory.close();
        }
    }
}
