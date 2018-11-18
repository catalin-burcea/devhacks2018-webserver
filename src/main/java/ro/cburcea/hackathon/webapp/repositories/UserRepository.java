package ro.cburcea.hackathon.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cburcea.hackathon.webapp.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}