package ro.cburcea.hackathon.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cburcea.hackathon.webapp.entities.Company;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByName(String name);
}