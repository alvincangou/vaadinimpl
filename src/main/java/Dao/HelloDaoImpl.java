package Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Dao.mapping.UserEntity;
/**
 * Created by acangou on 18/11/16.
 */
public class HelloDaoImpl implements HelloDao {
    public static int n=0;

    String url = "jdbc:mysql://localhost:3306/test";
    String username = "pablo";
    String password = "admin";

    private static SessionFactory factory;



/*    public void persisitLogin(String login)  {

      EntityManagerFactory emf = new Persistence().createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       UserEntity user = new UserEntity();
        user.setLogine(login);
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        user.setDate(sqlDate);
        user.setPk(n);
        em.persist(user);
        em.getTransaction().commit();
       n++;




    }*/
  public void persisitLogin(String login)  {
      try{

          factory = new Configuration().configure("services/hibernate.xml").buildSessionFactory();
      }catch (Throwable ex) {
          System.err.println("Failed to create sessionFactory object." + ex);
          throw new ExceptionInInitializerError(ex);
      }
      HelloDaoImpl ME = new HelloDaoImpl();
      n++;

      java.util.Date utilDate = new java.util.Date();
         java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
  Session session = factory.openSession();
    Transaction tx = null;
    Integer UserID = null;
      try{
        tx = session.beginTransaction();
        //UserEntity employee = new UserEntity(login,sqlDate);
          UserEntity employee = new UserEntity();
          employee.setLogine(login);
          employee.setDate(sqlDate);
        UserID = (Integer) session.save(employee);
        tx.commit();
    }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace();
    }finally {
        session.close();
    }

  }
}