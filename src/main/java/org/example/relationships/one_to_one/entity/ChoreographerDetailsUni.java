package org.example.relationships.one_to_one.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="details")
public class ChoreographerDetailsUni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="dance_group")
    private int group;

    @Column(name="dance_type")
    private String danceType;


    public ChoreographerDetailsUni() {
    }

    public ChoreographerDetailsUni(int group, String danceType) {
        this.group = group;
        this.danceType = danceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGroup() {
        return group;
    }

    public String getDanceType() {
        return danceType;
    }

    public void setDanceType(String programName) {
        this.danceType = programName;
    }



    @Override
    public String toString() {
        return "ChoreographerDetails{" +
                "id=" + id +
                ", group='" + group + '\'' +
                ", dance type='" + danceType +
                '}';
    }
}
