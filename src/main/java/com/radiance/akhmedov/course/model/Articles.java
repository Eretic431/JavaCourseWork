package com.radiance.akhmedov.course.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Articles {
    public Articles() {
    }

    public Articles(@NonNull String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
