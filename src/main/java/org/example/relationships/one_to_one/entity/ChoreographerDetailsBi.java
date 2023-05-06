package org.example.relationships.one_to_one.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="details")
public class ChoreographerDetailsBi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="dance_group")
    private int group;

    @Column(name="dance_type")
    private String danceType;

    @OneToOne(mappedBy = "choreographerDetailsBi",
            cascade = {CascadeType.MERGE,
                        CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.PERSIST,
                        CascadeType.REFRESH})
    private ChoreographerBi choreographerBi;
    public ChoreographerBi getChoreographerBi() {
        return choreographerBi;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getDanceType() {
        return danceType;
    }

    public void setDanceType(String danceType) {
        this.danceType = danceType;
    }

    public void setChoreographerBi(ChoreographerBi choreographerBi) {
        this.choreographerBi = choreographerBi;
    }

    public ChoreographerDetailsBi() {
    }

    public ChoreographerDetailsBi(int group, String danceType) {
        this.group = group;
        this.danceType = danceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
