package com.db.vava;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Subclass {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer classId;

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

    public Integer getClassId() {
        return classId;
    }
}