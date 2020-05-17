package com.db.vava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Class {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String feature_1;
    private String feature_2;
    private String feature_3;
    private String feature_4;
    private String feature_5;
    private String feature_6;
    private String feature_7;
    private String feature_8;
    private String feature_9;
    private String feature_10;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}