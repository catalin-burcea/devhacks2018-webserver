package ro.cburcea.hackathon.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.cburcea.hackathon.webapp.demos.ObjectNotFoundException;
import ro.cburcea.hackathon.webapp.entities.Company;
import ro.cburcea.hackathon.webapp.entities.Review;
import ro.cburcea.hackathon.webapp.repositories.CompanyRepository;
import ro.cburcea.hackathon.webapp.repositories.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping(path = "/companies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Company> getCompanies(@RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "location", required = false) String location,
                                      @RequestParam(value = "tag", required = false) String tag) {
        List<Company> companies = companyRepository.findAll();
        List<Company> ret = new ArrayList<>();
        for (Company comp : companies) {
            if (    (name == null || comp.getName().compareTo(name) == 0) &&
                    (location == null || comp.getLocation().compareTo(location) == 0) &&
                    (tag == null || comp.getTag().getName().compareTo(tag) == 0)   ) {
                ret.add(comp);
            }
        }

        return ret;

//        if (location == null) {
//            if (name == null) {
//                return companyRepository.findAll();
//            }
//            return companyRepository.findByName(name);
//        }
//
//        List<Company> companies = companyRepository.findByLocation(location);
//        if (name == null) {
//            return companies;
//        }
//
//        List<Company> arr = new ArrayList<>();
//        for (Company comp : companies) {
//            if (comp.getName().compareTo(name) == 0) {
//                arr.add(comp);
//            }
//        }
//        return arr;
    }


    @GetMapping(path = "/companies/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Company getCompaniesById(@PathVariable Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

    @GetMapping(path = "/companies/{id}/reviews", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Review> getReviewsByCompanyId(@PathVariable Long id) {
        Company comp = companyRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
        return reviewRepository.findByCompany(comp);
    }



//    @GetMapping(path = "/companies/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public List<Company> getCompaniesByName(@PathVariable String name) {
//        List<Company> ret = companyRepository.findByName(name);
//        return ret;
//    }


}
