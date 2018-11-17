package ro.cburcea.hackathon.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.cburcea.hackathon.webapp.entities.Company;
import ro.cburcea.hackathon.webapp.entities.Review;
import ro.cburcea.hackathon.webapp.entities.Tag;
import ro.cburcea.hackathon.webapp.entities.User;
import ro.cburcea.hackathon.webapp.repositories.CompanyRepository;
import ro.cburcea.hackathon.webapp.repositories.ReviewRepository;
import ro.cburcea.hackathon.webapp.repositories.TagRepository;
import ro.cburcea.hackathon.webapp.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private TagRepository tagRepository;

	@Bean
    CommandLineRunner initDatabase() {
		return args -> {
//            this.loadDb();
		};
	}

	private void loadDb(){
        Tag tag1 = new Tag("Java");
        Tag tag2 = new Tag("Javascript");
        Tag tag3 = new Tag("Python");
        Tag tag4 = new Tag("Banking");
        System.out.println("Preloading " + tagRepository.save(tag1));
        System.out.println("Preloading " + tagRepository.save(tag2));
        System.out.println("Preloading " + tagRepository.save(tag3));
        System.out.println("Preloading " + tagRepository.save(tag4));

        User user1 = new User("User1", "username1", "123456");
        User user2 = new User("User2", "username2", "123456");
        User user3 = new User("User3", "username3", "123456");
        User user4 = new User("User4", "username4", "123456");
        System.out.println("Preloading " + userRepository.save(user1));
        System.out.println("Preloading " + userRepository.save(user2));
        System.out.println("Preloading " + userRepository.save(user3));
        System.out.println("Preloading " + userRepository.save(user4));


        Company company1 = new Company("Company1", "desc", 30, "Bucharest", tag1);
        Company company2 = new Company("Company2", "desc", 550, "Bucharest", tag2);
        Company company3 = new Company("Company3", "desc", 100, "London", tag3);
        Company company4 = new Company("Company3", "desc", 1000, "Madrid", tag4);
        System.out.println("Preloading " + companyRepository.save(company1));
        System.out.println("Preloading " + companyRepository.save(company2));
        System.out.println("Preloading " + companyRepository.save(company3));
        System.out.println("Preloading " + companyRepository.save(company4));

        List<Review> reviews = new ArrayList<>();

        reviews.add( new Review("desc", 3, "Salaries", company1, user1) );
        reviews.add( new Review("desc", 1, "Salaries", company1, user3) );
        reviews.add( new Review("desc", 5, "Salaries", company1, user4) );
        reviews.add( new Review("desc", 4, "Interviews", company1, user1) );
        reviews.add( new Review("desc", 5, "Interviews", company1, user2) );
        reviews.add( new Review("desc", 4, "Interviews", company1, user4) );
        reviews.add( new Review("desc", 4, "Environment", company1, user4) );
        reviews.add( new Review("desc", 4, "Environment", company1, user1) );
        reviews.add( new Review("desc", 5, "Environment", company1, user2) );
        reviews.add( new Review("desc", 2, "Trainings", company1, user2) );
        reviews.add( new Review("desc", 5, "Trainings", company1, user1) );
        reviews.add( new Review("desc", 1, "Trainings", company1, user4) );
        reviews.add( new Review("desc", 3, "Salaries", company2, user1) );
        reviews.add( new Review("desc", 2, "Salaries", company2, user3) );
        reviews.add( new Review("desc", 1, "Salaries", company2, user2) );
        reviews.add( new Review("desc", 2, "Interviews", company2, user1) );
        reviews.add( new Review("desc", 5, "Interviews", company2, user3) );
        reviews.add( new Review("desc", 3, "Interviews", company2, user4) );
        reviews.add( new Review("desc", 2, "Environment", company2, user4) );
        reviews.add( new Review("desc", 2, "Environment", company2, user3) );
        reviews.add( new Review("desc", 1, "Environment", company2, user2) );
        reviews.add( new Review("desc", 5, "Trainings", company2, user2) );
        reviews.add( new Review("desc", 5, "Trainings", company2, user4) );
        reviews.add( new Review("desc", 4, "Trainings", company2, user1) );
        reviews.add( new Review("desc", 1, "Salaries", company3, user1) );
        reviews.add( new Review("desc", 5, "Salaries", company3, user4) );
        reviews.add( new Review("desc", 2, "Salaries", company3, user2) );
        reviews.add( new Review("desc", 4, "Interviews", company3, user1) );
        reviews.add( new Review("desc", 2, "Interviews", company3, user4) );
        reviews.add( new Review("desc", 3, "Interviews", company3, user2) );
        reviews.add( new Review("desc", 4, "Environment", company3, user4) );
        reviews.add( new Review("desc", 1, "Environment", company3, user2) );
        reviews.add( new Review("desc", 5, "Environment", company3, user1) );
        reviews.add( new Review("desc", 2, "Trainings", company3, user2) );
        reviews.add( new Review("desc", 3, "Trainings", company3, user3) );
        reviews.add( new Review("desc", 1, "Trainings", company3, user4) );
        reviews.add( new Review("desc", 1, "Salaries", company4, user4) );
        reviews.add( new Review("desc", 5, "Salaries", company4, user3) );
        reviews.add( new Review("desc", 2, "Salaries", company4, user2) );
        reviews.add( new Review("desc", 3, "Interviews", company4, user2) );
        reviews.add( new Review("desc", 4, "Interviews", company4, user3) );
        reviews.add( new Review("desc", 5, "Interviews", company4, user1) );
        reviews.add( new Review("desc", 1, "Environment", company4, user4) );
        reviews.add( new Review("desc", 2, "Environment", company4, user1) );
        reviews.add( new Review("desc", 2, "Environment", company4, user2) );
        reviews.add( new Review("desc", 2, "Trainings", company4, user4) );
        reviews.add( new Review("desc", 3, "Trainings", company4, user1) );
        reviews.add( new Review("desc", 5, "Trainings", company4, user2) );

        for (Review r : reviews) {
            System.out.println("Preloading " + reviewRepository.save(r));
        }


    }
}