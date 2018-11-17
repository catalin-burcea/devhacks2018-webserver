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

import java.util.*;

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

    private static class Pair<T1, T2> {
        T1 first;
        T2 second;
        Pair(T1 a, T2 b) {
            first = a;
            second = b;
        }
    };

    private static class Comp implements Comparator<Pair<Company, Double>> {
        public int compare(Pair<Company, Double> a, Pair<Company, Double> b) {
            return Double.compare(a.second, b.second);
        }
    }

    @GetMapping(path = "/companies/recommendations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Company> getRecomandation(@RequestParam(value = "salary", required = false) Long salary,
                                          @RequestParam(value = "interview", required = false) Long interviews,
                                          @RequestParam(value = "env", required = false) Long environment,
                                          @RequestParam(value = "training", required = false) Long trainings,
                                          @RequestParam(value = "tag", required = false) String tag) {

        ArrayList<String> categories = new ArrayList<>();
        categories.add("Salaries");
        categories.add("Interviews");
        categories.add("Environment");
        categories.add("Trainings");
        Long gradeTotal = salary + interviews + environment + trainings;
        TreeMap<String, Double> weight = new TreeMap<>();
        weight.put("Salaries", (double)salary / gradeTotal);
        weight.put("Interviews", (double)interviews / gradeTotal);
        weight.put("Environment", (double)environment / gradeTotal);
        weight.put("Trainings", (double)trainings / gradeTotal);

        List<Review> reviews = reviewRepository.findAll();
        TreeMap<Long, ArrayList<Review>> reviewMap = new TreeMap<>();
        TreeMap<Long, Company> idToCompany = new TreeMap<>();

        for (Review r : reviews) {
            if (tag != null && r.getCompany().getTag().getName().equals(tag) == false) {
                continue;
            }

            Long id = r.getCompany().getId();
            if (reviewMap.get(id) == null) {
                reviewMap.put(id, new ArrayList<Review>());
            }
            reviewMap.get(id).add(r);
            idToCompany.put(id, r.getCompany());
        }

        ArrayList<Pair<Company, Double>> sorted = new ArrayList<>();
        for (Map.Entry< Long, ArrayList<Review> > e : reviewMap.entrySet()) {
            TreeMap<String, Integer> categorySum = new TreeMap<>();
            TreeMap<String, Integer> categoryNum = new TreeMap<>();

            for (String c : categories) {
                categorySum.put(c, 0);
                categoryNum.put(c, 0);
            }

            for (Review r : e.getValue()) {
                String cat = r.getCategory();
                categorySum.put(cat, categorySum.get(cat) + r.getRating());
                categoryNum.put(cat, categoryNum.get(cat) + 1);
            }

            double weightedAverage = 0.0;
            for (String cat : categories) {
                Integer total = categorySum.get(cat), num = categoryNum.get(cat);
                if (num == 0) {
                    continue;
                }

                weightedAverage += weight.get(cat) * ((double)total / num);
            }

            Long id = e.getKey();
            sorted.add(new Pair<Company, Double>(idToCompany.get(id), weightedAverage));
        }

        Collections.sort(sorted, new Comp());
        Collections.reverse(sorted);

        ArrayList<Company> ret = new ArrayList<>();
        for (Pair<Company, Double> p : sorted) {
            ret.add(p.first);
        }

        return ret;
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
