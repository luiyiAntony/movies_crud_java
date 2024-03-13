package org.luiyi.clon_netflix.Repository;

import org.luiyi.clon_netflix.Entity.Movie;
import org.luiyi.clon_netflix.Util.UtilEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MovieRepository {

    public void insertMovie(Movie movie) {
        EntityManager em = UtilEntity.getEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(movie);
        et.commit();

        System.out.println("Movie added successfully");
    }

    public List<Movie> getMovies() {
        EntityManager em = UtilEntity.getEntityManager();
        List<Movie> movies = em.createQuery("FROM Movie").getResultList();
        return movies;
    }

    public Movie getMovie(int movieId) {
        EntityManager em = UtilEntity.getEntityManager();
        return em.find(Movie.class, movieId);
    }

    public Movie updateMovie(Movie movie) {
        EntityManager em = UtilEntity.getEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(movie);
        et.commit();

        System.out.println("Movie updated successfully");
        return movie;
    }

}
