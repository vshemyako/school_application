package by.intexsoft.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

/**
 * Simple blueprint for creating News instances, which later on will be added
 * into a database
 */
@Entity
@Table(name = "categories")
public class Category extends AbstractEntity {

    private static final long serialVersionUID = -111133652215083093L;

    @Column(name = "name")
    public String name;

    @ManyToMany(fetch = LAZY, mappedBy = "categories")
    @JsonIgnore
    public List<News> news;
}
