package org.luiyi.clon_netflix.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category_name, clasification;

    @OneToMany(mappedBy = "category")
    private List<Movie> movies;

    public Category() {
    }

    public Category(Integer id, String category_name, String clasification) {
        this.id = id;
        this.category_name = category_name;
        this.clasification = clasification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getClasification() {
        return clasification;
    }

    public void setClasification(String clasification) {
        this.clasification = clasification;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category_name='" + category_name + '\'' +
                ", clasification='" + clasification + '\'' +
                '}';
    }
}
