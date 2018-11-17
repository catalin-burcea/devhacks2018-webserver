package ro.cburcea.hackathon.webapp.entities;

import javax.persistence.*;

@Entity
public class Company {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String name;
    @Lob
    @Column(name="CONTENT", length=512)
    private String description;
    private Integer nrOfEmployees;
    private String location;

    @ManyToOne
    private Tag tag;

    public Company() {
    }

    public Company(String name, String description, Integer nrOfEmployees, String location, Tag tag) {
        this.name = name;
        this.description = description;
        this.nrOfEmployees = nrOfEmployees;
        this.location = location;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNrOfEmployees() {
        return nrOfEmployees;
    }

    public void setNrOfEmployees(Integer nrOfEmployees) {
        this.nrOfEmployees = nrOfEmployees;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
