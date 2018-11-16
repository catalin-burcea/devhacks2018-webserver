package ro.cburcea.hackathon.webapp.demos;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping(path = "/getEmployee", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> getEmployee() {
        Employee employee = new Employee("Gigel", "developer");
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
