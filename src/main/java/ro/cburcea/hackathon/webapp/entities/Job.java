package ro.cburcea.hackathon.webapp.entities;

import javax.persistence.*;

@Entity
public class Job {

    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String title;
    @Lob
    @Column(name = "CONTENT", length = 512)
    private String description;
    private Integer salary;

    @ManyToOne
    private Company company;

    public Job() {
    }

    public Job(String title, String description, Integer salary, Company company) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}