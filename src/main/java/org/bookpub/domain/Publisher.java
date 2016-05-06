package org.bookpub.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by MaMingJiang on 2016/2/16.
 */
@Entity
public class Publisher {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
