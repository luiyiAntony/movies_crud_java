package org.luiyi.clon_netflix.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name, origin_country;
    private Integer oscars;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;

    public Director() {
    }

    public Director(Integer id, String name, String origin_country, Integer oscars) {
        this.id = id;
        this.name = name;
        this.origin_country = origin_country;
        this.oscars = oscars;
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

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public Integer getOscars() {
        return oscars;
    }

    public void setOscars(Integer oscars) {
        this.oscars = oscars;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin_country='" + origin_country + '\'' +
                ", oscars=" + oscars +
                '}';
    }
}
