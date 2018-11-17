package ro.cburcea.hackathon.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cburcea.hackathon.webapp.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}