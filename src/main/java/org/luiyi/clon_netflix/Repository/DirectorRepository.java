package org.luiyi.clon_netflix.Repository;

import org.luiyi.clon_netflix.Entity.Director;
import org.luiyi.clon_netflix.Util.UtilEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DirectorRepository {

    public void insertDirector(Director director) {
        EntityManager em = UtilEntity.getEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(director);
        et.commit();

        System.out.println("Director added successfully");
    }

    public List<Director> getDirectors() {
        EntityManager em = UtilEntity.getEntityManager();
        List<Director> result = em.createQuery("FROM Director").getResultList();
        return result;
    }

    public Director getDirector(Integer id) {
        EntityManager em = UtilEntity.getEntityManager();
        Director res = em.find(Director.class, id);
        return res;
    }

    public void updateDirector(Director director) {
        EntityManager em = UtilEntity.getEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(director);
        et.commit();

        System.out.println("Director updated successfully");
    }

    public void deleteDirector(int directorId) {
        EntityManager em = UtilEntity.getEntityManager();
        EntityTransaction et = em.getTransaction();

        Director director = em.find(Director.class, directorId);

        et.begin();
        em.remove(director);
        et.commit();

        System.out.println("Director removed successfully");
    }
}

