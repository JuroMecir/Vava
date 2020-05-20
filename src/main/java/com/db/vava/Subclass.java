package com.db.vava;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Subclass {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer classId;

    // All features for the subclass stored in mysql
    private String feature1;
    private String feature2;
    private String feature3;
    private String feature4;
    private String feature5;
    private String feature6;
    private String feature7;
    private String feature8;
    private String feature9;
    private String feature10;

    public String getFeature1() {
        return feature1;
    }

    public String getFeature2() {
        return feature2;
    }

    public String getFeature3() {
        return feature3;
    }

    public String getFeature4() {
        return feature4;
    }

    public String getFeature5() {
        return feature5;
    }

    public String getFeature6() {
        return feature6;
    }

    public String getFeature7() {
        return feature7;
    }

    public String getFeature8() {
        return feature8;
    }

    public String getFeature9() {
        return feature9;
    }

    public String getFeature10() {
        return feature10;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

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