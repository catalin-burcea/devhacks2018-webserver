package ro.cburcea.hackathon.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.cburcea.hackathon.webapp.entities.Company;
import ro.cburcea.hackathon.webapp.repositories.CompanyRepository;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping(path = "/companies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

}
