package ro.cburcea.hackathon.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cburcea.hackathon.webapp.entities.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}