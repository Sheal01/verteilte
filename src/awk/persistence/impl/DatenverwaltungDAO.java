package awk.persistence.impl;

import awk.persistence.IDatenverwaltungDAO;
import awk.persistence.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DatenverwaltungDAO implements IDatenverwaltungDAO
{

    public DatenverwaltungDAO(){}

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
    EntityManager em = emf.createEntityManager();



    public void anlegen(Object var0)
    {
        em.getTransaction().begin();
        em.persist(var0);
        em.flush();
        em.getTransaction().commit();


    }


    public List<Marines> showAllMarines()
    {
        String jpql = "select m from Marines m";

        Query query = em.createQuery(jpql);

        List<Marines> marine = query.getResultList();


        return marine;
    }


    public List<Waffen> getAllWeaponsPerRace(String race)
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "select w.name from Waffen w WHERE w.race = '" + race + "'";

        Query query = em.createQuery(jpql);

        List<Waffen> waffenMarines = query.getResultList();



        return waffenMarines;
    }

    public List<Marines> getMarineNames()
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "select m.name from Marines m";

        Query query = em.createQuery(jpql);

        List<Marines> marines = query.getResultList();



        return marines;
    }

    public List<Alien> getAlienNames()
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "select m.name from Alien m";

        Query query = em.createQuery(jpql);

        List<Alien> aliens = query.getResultList();



        return aliens;
    }


    public List<Predator> getPredNames()
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "select m.name from Predator m";

        Query query = em.createQuery(jpql);

        List<Predator> predators = query.getResultList();



        return predators;
    }



    public List<Marines> showMarinesWithID(int id)
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT m FROM Marines m WHERE m.id = " + id;
        Query query = em.createQuery(jpql);
        List<Marines> ma = query.getResultList();


        return ma;
    }

    public List<Alien> showAlienWithID(int id)
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT m FROM Alien m WHERE m.id = " + id;
        Query query = em.createQuery(jpql);
        List<Alien> ma = query.getResultList();


        return ma;
    }

    public List<Predator> showPredWithId(int id)
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT m FROM Predator m WHERE m.id = " + id;
        Query query = em.createQuery(jpql);
        List<Predator> ma = query.getResultList();



        return ma;
    }

    public List<Waffen> showAlienWeaponWithID(int id)
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT w FROM Waffen w WHERE w.id = " + id;
        Query query = em.createQuery(jpql);
        List<Waffen> foundWeapons = query.getResultList();



        return foundWeapons;
    }


    public List<Strategiekarte> showStrategiekarteWithID(int id)
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT k from Strategiekarte k WHERE k.id = " + id;
        Query query = em.createQuery(jpql);

        List<Strategiekarte> foundKarte = query.getResultList();

        return foundKarte;

    }

    public List<Umgebungskarte> showUmgebungskarteWithID(int id)
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT u FROM Umgebungskarte u WHERE u.id = " + id;
        Query query = em.createQuery(jpql);

        List<Umgebungskarte> foundKarte = query.getResultList();



        return foundKarte;
    }


    public List<Strategiekarte> showStrategiekartenWithName(String name)
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT s from Strategiekarte s WHERE s.name like '" + name +"'";

        Query query = em.createQuery(jpql);

        List<Strategiekarte> foundKarte = query.getResultList();


        return foundKarte;
    }


    public List<Umgebungskarte> showUmgebungskarteWithName(String name)
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT u from Umgebungskarte u WHERE u.name like '" + name + "'";
        Query query = em.createQuery(jpql);

        List<Umgebungskarte> foundKarte = query.getResultList();



        return foundKarte;
    }


    public List<Waffen> showWaffeWithName(String name)
    {

        String jpql = "SELECT w FROM Waffen w WHERE w.name like '" + name + "'";
        Query query = em.createQuery(jpql);

        List<Waffen> foundWaffe = query.getResultList();


        return foundWaffe;
    }




    public List<Marines> searchMarineWithName(String name)
    {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT m FROM Marines m WHERE m.name like '" + name + "'");

        List<Marines> foundMarines = query.getResultList();



        return foundMarines;
    }


    public List<Alien> searchAlienWithName(String name)
    {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT a from Alien a WHERE a.name like '" + name + "'");

        List<Alien> foundAlien = query.getResultList();



        return foundAlien;
    }


    public List<Predator> searchPredWithName(String name)
    {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT p FROM Predator p WHERE p.name like '" + name + "'");

        List<Predator> foundPred = query.getResultList();


        return foundPred;
    }

    public boolean changeWeapon(Waffen waffe)
    {
        EntityManager em = emf.createEntityManager();

        List <Waffen> foundWaffe = showWaffeWithName(waffe.getName());

        for (Waffen wa : foundWaffe)
        {
            System.out.println("ID" + wa.getId());

            em.getTransaction().begin();

            Waffen w = em.find(Waffen.class, wa.getId() );
            if (w!=null)
            {
                w.setName(waffe.getName());
                w.setType(waffe.getType());
                w.setRace(waffe.getRace());
                w.setStrength(waffe.getStrength());
                w.setRoa(waffe.getRoa());
                w.setAvv(waffe.getAvv());

                em.getTransaction().commit();

                return true;
            }
            else
            {
                return false;
            }


        }

        return false;




    }

}
