package ro.cburcea.hackathon.webapp.demos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class EmployeeController {

	@Autowired
	private EmployeeRepository empRepository;

	@Autowired
	private DepartmentRepository depRepository;

	@GetMapping("/employees")
	List<Employee> all() {
		return empRepository.findAll();
	}

	@PostMapping("/employees/{departmentId}")
	Employee newEmployee(@RequestBody Employee newEmployee, @PathVariable Long departmentId) {
		Department department = depRepository.findById(departmentId).get();
		newEmployee.setDepartment(department);
		return empRepository.save(newEmployee);
	}

	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) {

		return empRepository.findById(id)
			.orElseThrow(() -> new ObjectNotFoundException(id));
	}

	@GetMapping("/employees/role")
	List<Employee> getEmployeesByRole(@RequestParam(value = "role") String role) {
		List<Employee> employees = empRepository.findByRole(role);
		System.out.println(employees);
		return employees;

	}

	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return empRepository.findById(id)
			.map(employee -> {
				employee.setName(newEmployee.getName());
				employee.setRole(newEmployee.getRole());
				return empRepository.save(employee);
			})
			.orElseGet(() -> {
				newEmployee.setId(id);
				return empRepository.save(newEmployee);
			});
	}

	@DeleteMapping("/employees/{id}")
	ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		empRepository.deleteById(id);
		return new ResponseEntity<>("Deleted employee: " + id, HttpStatus.OK);
	}
}