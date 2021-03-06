package com.ethero.quest.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int age;

    private String name;
    private String surname;
    private String username;
    private String email;
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    private Interests interests = new Interests();

    @OneToMany
    private List<Link> links = new ArrayList<>();

    public User() {
    }

    public User(int age, String name, String surname, String username, String email, String gender, Interests interests) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Interests getInterests() {
        return interests;
    }

    public void setInterests(Interests interests) {
        this.interests = interests;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void addLink(String url, String rel){
        Link link = new Link();

        link.setLink(url);
        link.setRel(rel);

        links.add(link);
    }
}
