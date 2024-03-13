package org.luiyi.clon_netflix;

import org.luiyi.clon_netflix.Entity.Category;
import org.luiyi.clon_netflix.Entity.Director;
import org.luiyi.clon_netflix.Entity.Movie;
import org.luiyi.clon_netflix.Repository.CategoryRepository;
import org.luiyi.clon_netflix.Repository.DirectorRepository;
import org.luiyi.clon_netflix.Repository.MovieRepository;
import org.luiyi.clon_netflix.view.SwingApp;

import java.util.List;

public class Main {
    // UTILS
    private static void showDirectors() {
        DirectorRepository directorRepository = new DirectorRepository();
        List<Director> directors = directorRepository.getDirectors();
        directors.forEach(System.out::println);
    }
    private static void showMovies() {
        MovieRepository movieRepository = new MovieRepository();
        List<Movie> movies = movieRepository.getMovies();
        movies.forEach(System.out::println);
    }
    private static void showCategories() {
        CategoryRepository categoryRepository = new CategoryRepository();
        List<Category> categories = categoryRepository.getCategories();
        categories.forEach(System.out::println);
    }

    public static void main(String[] args) {
        CategoryRepository categoryRepository = new CategoryRepository();
        DirectorRepository directorRepository = new DirectorRepository();
        MovieRepository movieRepository = new MovieRepository();

        // CREATE
//        Category category = categoryRepository.getCategory(2);
//        Director director = directorRepository.getDirector(3);
//        Movie movie = new Movie(null, "Duna", 2021, 4, category.getId(), director.getId());
//        movieRepository.insertMovie(movie);

//        Director director = new Director(null, "Denis Villeneuve", "Canada", 1);
//        insertDirector(director);

/*
        Category category = new Category();
        category.setCategory_name("Anime");
        category.setClasification("PG");
        insertCategory(category);
*/

        // READ

//        List<Movie> movies = movieRepository.getMovies();
//        System.out.println(movies.get(2).category.toString());
//        System.out.println(movies.get(2).director.toString());
//        List<Director> directors = getDirectos();
//        List<Category> categories = getCategories();

        // UPDATE
//        Category category = categoryRepository.getCategory(4);
//        category.setCategory_name("anime");
//        categoryRepository.updateCategory(category);
//
//        Director director = directorRepository.getDirector(3);
//        director.setOscars(2);
//        directorRepository.updateDirector(director);

        // DELETE
//        Category category = getCategory(5);
//        deleteCategory(category);

        // UTILS
        //showDirectors();
        //showCategories();
        //showMovies();

        // UI
        SwingApp app = new SwingApp();
        app.setVisible(true);
    }
}