package com.ethero.quest.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Interests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ElementCollection
    private List<String> interest = new ArrayList<>();

    @ElementCollection
    private List<String> subInterests = new ArrayList<>();


    public Interests() {
    }

    public Interests(List<String> interest, List<String> subInterests) {
        this.interest = interest;
        this.subInterests = subInterests;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public List<String> getSubInterests() {
        return subInterests;
    }

    public void setSubInterests(List<String> subInterests) {
        this.subInterests = subInterests;
    }
}
