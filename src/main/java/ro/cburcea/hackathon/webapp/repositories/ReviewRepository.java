package ro.cburcea.hackathon.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cburcea.hackathon.webapp.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}