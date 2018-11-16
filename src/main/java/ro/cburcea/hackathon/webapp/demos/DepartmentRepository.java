package ro.cburcea.hackathon.webapp.demos;

import org.springframework.data.jpa.repository.JpaRepository;

interface DepartmentRepository extends JpaRepository<Department, Long> {

}