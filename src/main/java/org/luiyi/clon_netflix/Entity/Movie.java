package org.luiyi.clon_netflix.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer year, stars;

    @Column(name = "category_id")
    private Integer idCategory;
    @Column(name = "director_id")
    private Integer idDirector;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    public Category category;

    @ManyToOne
    @JoinColumn(name = "director_id", insertable = false, updatable = false)
    public Director director;

    public Movie() {
    }

    public Movie(Integer id, String name, Integer year, Integer stars, Integer category, Integer director) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.stars = stars;
        this.idCategory = category;
        this.idDirector = director;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getCategory() {
        return idCategory;
    }

    public void setCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getDirector() {
        return idDirector;
    }

    public void setDirector(Integer idDirector) {
        this.idDirector = idDirector;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", stars=" + stars +
                ", category=" + idCategory +
                ", director=" + idDirector +
                '}';
    }
}

