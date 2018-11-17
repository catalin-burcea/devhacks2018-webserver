package ro.cburcea.hackathon.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cburcea.hackathon.webapp.entities.Company;
import ro.cburcea.hackathon.webapp.entities.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompany(Company comp);
}