package com.example;

import Dao.mapping.UserEntity;
import Dao.mapping.UserVisite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cangou on 23/02/17.
 */
public class userDAO {
    private static SessionFactory sf;
    public void creer(UserEntity c){
        SessionFactory sf=null;
        Session sesion=null;
        Transaction tx=null;
        try{
            sf = new Configuration().configure("services/hibernate.xml").buildSessionFactory();

            sesion=sf.openSession();
            tx=sesion.beginTransaction();
            sesion.save(c);
            tx.commit();
            sesion.close();

        }catch(Exception ex){

        }
    }
    public void editer(UserEntity c){
        SessionFactory sf=null;
        Session sesion=null;
        Transaction tx=null;
        try{
            sf = new Configuration().configure("services/hibernate.xml").buildSessionFactory();
            sesion=sf.openSession();
            tx=sesion.beginTransaction();
            sesion.update(c);
            tx.commit();
            sesion.close();

        }catch(Exception ex){

        }
    }
    public List ChercherParNom(String nom){
        sf = new Configuration().configure("services/hibernate.xml").buildSessionFactory();
        Session sesion=sf.openSession();
        Query consultaSQL=sesion.createQuery("from UserEntity where logine='"+nom+"'");
        List<UserEntity> lista=consultaSQL.list();
        return lista;
    }
    public List ChercherParId(int id){
        sf = new Configuration().configure("services/hibernate.xml").buildSessionFactory();
        Session sesion=sf.openSession();
        Query consultaSQL=sesion.createQuery("from UserEntity where id='"+id+"'");
        List<UserEntity> lista=consultaSQL.list();
        return lista;
    }
    public void eliminar(UserEntity c){
        SessionFactory sf=null;
        Session sesion=null;
        Transaction tx=null;
        try{
            sf = new Configuration().configure("services/hibernate.xml").buildSessionFactory();
            sesion=sf.openSession();
            tx=sesion.beginTransaction();
            sesion.delete(c);
            tx.commit();
            sesion.close();

        }catch(Exception ex){

        }
    }
    public static List afficherTout(){
        sf = new Configuration().configure("services/hibernate.xml").buildSessionFactory();
        Session sesion=sf.openSession();
        Query consultaSQL=sesion.createQuery("from UserEntity ");
        List<UserEntity> lista=consultaSQL.list();
        return lista;
    }
    public static List afficherCOUNT(){
        sf = new Configuration().configure("services/hibernate.xml").buildSessionFactory();
        Session sesion=sf.openSession();
        Query consultaSQL=sesion.createQuery("select COUNT(pk),logine from UserEntity group by logine");
        List<Object[]>lista= consultaSQL.list();

        return lista;
    }
    public static List afficherCOUNTperDate(java.util.Date date){
        sf = new Configuration().configure("services/hibernate.xml").buildSessionFactory();
        Session sesion=sf.openSession();
        Query consultaSQL=sesion.createQuery("select COUNT(pk),logine,date from UserEntity group by logine,date HAVING date='"+date+"'");
        List<Object[]>lista= consultaSQL.list();

        return lista;
    }
    public static List afficherCOUNT2(){
        sf = new Configuration().configure("services/hibernate.xml").buildSessionFactory();
        Session sesion=sf.openSession();
        Query consultaSQL=sesion.createQuery("select COUNT(pk),date from UserEntity group by date");
        List<Object[]>lista= consultaSQL.list();

        return lista;
    }
    public static List afficherCOUNT3(){
        sf = new Configuration().configure("services/hibernate.xml").buildSessionFactory();
        Session sesion=sf.openSession();
        Query consultaSQL=sesion.createQuery("select COUNT(pk) as COUNT,date from UserEntity group by date");

        List<Object[]>lista= consultaSQL.list();
        List<UserVisite> result = new ArrayList<>();
        for (Object[] bjects : lista) {
            UserVisite userVisite = new UserVisite();
            userVisite.setCount(Long.valueOf((Long)bjects[0]).intValue());
            userVisite.setDate((Date)bjects[1]);
            result.add(userVisite);
        }

        return result;
    }
}
