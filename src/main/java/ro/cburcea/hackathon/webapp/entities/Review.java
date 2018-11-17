package ro.cburcea.hackathon.webapp.entities;

import javax.persistence.*;

@Entity
public class Review {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String description;
    private Integer rating;
    private String category;

    @ManyToOne
    private Company company;
    @ManyToOne
    private User user;

    public Review() {
    }

    public Review(String description, Integer rating, String category, Company company, User user) {
        this.description = description;
        this.rating = rating;
        this.category = category;
        this.company = company;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
