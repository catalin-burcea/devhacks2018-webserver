package ro.cburcea.hackathon.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cburcea.hackathon.webapp.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}